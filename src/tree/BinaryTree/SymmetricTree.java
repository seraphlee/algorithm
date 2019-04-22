package tree.BinaryTree;

import tree.Model.TreeNode;

/**
 * 对称二叉树
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return traversal(root.left, root.right);
    }

    private boolean traversal(TreeNode l, TreeNode r) {
        if(l == null && r == null) {
            return true;
        }else if(l != null && r == null) {
            return false;
        }else if(l == null && r != null) {
            return false;
        }else if(l.val == r.val) {
            return traversal(l.left, r.right) && traversal(l.right, r.left);
        }

        return false;
    }
}
