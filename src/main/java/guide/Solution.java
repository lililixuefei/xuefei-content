package guide;

/**
 * @description: 替换空格
 * @author: xuefei
 * @date: 2020/07/21 09:50
 */
public class Solution {

    public static void main(String[] args) {
        // 1.常规方法
        String str = "hello world";
        String replaceSpace = replaceSpace(str);
        System.out.println(replaceSpace);
//        String replaceSpace2 = replaceSpace2(str);
//        System.out.println(replaceSpace2);

    }

    /**
     * 第一种方法：常规方法。利用 String.charAt(i)以及String.valueOf(char).equals(" ")
     *                  遍历字符串并判断元素是否为空格，是则替换为 "%20"，否则不替换
     * @param str
     * @return
     */
    public static String replaceSpace(String str){
        int length = str.length();
        StringBuffer result =  new StringBuffer();
        for (int i = 0; i < length; i++) {
            char b = str.charAt(i);
            if(String.valueOf(b).equals(" ")){
                result.append("%20");
            }else {
                result.append(b);
            }
        }
        return result.toString();
    }

    /**
     * 第二种方法，利用 API 替换
     * @param str
     * @return
     */
    public static String replaceSpace2(String str){
        return str.replaceAll("\\s","%20");
    }
}
