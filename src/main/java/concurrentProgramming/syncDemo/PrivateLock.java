package concurrentProgramming.syncDemo;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: xuefei
 * @date: 2020/10/31 16:25
 */
public class PrivateLock {
    private final Object object = new Object();

    public void someMethod() {
        synchronized (object){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello"+Thread.currentThread().getName());
        }
    }
}
