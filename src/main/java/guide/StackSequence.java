package guide;

import java.util.Stack;

/**
 * @description: 栈的压入，弹出序列
 * @author: xuefei
 * @date: 2020/07/23 16:09
 */
public class StackSequence {
    public static void main(String[] args) {

    }

    public static boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> stack = new Stack<Integer>();
        // 用于标识弹出的序列
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            // 如果栈不为空，且栈顶元素等于弹出序列
            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                // 出栈
                stack.pop();
                // 弹出序列向后一位
                popIndex++;
            }
        }
        return stack.empty();
    }
}
