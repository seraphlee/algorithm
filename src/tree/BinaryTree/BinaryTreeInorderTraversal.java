package tree.BinaryTree;

import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class BinaryTreeInorderTraversal {

    /**
     * 递归
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private static void traversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }

    /**
     * 非递归
     * 利用栈结构
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        TreeNode curNode = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (curNode != null || !stack.empty()) {
            if(curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }else {
                curNode = stack.pop();
                list.add(curNode.val);
                curNode = curNode.right;
            }
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
                    cur = cur.left;
                }else {
                    pre.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return list;
    }
}

























