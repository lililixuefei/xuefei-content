package me;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @description:
 * @author: xuefei
 * @date: 2020/08/31 19:53
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Map map = new HashMap();
        int[] count = new int[m];
        int[] target = new int[m];
        for (int i = 0; i < target.length; i++) {
            target[i] = -1;
        }

        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][1] == 1){
                c1++;
            }
            if (arr[i][1] == 0){
                c2++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i][0])) {
                count[i] = arr[i][0];
            }
            target[i] = arr[i][0];
            map.put(arr[i][0],arr[i][1]);
        }

        if(c1 == n){
            System.out.println(arr[0][0]);
        }
        if (c2 == n){
            System.out.println(arr[m-1][0]);
        }
        if(arr[0][0] == arr[n-1][0]){
            System.out.println(arr[0][0]);
        }
        for (int i = 0; i < target.length; i++) {
            if(target[i] == -1){
                System.out.println(i+1);
            }
        }

    }


//        System.out.println(sum(3, 5));
//        int[] arr = {-1, 2, 4};
//        System.out.println(minMoves(arr));
//    }

    public static int minMoves(int[] nums) {
        int sum = 0;
        int count = 0;
        int target = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);

        int aver = sum / nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (aver >= nums[i] && aver < nums[i + 1]) {
                target = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                count += Math.abs(target - nums[i]);
            }
        }
        return count;
    }

    public static long sum(int num, int itemNum) {
        long sum = 0;
        Integer integer = Integer.valueOf(num);
        String strNum1 = integer.toString();
        String strNum2 = "";
        for (int i = 0; i < itemNum; i++) {
            for (int j = i - 1; j < i; j++) {
                strNum2 += strNum1;
                System.out.println(strNum2 + "--" + i);
            }
            sum = sum + Long.valueOf(strNum2);
        }
        return sum;
    }
}
