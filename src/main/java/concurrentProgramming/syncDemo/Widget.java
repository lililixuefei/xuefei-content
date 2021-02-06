package concurrentProgramming.syncDemo;

/**
 * @description:
 * @author: xuefei
 * @date: 2020/10/24 14:50
 */
public class Widget {
    private String[] states = new String[]{"s","t","r"};

    public String[] getStates() {
        return states;
    }

    public Widget() {
        EventListener eventListener = new EventListener() {
            @Override
            public void onEvent() {
                System.out.println(this.getClass().getName());
                doSomething();
            }
        };
        eventListener.onEvent();
    }

    public static void main(String[] args) {
       Widget widget = new Widget();
    }

    public synchronized void doSomething(){
        System.out.println("Widget++++"+this.getClass().getName());
        System.out.println("Widget doSomethinf...");
    }
}
