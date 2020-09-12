package concurrentProgramming;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @description: 同步模式--保护性暂停
 * 即 Guarded Suspension，用在一个线程等待另一个线程的执行结果
 * 要点
 * 有一个结果需要从一个线程传递到另一个线程，让他们关联同一个 GuardedObject
 * 如果有结果不断从一个线程到另一个线程那么可以使用消息队列（见生产者/消费者）
 * JDK 中，join 的实现、Future 的实现，采用的就是此模式
 * 因为要等待另一方的结果，因此归类到同步模式
 * @author: xuefei
 * @date: 2020/07/29 14:37
 */
@Slf4j
public class GuardedSuspensionDemo {
    public static void main(String[] args) {
        final GuardedObject guardedObject = new GuardedObject();
        // 一个线程等待另一个线程的执行结果
        new Thread(() -> {
            try {
                int download = download();
                log.debug("down complete...");
                guardedObject.complete(download);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
        log.debug("waiting...");
        // 主线程阻塞等待
        Object response = guardedObject.get();
        log.debug("get response:{} lines", response);

    }

    public static int download() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}

@Slf4j
class GuardedObjectV2 {
    private Object response;
    private final Object lock = new Object();

    public Object get(long millis) {
        synchronized (lock) {
            // 1.记录最初的时间
            long begin = System.currentTimeMillis();
            // 2.已经经历的时间
            long timePassed = 0;
            while (response == null) {
                // 4.假设 millis 是1000，结果 400 时被唤醒了，那么还有600 要等
                long waitTime = millis - timePassed;
                log.debug("waitTime:{}", waitTime);
                if (waitTime <= 0) {
                    log.debug("break...");
                    break;
                }
                try {
                    lock.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 3、如果提前被唤醒，这时已经经历的时间假设为400
                timePassed = System.currentTimeMillis() - begin;
                log.debug("timePassed:{},Object is null {}",timePassed,response == null);
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (lock) {
            // 条件满足，通知等待线程
            this.response = response;
            lock.notifyAll();
        }
    }
}

// 不带超时版本
class GuardedObject {
    private Object response;
    private final Object lock = new Object();

    public Object get() {
        synchronized (lock) {
            while (response == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (lock) {
            // 条件满足，通知等待线程
            this.response = response;
            lock.notifyAll();
        }
    }
}
