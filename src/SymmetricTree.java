public class SymmetricTree {
    public static void main(String[] args) {
        System.out.println();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 稍微修改下SameTree的判定条件即可
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isSame(root.left, root.right);
    }


    public boolean isSame(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;



        if(p.val != q.val)
            return false;

        return isSame(p.left, q.right) && isSame(p.right, q.left);

    }

}
