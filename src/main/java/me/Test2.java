package me;

import java.util.LinkedList;

/**
 * @description: 多叉树的层次遍历
 * @author: xuefei
 * @date: 2020/08/04 18:09
 */
public class Test2 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(21);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(33);
        treeNode1.setFirstNode(treeNode2);
        treeNode1.setNextNode(treeNode3);
        treeNode2.setFirstNode(treeNode4);
        treeNode2.setNextNode(treeNode5);
        bianli(treeNode1);

    }

    // 遍历方法
    public static void bianli(TreeNode node) {
        if (node == null) {
            return;
        }
        // 定义一个临时变量
        TreeNode temp;
        // 把节点放到队列里面去
        LinkedList linkedList = new LinkedList();
        linkedList.add(node);
        int count = 0;   // 节点数量
        // 判断队列是否为空
        while (!linkedList.isEmpty()) {
            temp = (TreeNode) linkedList.poll();// 拿到第一个并删除且返回
            ++count;
            System.out.println(temp.data);
            if (temp.getFirstNode() != null) {
                linkedList.add(temp.getFirstNode());
            }
            if (temp.getNextNode() != null) {
                linkedList.add(temp.getNextNode());
            }
        }
        System.out.println(count);
    }
}

class TreeNode {
    public int data;
    private TreeNode firstNode;
    private TreeNode nextNode;

    public TreeNode(int data) {
        this.data = data;

    }

    public TreeNode(TreeNode firstNode, TreeNode nextNode) {
        this.firstNode = firstNode;
        this.nextNode = nextNode;
    }


    public TreeNode getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(TreeNode firstNode) {
        this.firstNode = firstNode;
    }

    public TreeNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(TreeNode nextNode) {
        this.nextNode = nextNode;
    }
}
