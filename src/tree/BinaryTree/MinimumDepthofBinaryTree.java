package tree.BinaryTree;

import tree.Model.TreeNode;

/**
 * 求二叉树最小深度
 */
public class MinimumDepthofBinaryTree {
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left != null && root.right == null)
            return minDepth(root.left) + 1;
        if (root.left == null)
            return minDepth(root.right) + 1;

        int ld = minDepth(root.left);
        int rd = minDepth(root.right);

        return Math.min(ld, rd) + 1;

    }

    /**
     * 1
     * /\
     * 2  3
     * /  \
     * 4   5
     */
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        minDepth(root);

    }

}
