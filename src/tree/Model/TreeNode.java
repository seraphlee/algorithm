package tree.Model;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 返回一颗二叉树
     *   A
     *  / \
     * B  C
     * / / \
     * D E F
     *  \
     *  G
     * 前序：1247356
     * 中序：4721536 DGBAECF
     * 后序：7425631
     */
    public static TreeNode init() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);

        A.left = B;
        A.right = C;
        B.left = D;
        C.left = E;
        C.right = F;
        D.right = G;

        return A;
    }

    public static void main(String args[]) {
        TreeNode p = new TreeNode(123);
        change(p);
        System.out.println(p);

    }

    private static void change(TreeNode p) {
        p = null;
    }
}
