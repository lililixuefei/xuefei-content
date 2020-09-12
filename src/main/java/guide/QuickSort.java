package guide;


/**
 * @description: 快排
 * @author: xuefei
 * @date: 2020/07/24 08:27
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 7, 10, 3, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        int index = partition(arr, start, end);
        if (index > start) {
            quickSort(arr, start, index - 1);
        }
        if (index < end) {
            quickSort(arr, index + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        if (arr == null || arr.length <= 0 || start < 0 || end >= arr.length) {
            return -1;
        }
//        int start = 0;
//        int end = array.length - 1;
        int index = (int) Math.random() * (end + 1 - start) + start;
        swap(arr, index, end);
        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (arr[index] < arr[end]) {
                ++small;
                if (small != index) {
                    swap(arr, index, small);
                }
            }
        }
        ++small;
        swap(arr, small, end);
        return small;
    }


    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
//        arr[start] = arr[start] ^ arr[end];
//        arr[end] = arr[start] ^ arr[end];
//        arr[start] = arr[start] ^ arr[end];
    }


}
