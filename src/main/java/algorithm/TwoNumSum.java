package algorithm;

import java.util.*;

/**
 * @description: 两数之和
 * @author: xuefei
 * @date: 2020/10/12 23:49
 */
public class TwoNumSum {
    public static void main(String[] args) {
        // 假定数组中没有重复元素
        int[] nums = {5, 12, 6, 3, 9, 2, 1, 7};
        List<List<Integer>> resultList = twoSumV1(nums, 13);
        for (List<Integer> list : resultList) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    public static List<List<Integer>> twoSumV1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                resultList.add(Arrays.asList(i, map.get(other)));
                //为防止找到重复的元素对，匹配后从哈希表删除对应元素
                map.remove(nums[i]);
            }
        }
        return resultList;
    }


    /**
     * 上一个方法的优化
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                resultList.add(Arrays.asList(map.get(other), i));
            }
            map.put(nums[i], i);
        }
        return resultList;
    }
}
