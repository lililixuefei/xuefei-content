package tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:二叉树
 * @author: xuefei
 * @date: 2020/09/12 18:37
 */
public class BinaryTree {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        TreeManager treeManager = new TreeManager();
        treeManager.indexOrder(node1);
        System.out.println("---");
        treeManager.midOrder(node1);
        System.out.println("---");
        treeManager.afterOrder(node1);
    }
}

class TreeManager {


    /**
     * 先序遍历
     *
     * @param node
     */
    public void indexOrder(Node node) {
        if (node != null) {
            System.out.println(node.getNo());
            if (node.getLeft() != null) {
                indexOrder(node.getLeft());
            }
            if (node.getRight() != null) {
                indexOrder(node.getRight());
            }
        } else {
            System.out.println("树为空");
        }

    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void midOrder(Node node) {
        if (node != null) {
            if (node.getLeft() != null) {
                midOrder(node.getLeft());
            }
            System.out.println(node.getNo());
            if (node.getRight() != null) {
                midOrder(node.getRight());
            }
        } else {
            System.out.println("树为空");
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void afterOrder(Node node) {
        if (node != null) {
            if (node.getRight() != null) {
                afterOrder(node.getRight());
            }
            System.out.println(node.getNo());
            if (node.getLeft() != null) {
                afterOrder(node.getLeft());
            }
        } else {
            System.out.println("树为空");
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Node {
    private int no;
    private Node left;
    private Node right;

    public Node(int no) {
        this.no = no;
    }
}
