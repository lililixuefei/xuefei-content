package me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: xuefei
 * @date: 2020/07/29 20:55
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        Arrays.sort(arr);
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < m; i++) {
            arr[0] += x;
//            quickSort(arr, 0, arr.length - 1);
            int b = 0;
            for (int j = 1; j < n - 1; j++) {
                if (arr[b] > arr[j]) {
                    int temp = arr[b];
                    arr[b] = arr[j];
                    arr[j] = temp;
                    b++;
                }
            }
        }
        System.out.println(arr[0]);
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
    }
}
