package concurrentProgramming.tools;

import java.util.concurrent.CyclicBarrier;

/**
 * 同步屏障 CyclicBarrier
 * CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情
 * 是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏
 * 障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。
 *
 * @version 1.0
 * @author: xuefei
 * @date: 2021/3/29 11:14 上午
 */
public class CyclicBarrierTest {

    private static CyclicBarrier c = new CyclicBarrier(2);

    /**
     * CyclicBarrier 还提供一个更高级的构造函数 CyclicBarrier（int parties，Runnable
     * barrier-Action），用于在线程到达屏障时，优先执行 barrierAction，方便处理更复杂的业
     * 务场景
     */
    private static CyclicBarrier c2 = new CyclicBarrier(3, new A());

    public static void main(String[] args) {
//        extracted();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c2.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();
        try {
            c2.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }

    private static void extracted() {
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
            }
            System.out.println(1);
        }).start();
        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }


}
