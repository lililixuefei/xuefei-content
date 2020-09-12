package guide;

/**
 * @description: 调整数组顺序使奇数位于偶数前面
 * @author: xuefei
 * @date: 2020/07/22 11:34
 */
public class ArrayOrder {
    public static void main(String[] args) {

    }

    // 第二种
    public void reOrderArray2(int[] array) {
        int front = 0, end = array.length - 1;
        if (array.length == 0) {
            return;
        }
        while (front < end) {
            while (front < array.length && array[front] % 2 == 0) {
                front++;
            }
            while(end >= 0 && array[end] % 2 ==0){
                end--;
            }
            if(front < end){
                int temp = array[front];
                array[front] = array[end];
                array[end] = temp;
            }
        }
    }

    // 第一种
    public void reOrderArray1(int[] array) {
        // 如果数组长度等于0或者等于1，什么都不做直接返回
        if (array.length == 0 || array.length == 1) {
            return;
        }
        // oddCount:保存奇数个数
        // oddBegin：奇数从数组头部开始添加
        int oddCount = 0, oddBegin = 0;
        // 新建一个数组
        int[] newArray = new int[array.length];
        // 计算出数组中的奇数的个数
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) oddCount++;
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1)
                newArray[oddBegin++] = array[i];
            else newArray[oddCount++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }
}
