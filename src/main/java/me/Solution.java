package me;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @description:
 * @author: xuefei
 * @date: 2020/07/21 19:34
 */
public class Solution {
    public static void main(String[] args) {
    }

    //    public int determine_virus_type (int size, int[][] swap_indexes) {
//        // write code here
//        int [] array = new int[size];
//        for (int i = 0; i < array.length; i++) {
//            array[size - i - 1] = i + 1;
//        }
//        for (int i = 0; i < swap_indexes.length; i++) {
//            swapNum(array,swap_indexes[i][0],swap_indexes[i][1]);
//        }
//        int ret = reverse(array);
//        if(ret % 2 ==0){
//            return 2;
//        }
//        return 1;
//    }
//
//    private int reverse(int[] array) {
//        if(array == null || array.length == 0){
//            return 0;
//        }
//        return reverse(array,0,array.length - 1);
//    }
//
//    private int reverse(int[] array,int length,int r) {
//       if( length < r ){
//           int mid = length + ((r - length) >> 1);
//           return reverse(array,length,mid) + reverse(array,mid+1,r)+reverseMerge(array,length,mid,r);
//       }
//        return 0;
//    }
//
//    private int reverseMerge(int[] array, int length, int mid, int r) {
//        int count = 0;
//        int[] help = new int[r - length + 1];
//        int i = 0;
//        int m = length;
//        int n = mid + 1;
//        while(m <= mid && n <= r){
//            count += array[m] < array[n] ? mid - m + 1 : 0;
//            help[i++] = array[m] > array[n] ? array[m++] : array[n++];
//        }
//        for(;(n < r + 1) || (m < mid + 1); n++, m++){
//            help[i++] = m > mid ? array[n] : array[m];
//        }
//        for (int j = 0;j < help.length; j++){
//            array[length + j] = help[j];
//        }
//        return count;
//    }
//
//    private void swapNum(int[] array, int swap_index1, int swap_index2) {
//        int temp = array[swap_index1];
//        array[swap_index1] = array[swap_index2];
//        array[swap_index2] = temp;
//    }
    public int[][] invert_tree(int[][] node_data_list) {
        // write code here
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<int[]> arrayList = new ArrayList<>();
        LinkedList<int[]> linkedList = new LinkedList<>();
        for (int i = 0; i < node_data_list.length; i++) {
            list.add(node_data_list[i]);
        }
        linkedList.push(list.remove(0));
        loop(list, linkedList, arrayList);
        return arrayList.toArray(new int[][]{});
    }

    private void loop(ArrayList<int[]> list, LinkedList<int[]> linkedList, ArrayList<int[]> arrayList) {
        if (linkedList.size() != 0) {
            int[] now = linkedList.pop();
            arrayList.add(now);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[1] == now[0]) {
                    linkedList.push(list.get(i));
                    list.remove(i--);
                }
            }
            loop(list, linkedList, arrayList);
        }
    }
}

//    int index = 0;
//
//    public int[][] invert_tree (int[][] node_data_list) {
//        // write code here
//        Map<Integer,Node> map = new HashMap<>();
//        for (int i = 0; i < node_data_list.length; i++) {
//            Node node = new Node();
//            node.value = node_data_list[i][0];
//            node.pre = node_data_list[i][1];
//            map.put(node_data_list[i][0],node);
//            if(node.pre != 0){
//                Node newNode = map.get(node.pre);
//                newNode.list.add(node);
//            }
//        }
//        insert(node_data_list,map.get(1));
//        return node_data_list;
//    }
//
//    private void insert(int[][] node_data_list, Node node) {
//        node_data_list[index][0] = node.value;
//        node_data_list[index][1] = node.value;
//        index ++;
//        for (int i = 0; i < node.list.size() - 1; i++) {
//            insert(node_data_list,node.list.get(i));
//        }
//    }
//}
//
//class Node{
//    int value;
//    int pre;
//    List<Node> list = new ArrayList<>();
//}

