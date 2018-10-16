package algorithmLearn.BinaryTree;

import java.util.Stack;

public class Tree {
    //节点定义
    public static class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 返回一颗二叉树
     *  2
     * / \
     * 7  5
     * /\  /\
     * 1 6 8 3
     * /  \
     * 4   9
     * 前序：271469583
     * 中序：417692853
     * 后序：419678352
     */
    public static TreeNode init() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node7;
        node4.right = node8;
        node2.left = node5;
        node2.right = node6;

        return root;
    }

    /**
     * 返回一颗二叉搜索树
     *  6
     * / \
     * 3  8
     * /\  /\
     * 2 4 7 9
     * /  \
     * 1   5
     * 前序：632145879
     * 中序：123456789
     * 后序：125437986
     */
    public static TreeNode initSearchTree() {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(5);

        root.left = node1;
        root.right = node2;

        node1.parent = root;
        node1.left = node3;
        node1.right = node4;

        node2.parent = root;
        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.parent = node1;

        node4.right = node8;
        node4.parent = node1;

        node5.parent = node2;

        node6.parent = node2;

        node7.parent = node3;

        node8.parent = node4;

        return root;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = tree.init();
        //tree.preOrder(root);
        //tree.preOrderDev(root);
        //tree.middleOrder(root);
        //tree.middleOrderDev(root);
        tree.postOrder(root);
    }

    //前序遍历递归实现
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //前序遍历非递归实现
    public static void preOrderDev(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        //开始遍历整个二叉树
        while (node != null || !stack.empty()) {
            //输出当前子树的根节点，然后递归直至最左
            while (node != null) {
                System.out.print(node.val);
                stack.push(node);//存储遍历到的点，打印右子树时要用到
                node = node.left;
            }

            //此时已遍历到当前子树的最左边，开始寻找右子树作为下一个循环的子树
            if (!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    //中序遍历递归实现
    public static void middleOrder(TreeNode root) {
        if(root == null)
            return;

        middleOrder(root.left);
        System.out.print(root.val);
        middleOrder(root.right);
    }

    //中序非递归实现
    public static void middleOrderDev(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //此时node已经到达最左端
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val);
                node = node.right;
            }
        }
    }

    //后序遍历递归实现
    public static void postOrder(TreeNode root) {
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    //后序遍历非递归实现
    public static void postOrderDev(TreeNode root) {
        if(root == null)
            return;


    }
}
