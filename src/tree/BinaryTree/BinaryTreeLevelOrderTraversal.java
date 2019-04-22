package tree.BinaryTree;

import tree.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层序遍历
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 递归
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        traversal(root, 0, ans);
        return ans;
    }

    private void traversal(TreeNode root, int depth, List<List<Integer>> ans) {
        if (root == null) {
            return ;
        }

        if (depth >= ans.size()) {
            ans.add(new ArrayList<>());
        }

        ans.get(depth).add(root.val);

        traversal(root.left, depth + 1, ans);
        traversal(root.right, depth + 1, ans);
    }

    /**
     * 非递归，采用队列实现
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }

}
