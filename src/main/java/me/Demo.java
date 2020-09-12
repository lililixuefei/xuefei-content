package me;

import java.util.*;

/**
 * @description:
 * @author: xuefei
 * @date: 2020/07/25 16:03
 */
public class Demo {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        List list = new ArrayList();
        for (int j = 0; j < i; j++) {
            List list1 = new ArrayList();
            for (int k = 0; k < i; k++) {
                list1.add(sc.nextInt());
            }
            list.add(list1);
        }
        Map map = new HashMap();
        for (int m = 0; m < i; m++) {
            List list1 = (List) list.get(m);
            int index = 0;
            while (map.containsValue(list1.get(index)) && index < i) {
                index++;
            }
            map.put(m, list1.get(index));
        }

    }
}



