package guide;

import java.util.Stack;

/**
 * @description: 从尾到头打印链表
 * @author: xuefei
 * @date: 2020/07/23 09:02
 */
public class PrintLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        printLinkedList1(node1);
        printLinkedList2(node1);
    }

    // 2、递归的方法
    public static void printLinkedList2(Node node){
        if(node != null){
            if(node.next != null){
                printLinkedList2(node.next);
            }
            System.out.println(node.key);
        }
    }

    // 1、栈的方法
    public static void printLinkedList1(Node node){
        Node tempNode = node;
        Stack<Node> stack = new Stack<>();
        while (tempNode != null){
            stack.push(tempNode);
            tempNode = tempNode.next;
        }
       while (!stack.empty()){
           System.out.println(stack.pop().key);
       }
    }
}
class Node{
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
    }
}
