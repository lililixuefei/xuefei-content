package concurrentProgramming.tools;

import java.util.concurrent.CountDownLatch;

/**
 * 等待多线程完成的 CountDownLatch
 *
 * @version 1.0
 * @author: xuefei
 * @date: 2021/3/29 11:06 上午
 */
public class CountDownLatchTest {

    /**
     * 注意 计数器必须大于等于 0，只是等于 0 时候，计数器就是零，调用 await 方
     * 法时不会阻塞当前线程。CountDownLatch 不可能重新初始化或者修改 CountDownLatch
     * 对象的内部计数器的值。一个线程调用 countDown 方法 happen-before，另外一个线程调
     * 用 await 方法。
     */
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println(2);
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("3");
    }
}
