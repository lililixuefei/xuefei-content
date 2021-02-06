package concurrentProgramming.visibilityDemo;

/**
 * @description: 不可见性测试
 * @author: xuefei
 * @date: 2020/10/24 15:25
 */
public class NoVisibility {

    private static int number;
    private static Boolean flag;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while(!flag){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        flag = true;
    }
}
