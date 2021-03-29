package concurrentProgramming.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 控制并发线程数的 Semaphore
 *
 * @version 1.0
 * @author: xuefei
 * @date: 2021/3/29 11:30 上午
 */
public class SemaphoreTest {
    /**
     * Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线
     * 程，以保证合理的使用公共资源。
     * 多年以来，我都觉得从字面上很难理解 Semaphore 所表达的含义，只能把它比作是
     * 控制流量的红绿灯。比如××马路要限制流量，只允许同时有一百辆车在这条路上行使，
     * 其他的都必须在路口等待，所以前一百辆车会看到绿灯，可以开进这条马路，后面的车
     * 会看到红灯，不能驶入××马路，但是如果前一百辆中有 5 辆车已经离开了××马路，那么
     * 后面就允许有 5 辆车驶入马路，这个例子里说的车就是线程，驶入马路就表示线程在执
     * 行，离开马路就表示线程执行完成，看见红灯就表示线程被阻塞，不能执行。
     */

    /**
     * 应用场景
     * Semaphore 可以用于做流量控制，特别是公用资源有限的应用场景，比如数据库连
     * 接。假如有一个需求，要读取几万个文件的数据，因为都是 IO 密集型任务，我们可以启
     * 动几十个线程并发地读取，但是如果读到内存后，还需要存储到数据库中，而数据库的
     * 连接数只有 10 个，这时我们必须控制只有 10 个线程同时获取数据库连接保存数据，否
     * 则会报错无法获取数据库连接。这个时候，就可以使用 Semaphore 来做流量控制，如代
     * Semaphore 还提供一些其他方法，具体如下。
     * 1、 intavailablePermits()：返回此信号量中当前可用的许可证数。
     * 2、 intgetQueueLength()：返回正在等待获取许可证的线程数。
     * 3、 booleanhasQueuedThreads()：是否有线程正在等待获取许可证。
     * 4、 void reducePermits（int reduction）：减少 reduction 个许可证，是个 protected 方
     * 法。
     * 5、 Collection getQueuedThreads()：返回所有等待获取许可证的线程集合，是个protected 方法。
     */

    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    /**
     * 在代码中，虽然有 30 个线程在执行，但是只允许 10 个并发执行。Semaphore 的构
     * 造方法 Semaphore（int permits）接受一个整型的数字，表示可用的许可证数量。
     * Semaphore（10）表示允许 10 个线程获取许可证，也就是最大并发数是 10。Semaphore
     * 的用法也很简单，首先线程使用 Semaphore 的 acquire()方法获取一个许可证，使用完之
     * 后调用 release()方法归还许可证。还可以用 tryAcquire()方法尝试获取许可证。
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
