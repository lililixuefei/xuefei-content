package concurrentProgramming.thread_pool;

/**
 * 线程池介绍
 *
 * @version 1.0
 * @author: xuefei
 * @date: 2021/3/29 11:51 上午
 */
public class IntroduceTest {
    /**
     * Java 中的线程池是运用场景最多的并发框架，几乎所有需要异步或并发执行任务的
     * 程序都可以使用线程池。在开发过程中，合理地使用线程池能够带来 3 个好处。
     * 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
     * 第二：提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
     * 第三：提高线程的可管理性。线程是稀缺资源，如果无限制地创建，不仅会消耗系
     * 统资源，还会降低系统的稳定性，使用线程池可以进行统一分配、调优和监控。
     */

    /**
     * 当提交一个新任务到线程池时，线程池的处理流程如下。
     * 线程池判断核心线程池里的线程是否都在执行任务。如果不是，则创建一个新的工
     * 作线程来执行任务。如果核心线程池里的线程都在执行任务，则进入下个流程。
     * 线程池判断工作队列是否已经满。如果工作队列没有满，则将新提交的任务存储在
     * 这个工作队列里。如果工作队列满了，则进入下个流程。
     * 线程池判断线程池的线程是否都处于工作状态。如果没有，则创建一个新的工作线
     * 程来执行任务。如果已经满了，则交给饱和策略来处理这个任务。
     */

    /**
     * ThreadPoolExecutor 执行 execute 方法分下面 4 种情况。
     * 1、 如果当前运行的线程少于 corePoolSize，则创建新线程来执行任务（注意，执行这一步骤需要获取全局锁）。
     * 2、 如果运行的线程等于或多于 corePoolSize，则将任务加入 BlockingQueue。
     * 3、 如果无法将任务加入 BlockingQueue（队列已满），则创建新的线程来处理任务（注意，执行这一步骤需要获取全局锁）。
     * 4、 如果创建新线程将使当前运行的线程超出 maximumPoolSize，任务将被拒绝，并调用 RejectedExecutionHandler.rejectedExecution()方法。
     */

    /**
     * ThreadPoolExecutor 采取上述步骤的总体设计思路，是为了在执行 execute()方法时，
     * 尽可能地避免获取全局锁（那将会是一个严重的可伸缩瓶颈）。在 ThreadPoolExecutor 完
     * 成预热之后（当前运行的线程数大于等于 corePoolSize），几乎所有的 execute()方法调用
     * 都是执行步骤 2，而步骤 2 不需要获取全局锁。
     * 源码分析：上面的流程分析让我们很直观地了解了线程池的工作原理，让我们再通
     * 过源代码来看看是如何实现的，线程池执行任务的方法如下。
     */
//    public void execute(Runnable command) {
//        if (command == null) throw new NullPointerException();
//            // 如果线程数小于基本线程数，则创建线程并执行当前任务
//        if (poolSize >= corePoolSize || !addIfUnderCorePoolSize(command)) {
//            // 如线程数大于等于基本线程数或线程创建失败，则将当前任务放到工作队列中。
//            if (runState == RUNNING && workQueue.offer(command)) {
//                if (runState != RUNNING || poolSize == 0)
//                    ensureQueuedTaskHandled(command);
//            }
//            // 如果线程池不处于运行中或任务无法放入队列，并且当前线程数量小于最大允许的线程数量，
//            // 则创建一个线程执行任务。
//            else if (!addIfUnderMaximumPoolSize(command))
//                // 抛出 RejectedExecutionException 异常
//                reject(command); // is shutdown or saturated } }
//
}
