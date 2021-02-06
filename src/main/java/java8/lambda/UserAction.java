package java8.lambda;

import java.util.function.Consumer;

/**
 * @description: 用户行为
 * @author: xuefei
 * @date: 2021/02/06 15:03
 */
public class UserAction {
    public static void main(String[] args) {
        Button button = new Button();
        int a = 1;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("hello xuefei" + a);
            }
        });


        button.testConsumerFunction(new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        });

        button.testConsumerFunction((e) -> {
            System.out.println(e.toString());
        });
    }
}
