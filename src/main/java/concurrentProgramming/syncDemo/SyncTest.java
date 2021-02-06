package concurrentProgramming.syncDemo;

/**
 * @description: 内置锁测试
 * @author: xuefei
 * @date: 2020/10/24 14:50
 */
public class SyncTest {
    public static void main(String[] args) {
        Widget widget = new LoggingWidget();
//        widget.doSomething();
        String[] states = widget.getStates();
        for (int i = 0; i < states.length; i++) {
            states[i] = "a";
        }
        for (String state : widget.getStates()) {
            System.out.println(state);
        }

    }
}
