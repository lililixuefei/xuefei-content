package concurrentProgramming.application;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuefei
 * @version 1.0
 * @date 2020/10/9 10:33
 */
@Slf4j
public class SynchronousCallDemo {

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    static int result = 0;

    /**
     * join 实现（同步）
     * 评价
     * 1、需要外部共享变量，不符合面向对象封装的思想
     * 2、必须等待线程结束，不能配合线程池使用
     *
     * @throws InterruptedException
     */
    private static void test1() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            result = 10;
        }, "t1");
        t1.start();
        t1.join();
        log.debug("结果为:{}", result);
    }

    /**
     * Future 实现（同步）
     * 评价
     * 1、规避了使用 join 之前的缺点
     * 2、可以方便配合线程池使用
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void test2() throws InterruptedException, ExecutionException {
        log.debug("开始");
        FutureTask<Integer> result = new FutureTask<>(() -> {
            log.debug("开始");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            return 10;
        });
        new Thread(result, "t1").start();
        log.debug("结果为:{}", result.get());
    }

    /**
     * 评价
     * 1、仍然是 main 线程接收结果
     * 2、get 方法是让调用线程同步等待
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void test3() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        log.debug("开始");
        Future<Integer> result = service.submit(() -> {
            log.debug("开始");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            return 10;
        });
        log.debug("结果为:{}, result 的类型:{}", result.get(), result.getClass());

        service.shutdown();
    }
}

