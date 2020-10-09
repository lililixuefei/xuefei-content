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
public class AsynchronousCallDemo {
    public static void main(String[] args) throws Exception {

//        test4();
        test5();

        // 创建异步执行任务:
//        ExecutorService computeService = Executors.newFixedThreadPool(1);
//        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(ConcurrentDemo::fetchPrice, computeService);
//        // 如果执行成功:
//        cf.thenAccept((result) -> {
//            System.out.println("price: " + result);
//        });
//        // 如果执行异常:
//        cf.exceptionally((e) -> {
//            e.printStackTrace();
//            return null;
//        });
//        computeService.shutdown();
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
//        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Lock lock = new ReentrantLock();
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }

    /**
     * 评价
     * 1、可以让调用线程异步处理结果，实际是其他线程去同步等待
     * 2、可以方便地分离不同职责的线程池
     * 3、以任务为中心，而不是以线程为中心
     */
    private static void test4() {
        // 进行计算的线程池
        ExecutorService computeService = Executors.newFixedThreadPool(1);
        // 接收结果的线程池
        ExecutorService resultService = Executors.newFixedThreadPool(1);
        log.debug("开始");
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            return 10;
        }, computeService).thenAcceptAsync((result) -> {
            log.debug("结果为:{}", result);
        }, resultService);

        System.out.println("hello");
//        resultService.shutdown();
//        computeService.shutdown();
    }

    private static void test5() {
        ExecutorService consumer = Executors.newFixedThreadPool(1);
        ExecutorService producer = Executors.newFixedThreadPool(1);
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        log.debug("开始");
        producer.submit(() -> {
            log.debug("开始");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            try {
                queue.put(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.submit(() -> {
            try {
                Integer result = queue.take();
                log.debug("结果为:{}", result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("hello");

        consumer.shutdown();
        producer.shutdown();
    }
}
