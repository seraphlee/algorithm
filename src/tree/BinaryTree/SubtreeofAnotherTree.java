package tree.BinaryTree;

import tree.Model.TreeNode;

/**
 * 另一颗树的子树
 */
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        // 先看看是不是自己的子树，再看看是不是左子树的子树，再看看是不是右子树的子树
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
        } else if (s == null && t == null) {
            return true;
        } else {
            return false;
        }
    }
}
