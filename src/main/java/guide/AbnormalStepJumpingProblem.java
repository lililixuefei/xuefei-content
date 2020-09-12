package guide;

/**
 * @description: 变态跳台阶问题
 * @author: xuefei
 * @date: 2020/07/21 15:06
 */
public class AbnormalStepJumpingProblem {

    public static void main(String[] args) {
        System.out.println(jumpFloorII(5));
    }

    public static int jumpFloorII(int number){
        return 1 << --number;
    }
}
