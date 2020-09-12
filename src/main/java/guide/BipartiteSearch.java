package guide;

/**
 * @description: 二分查找
 * @author: xuefei
 * @date: 2020/07/23 23:03
 */
public class BipartiteSearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(bipartiteSearch(array, 4));

    }

    public static int bipartiteSearch(int[] array,int target){
        if(array == null || array.length <= 0){
            return -1;
        }
        int start = 0;
        int end = array.length-1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if(array[mid] == target){
                return mid;
            }
            if (array[mid] > target){
                end = mid - 1;
            }
            if (array[mid] < target){
                start = mid + 1;
            }
        }
        return -1;
    }
}
