package guide;

/**
 * @description: 跳台阶问题
 * @author: xuefei
 * @date: 2020/07/21 12:07
 */
public class JumpSteps {
    public static void main(String[] args) {
        int i = jumpFloor(5);
        System.out.println(i);
    }

    public static int jumpFloor(int number){
        if(number == 0){
            return 0;
        }
        if(number == 1){
            return 1;
        }
        if(number == 2){
            return 2;
        }
        int first = 1, second = 2, third = 0;
        for (int i = 0; i < number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
