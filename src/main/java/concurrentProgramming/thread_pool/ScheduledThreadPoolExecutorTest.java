package concurrentProgramming.thread_pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @author: xuefei
 * @date: 2021/3/29 2:18 下午
 */
@Slf4j
public class ScheduledThreadPoolExecutorTest {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3,
                r -> new Thread(r,"xuefei")
        );
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            log.info(Thread.currentThread().getName() + "打印出 hello world");
        }, 1, 1, TimeUnit.SECONDS);
    }
}
