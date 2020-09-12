package guide;

import java.util.Scanner;

/**
 * @description: 括号匹配深度
 * @author: xuefei
 * @date: 2020/07/21 11:05
 */
public class BracketDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0,max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                cnt ++;
            }else {
                cnt --;
            }
            max = Math.max(max,cnt);
        }
        sc.close();
        System.out.println(max);
    }
}
