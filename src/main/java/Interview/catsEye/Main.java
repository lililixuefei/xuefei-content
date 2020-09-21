package Interview.catsEye;

/**
 * @description: 猫眼面试算法题
 * @author: xuefei
 * @date: 2020/09/21 22:35
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 9, 12};
        System.out.println(bin1(arr, 0, arr.length - 1, 100));
        System.out.println(bin2(arr, 0, arr.length - 1, 6));
    }

    // 二分查找第一个小于等于 target 的下标
    public static int bin1(int[] arr, int low, int high, int target) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    // 二分查找第一个大于等于 target 元素的下标
    public static int bin2(int[] arr, int low, int high, int target) {
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