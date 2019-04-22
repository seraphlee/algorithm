package tree.BinaryTree;

import tree.Model.TreeNode;

/**
 * 翻转二叉树
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) {
            return null;
        } else {
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
            root.left = invertTree(root.left);
            root.right =invertTree(root.right);

        }
        return root;
    }

}
