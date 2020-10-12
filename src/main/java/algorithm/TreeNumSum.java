package algorithm;

import java.util.*;

/**
 * @description: 三数之和
 * @author: xuefei
 * @date: 2020/10/12 23:54
 */
public class TreeNumSum {
    public static void main(String[] args) {

    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> threeSumV1(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int d1 = target - nums[i];
            //寻找两数之和等于d1的组合
            for (int j = i + 1; j < nums.length; j++) {
                int d2 = d1 - nums[j];
                if (map.containsKey(d2)) {
                    resultList.add(Arrays.asList(nums[i], d2, nums[j]));
                }
                map.put(nums[j], j);
            }
        }
        return resultList;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> threeSumv2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        //大循环
        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            // j和k双指针循环定位，j在左端，k在右端
            for (int j = i + 1, k = nums.length - 1; j < nums.length; j++) {
                // k指针向左移动
                while (j < k && (nums[j] + nums[k]) > d) {
                    k--;
                }
                //双指针重合，跳出本次循环
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == d) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    resultList.add(list);
                }
            }
        }
        return resultList;
    }
}
