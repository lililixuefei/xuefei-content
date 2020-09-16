package tree.demo;

import java.util.*;

/**
 * @author xuefei
 * @version 1.0
 * @date 2020/9/14 9:21
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.setLeftNode(node2);
        node1.setRightNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        node4.setRightNode(node6);

        NodeManager nodeManager = new NodeManager();
//        System.out.println(nodeManager.treeDepth(node1));
//        System.out.println(nodeManager.binaryTreePaths(node1));
//        nodeManager.getListNode(node1, 2);
//        System.out.println("---");
//        nodeManager.getListNode(node1, 3);
//        System.out.println("---");
//        nodeManager.getListNode(node1, 4);
        String str = nodeManager.toString(node1);
        System.out.println(str);
//        List<Integer> list = nodeManager.indexOrderNoRecursion(node1);
//        list.forEach(System.out::println);
//        List<Integer> list1 = nodeManager.afterOrderNoRecursion(node1);
//        list1.forEach(System.out::println);
//        NodeManager.level(node1);
    }
}

class NodeManager {
    // 递归实现二叉树的遍历


    // 非递归实现二叉树的遍历

    /**
     * 先序遍历  根 -> 左 -> 右
     *
     * @param node
     */
    public List<Integer> indexOrderNoRecursion(Node node) {
        if (node == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            if (node == null) {
                break;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.getNum());
            }
            if (node.getRightNode() != null) {
                stack.push(node.getRightNode());
            }
            if (node.getLeftNode() != null) {
                stack.push(node.getLeftNode());
            }
        }
        return list;
    }

    /**
     * 中序遍历 左 -> 根 -> 右
     *
     * @param node
     * @return
     */
    public List<Integer> midOrderNoRecursion(Node node) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(node);
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeftNode();
            }
            node = stack.pop();
            list.add(node.getNum());
            node = node.getRightNode();
        }
        return list;
    }

    /**
     * 后序遍历  左 -> 右 -> 根
     *
     * @param node
     * @return
     */
    public List<Integer> afterOrderNoRecursion(Node node) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
//        List<Integer> list = new ArrayList<>();    如果要用ArrayList的话，最后可以使用Collections.reverse(list);进行翻转
        stack.push(node);
        while (!stack.isEmpty()) {
            if (node == null) {
                break;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.addFirst(node.getNum());
            }
            if (node.getLeftNode() != null) {
                stack.push(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                stack.push(node.getRightNode());
            }
        }
        return list;
    }

    /**
     * 树的层次遍历
     *
     * @param node
     */
    public static void level(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.getNum() + " ");

            if (tempNode.getLeftNode() != null) {
                queue.add(tempNode.getLeftNode());
            }
            if (tempNode.getRightNode() != null) {
                queue.add(tempNode.getRightNode());
            }
        }
    }

    /**
     * 得到二叉树指定层的所有结点
     *
     * @param node
     * @param deepth
     */
    public void getListNode(Node node, int deepth) {
        if (node == null) {
            return;
        }
        if (deepth == 1) {
            System.out.println(node.getNum());
        }
        getListNode(node.getLeftNode(), deepth - 1);
        getListNode(node.getRightNode(), deepth - 1);
    }


    /**
     * 判断一颗二叉树是不是平衡二叉树 --- 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
     *
     * @param root
     * @return
     */
    private static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.getLeftNode());
        int right = treeDepth(root.getRightNode());
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(root.getLeftNode()) && isBalanced(root.getRightNode());
    }

    /**
     * 树的最大深度（递归）
     *
     * @param root
     * @return
     */
    public static int treeDepth(Node root) {
        if (root != null) {
            int left = treeDepth(root.getLeftNode());
            int right = treeDepth(root.getRightNode());
            return left < right ? left + 1 : right + 1;
        }
        return 0;
    }

    int sum = 0;

    /**
     * 二叉树的直径 -- 二叉树的直径为每一个节点左右深度之和的最大值
     *
     * @param node
     * @return
     */
    public int diameterOfBinaryTree(Node node) {
        if (node != null) {
            int left = treeDepth(node.getLeftNode());
            int right = treeDepth(node.getRightNode());
            sum = Math.max(sum, left + right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

    /**
     * 二叉树的所有路径
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(Node root) {
        LinkedList<String> res = new LinkedList<>();
        if (root == null) return res;
        solve(root, "", res);
        return res;
    }

    public void solve(Node root, String cur, LinkedList<String> res) {
        if (root == null) return;
        cur += root.getNum();
        if (root.getLeftNode() == null && root.getRightNode() == null)
            res.add(cur);
        else {
            solve(root.getLeftNode(), cur + "->", res);
            solve(root.getRightNode(), cur + "->", res);
        }
    }

    /**
     * 使用递归先序遍历对二叉树进行序列化
     *
     * @param root
     * @return
     */
    public String toString(Node root) {
        //注意：Java中String是不可改变的，不能进行引用传递，改为使用StringBuffer
        StringBuilder res = new StringBuilder("");
        //调用递归方法完成二叉树遍历序列化
        this.preOrder(root, res);
        //返回结果
        return res.toString();
    }

    //递归方法，用来先序遍历二叉树同时将其序列化为字符串
    private void preOrder(Node root, StringBuilder str) {
        //递归结束的边界条件
        if (root == null) {
            str.append("#!");
            return;
        }
        //先遍历根结点
        str.append(root.getNum() + "!");
        //遍历左子树
        this.preOrder(root.getLeftNode(), str);
        //遍历右子树
        this.preOrder(root.getRightNode(), str);
    }

    /**
     * 非递归序列化
     *
     * @param node
     * @param str
     */
    private void preOrderStr(Node node, StringBuilder str) {
        Stack<Node> stack = new Stack();
        if (node == null) {
            return;
        }
        Node cur = node;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur == null) {
                str.append("#!");
            } else {
                //只要cur！=null不管cur的left和right是否是null都要压入栈中
                str.append(cur.getNum()).append("!");
                stack.push(cur.getRightNode());
                stack.push(cur.getLeftNode());
            }
        }
    }

    //已知由先序遍历得到的字符串str,将其恢复为一棵二叉树，并返回根结点
    public Node deserialize(String str) {
        if (str == null || str.length() <= 0) return null;
        //将字符串按照","拆分为数组
        String[] strs = str.split(",");
        //调用递归方法deSerializeCore()方法来实现重建二叉树的功能,返回根结点
        Node root = this.deSerializeCore(strs);
        //注意返回结果
        return root;
    }

    private int index = 0;

    public Node deSerializeCore(String[] strs) {
        if ("#".equals(strs[index])) {
            //如果遇到的是#表示空节点，不再建立子树，这个结点null就是子树的根结点返回
            //千万注意，返回前要将index向下移动，之后使用的是strs[]中后面部分的元素
            index++;
            return null;
        } else {
            //如果不为空结点，则先恢复这个结点
            Node newNode = new Node(0);
            newNode.setNum(Integer.parseInt(strs[index]));
            //千万注意在递归调用之前(使用了一个元素建立结点之后)，要将index向后移动1位
            index++;
            //恢复左子树
            newNode.setLeftNode(this.deSerializeCore(strs));
            //恢复右子树
            newNode.setRightNode(this.deSerializeCore(strs));
            //建立二叉树完成，返回根结点
            return newNode;
        }
    }

}


class Node {
    private int num;
    private Node leftNode;
    private Node rightNode;

    public Node(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
