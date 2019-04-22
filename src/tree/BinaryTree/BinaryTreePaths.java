package tree.BinaryTree;

import tree.Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        String s = "";
        ArrayList<String> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        if(root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }

        tranversal(root, list, s);

        return list;
    }

    private void tranversal(TreeNode root, List<String> list, String s) {
        if(root == null) {
            return;
        }

        if(root.right == null && root.left == null) {
            list.add(s + root.val);
            s = "";
        }

        if(s != null) {
            s = s + root.val + "->";
        }

        tranversal(root.left, list, s);
        tranversal(root.right, list, s);
    }

}
