package tree.BinaryTree;

import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 */
public class BinaryTreePostorderTraversal {

    /**
     * 递归
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private static void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);

    }

    /**
     * 非递归
     * 利用栈结构
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return list;
    }

    /**
     * Morris
     */
    public static List<Integer> morris(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();

        TreeNode dump = new TreeNode(0);
        dump.left = root;
        TreeNode cur = dump;

        TreeNode pre;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                //找到左子树中的前驱节点，即左子树中的最右结点
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    printReverse(cur.left, pre, list);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }

        return list;
    }

    static void reverse(TreeNode from, TreeNode to) {
        if (from == to) {
            return;
        }

        TreeNode x = from;
        TreeNode y = from.right;
        TreeNode z;
        while (true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if (x == to)
                break;
        }
    }

    static void printReverse(TreeNode from, TreeNode to, List<Integer> list) {
        reverse(from, to);

        TreeNode p = to;
        while (true) {
            list.add(p.val);
            if (p == from)
                break;
            p = p.right;
        }

        reverse(to, from);
    }


}
