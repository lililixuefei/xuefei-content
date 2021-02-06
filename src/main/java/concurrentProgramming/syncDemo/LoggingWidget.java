package concurrentProgramming.syncDemo;

/**
 * @description:
 * @author: xuefei
 * @date: 2020/10/24 14:51
 */
public class LoggingWidget extends Widget{

    @Override
    public synchronized void doSomething() {
        System.out.println("LoggingWidget++++" + this.getClass().getName());
        System.out.println("LoggingWidget doSomething...");
        super.doSomething();
    }
}
