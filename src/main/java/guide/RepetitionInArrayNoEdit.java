package guide;

/**
 * @description: 不修改数组找出重复的数字
 * @author: xuefei
 * @date: 2020/07/22 17:09
 */
public class RepetitionInArrayNoEdit {

    public static void main(String[] args) {

    }

    public static int getDuplication(int[] array) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int start = 1;
        int end = array.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(array, array.length, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] array, int length, int start, int end) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= start && array[i] <= end) {
                count++;
            }
        }
        return count;
    }


}
