package guide;

import java.util.Stack;

/**
 * @description: 用两个栈实现队列
 * @author: xuefei
 * @date: 2020/07/23 16:00
 */
public class StacksImplementationQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 如果两个队列都为空则抛出异常，说明用户没有push进任何元素
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        // 如果stack2不为空直接对stack2执行pop操作
        if (stack2.empty()) {
            while (!stack1.empty()) {
                // 将stack1的元素按后进先出进stack2里面
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {

    }

}
