package guide;

import java.util.Arrays;

/**
 * @description:
 * @author: xuefei
 * @date: 2020/07/21 10:18
 */
public class Main {

    public static void main(String[] args){
        String[] strs = {"customer","car","cat"};
        System.out.println(Main.longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs){
        // 如果检查值不合法，返回空串
        if(!checkStrs(strs)) {
            return "";
        }
        // 数组长度
        int len = strs.length;
        // 用于保存结果
        StringBuilder res = new StringBuilder();
        // 给字符串数组元素按照升序排序（包含数字的话，数字会排在前面）
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[len-1].length();
        int num = Math.min(m,n);
        for (int i = 0; i < num; i++) {
            if(strs[0].charAt(i) == strs[len-1].charAt(i)){
                res.append(strs[0].charAt(i));
            }else
                break;
        }
        return res.toString();
    }

    private static boolean checkStrs(String[] strs) {
        boolean flag = false;
        if(strs != null){
            // 遍历strs检查元素的值
            for (int i = 0; i < strs.length; i++) {
                if(strs[i] != null && strs[i].length() != 0){
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
