package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description: 括号匹配问题
 * @author: xuefei
 * @date: 2020/07/29 10:33
 */
public class ParenthesisMatchingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean b = parenthesisMatching(str);
        System.out.println(b);
    }

    private static boolean parenthesisMatching(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
                if (stack.empty()) {
                    return false;
                }
                if ((stack.peek() == '(' && str.charAt(i) == ')') || (stack.peek() == '[' && str.charAt(i) == ']') || (stack.peek() == '{' && str.charAt(i) == '}')) {     // 如果栈顶元素和下一个右括号相匹配，则将其栈顶元素出栈
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {   // 遍历循环结束后，如果发现栈里为空，则证明括号匹配完毕；否则括号不匹配
            return true;
        }
        return false;

    }

}
