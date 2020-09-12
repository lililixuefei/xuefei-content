package guide;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 找出数组中重复的数字
 * @author: xuefei
 * @date: 2020/07/22 16:49
 */
public class RepetitionInArray {
    public static void main(String[] args) {
        int[] array = {3,1,2,0,2,5,3};
//        List list = new ArrayList();
        int[] findRes = new int[1];
        boolean b = duplicate(array, findRes);
        System.out.println(b);
        System.out.println(findRes[0]);

//        list.forEach(System.out::println);

    }

    public static boolean duplicate(int[] array, int[] arr){
        if (array == null || array.length <= 0){
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 || array[i] > array.length - 1){
                return false;
            }
        }
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i){
                if (array[i] == array[array[i]]){
                    arr[0] = array[i];
//                    arrayList.add(array[i]);
//                    break;
                    return true;
                }
                // 交换位置
                int m = array[i];
                array[i] = array[m];
                array[m] = m;
            }
        }
        return false;
    }
}
