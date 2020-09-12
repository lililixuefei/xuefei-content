package guide;

/**
 * @description: 二叉排序树
 * @author: xuefei
 * @date: 2020/07/27 10:37
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new TreeNode(arr[i]));
        }
        binarySortTree.infixOrder();

    }
}
class BinarySortTree{
    private TreeNode root;
    public TreeNode getRoot(){
        return root;
    }
    public void add(TreeNode node){
        if(root == null){
            root = node;
        }else {
            root.addNode(node);
        }
    }

    public void infixOrder() {
        if(root != null){
            root.infixOrder();
        }else {
            System.out.println("二叉排序树，不能遍历");
        }
    }
}
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public void addNode(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {         //如果不为空，递归遍历
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {            // 如果不为空，递归添加
                this.right.addNode(node);
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 先序遍历
    public void preOrder() {
        System.out.println(this);  // 先输出根节点
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 后续遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
}
