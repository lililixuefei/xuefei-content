package guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @description: 年龄排序
 * @author: xuefei
 * @date: 2020/07/24 17:13
 */
public class SortAges {
    public static void main(String[] args) {
//        int[] ages = {2, 3, 45, 6, 3, 2, 5};
//        sortAges(ages);
//        for (int i = 0; i < ages.length; i++) {
//            System.out.println(ages[i]);
//        }


        System.out.println(a(666));
    }

    public static int a(int tab) {
        int n = tab - 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n;
    }

    public static void sortAges(int ages[]) {
        if (ages == null || ages.length <= 0) {
            return;
        }
        int oldestAge = 99;
        int[] timesOfAge = new int[oldestAge + 1];
        for (int i = 0; i < oldestAge; i++) {
            timesOfAge[i] = 0;
        }
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0 || age > oldestAge) {
                throw new RuntimeException("age out of range");
            }
            ++timesOfAge[age];
        }
        int index = 0;
        for (int i = 0; i < oldestAge; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index] = i;
                ++index;
            }
        }
    }
}
