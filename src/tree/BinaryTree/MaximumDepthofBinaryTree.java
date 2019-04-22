package tree.BinaryTree;

import tree.Model.TreeNode;

/**
 * 求二叉树最大深度
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        return search(root, 0);
    }

    private int search(TreeNode node, int depth) {
        if(node == null) {
            return depth;
        }

        int r = search(node.right, depth + 1);
        int l = search(node.left, depth + 1);

        if(r >= l) {
            return r;
        }else {
            return l;
        }
    }
}
