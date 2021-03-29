package concurrentProgramming.tools;

/**
 * CyclicBarrier 和 CountDownLatch 的区别
 *
 * @version 1.0
 * @author: xuefei
 * @date: 2021/3/29 11:29 上午
 */
public class CountDownLatchWithCyclicBarrier {
    /**
     * CountDownLatch 的计数器只能使用一次，而 CyclicBarrier 的计数器可以使用 reset()
     * 方法重置。所以 CyclicBarrier 能处理更为复杂的业务场景。例如，如果计算发生错误，
     * 可以重置计数器，并让线程重新执行一次。
     * CyclicBarrier 还提供其他有用的方法，比如 getNumberWaiting 方法可以获得 CyclicBarrier 阻塞的线程数量。
     * isBroken()方法用来了解阻塞的线程是否被中断。执行完之后会返回 true
     */
}
