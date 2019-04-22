package tree.BinaryTree;


import tree.Model.TreeNode;

/**
 * 寻找二叉树的直径
 */
public class FindModeinBinarySearchTree {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        res = Math.max(res, getDepth(root.left) + getDepth(root.right));
        return res;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
