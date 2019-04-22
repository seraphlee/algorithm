package tree.BinaryTree;

import tree.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class BinaryTreePreorderTraversal {

    /**
     * 递归
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private static void traversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }

    /**
     * 非递归
     * 利用栈结构
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
        return list;
    }

    /**
     * Morris
     */
    public static List<Integer> morris(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            if(cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            }else {
                //找到左子树中的前驱节点，即左子树中的最右结点
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if(pre.right == null) {
                    pre.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                }else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }

        return list;
    }
}
