package guide;

/**
 * @description: 二维数组查找
 * @author: xuefei
 * @date: 2020/07/21 15:20
 */
public class TwoArrayFind {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        boolean b = find(10, array);
        System.out.println(b);
    }

    public static boolean find(int target,int[][] array){
        // 基本思路是从左下角开始找，这样速度最快
        int row = array.length-1; // 行
        int column = 0;     // 列
        while((row > 0) && column < array[0].length){
            if(array[row][column] > target){
                row --;
            }else if (array[row][column] < target){
                column ++;
            }else {
                return true;
            }
        }
        return false;
    }
}
