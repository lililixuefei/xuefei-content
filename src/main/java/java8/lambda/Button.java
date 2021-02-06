package java8.lambda;

import java.util.function.Consumer;

/**
 * @description: 按钮
 * @author: xuefei
 * @date: 2021/02/06 15:04
 */
public class Button {

    public void addActionListener(ActionListener actionListener){
        actionListener.actionPerformed(new ActionEvent());
        System.out.println("hello world");
    }

    public void testConsumerFunction(Consumer consumer){
        System.out.println("hello java");
        String name = "jinjin";
        consumer.accept(name);
    }
}
