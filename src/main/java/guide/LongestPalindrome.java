package guide;

import java.util.HashSet;

/**
 * @description: 最长回文串
 * @author: xuefei
 * @date: 2020/07/21 10:45
 */
public class LongestPalindrome {

    public int countLongest(String str){
        if(str.length() == 0){
            return 0;
        }
        // 用于存放字符
        HashSet<Character> hashSet = new HashSet<Character>();
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if(!hashSet.contains(chars[i])){  // 如果hashset没有该字符就保存进去
                hashSet.add(chars[i]);
            } else {
                hashSet.remove(chars[i]);    //说明找到了一个成对的字符
                count++;
            }
        }
        return hashSet.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
