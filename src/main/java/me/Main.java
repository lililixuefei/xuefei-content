package me;


/**
 * @description:
 * @author: xuefei
 * @date: 2020/08/31 19:53
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(bin(arr, 0, 4, 3));

    }

    /**
     * 使用二分查找第一个大于等于目标数组的元素
     *
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int bin(int[] arr, int low, int high, int target) {
        // 先进行对象判断
        if (arr == null && high == 0) {
            return -1;
        } else if (arr[high] < target) {
            return high;      // 如果最大的元素小于目标值直接返回数组长度
        }
        // 进行二分查找
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
