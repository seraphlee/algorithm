package tree.BinaryTree;

public class BinarySearchTree {
    public static void main(String args[]) {
        TreeNode root = initSearchTree();

        delete(root, search(root, 4));

        preOrder(root);
        System.out.println();
        middleOrder(root);
        System.out.println();
        postOrder(root);

    }

    static class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 返回一颗二叉树
     * 2
     * / \
     * 7  5
     * /\  /\
     * 1 6 8 3
     * /  \
     * 4   9
     * 前序：271469583
     * 中序：417692853
     * 后序：419678352
     */
    public static TreeNode init() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node7;
        node4.right = node8;
        node2.left = node5;
        node2.right = node6;

        return root;
    }

    /**
     * 返回一颗二叉搜索树
     * 6
     * / \
     * 3  8
     * /\  /\
     * 2 4 7 9
     * /  \
     * 1   5
     * 前序：632145879
     * 中序：123456789
     * 后序：125437986
     */
    public static TreeNode initSearchTree() {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(5);

        root.left = node1;
        root.right = node2;

        node1.parent = root;
        node1.left = node3;
        node1.right = node4;

        node2.parent = root;
        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.parent = node1;

        node4.right = node8;
        node4.parent = node1;

        node5.parent = node2;

        node6.parent = node2;

        node7.parent = node3;

        node8.parent = node4;

        return root;
    }

    //前序遍历递归实现
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历递归实现
    public static void middleOrder(TreeNode root) {
        if (root == null)
            return;

        middleOrder(root.left);
        System.out.print(root.val);
        middleOrder(root.right);
    }

    //后序遍历递归实现
    public static void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    /**
     * 查询指定key值-递归
     *
     * @param x   二叉搜索树根结点
     * @param key 查询值
     * @return 指定结点
     */
    public static TreeNode search(TreeNode x, int key) {
        if (x == null || key == x.val) {
            return x;
        }

        if (key < x.val) {
            return search(x.left, key);
        } else {
            return search(x.right, key);
        }
    }

    /**
     * 查询指定key值-非递归
     *
     * @param x   二叉搜索树根结点
     * @param key 查询值
     * @return 指定结点
     */
    public static TreeNode searchV2(TreeNode x, int key) {
        while (x != null && key != x.val) {
            if (key < x.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        return x;
    }

    /**
     * 查询最大值
     *
     * @param x 二叉搜索树根结点
     * @return 最大值结点
     */
    public static TreeNode maximum(TreeNode x) {
        while (x.right != null) {
            x = x.right;
        }

        return x;
    }

    /**
     * 查询最小值
     *
     * @param x 二叉搜索树根结点
     * @return 最小值结点
     */
    public static TreeNode minimum(TreeNode x) {
        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    /**
     * 后继结点，大于x的最小关键字的节点
     * 若右子树非空，则必为右子树最左节点
     * 若右子树为空，则必为x的有左孩子的最底层祖先
     *
     * @param x 查询的节点
     * @return 后继节点
     */
    public static TreeNode successor(TreeNode x) {
        if (x.right != null) {
            return minimum(x.right);
        }

        TreeNode y = x.parent;

        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /**
     * 前驱结点，小于x的最大关键字的节点
     * 若左子树非空，则必为左子树最右节点
     * 若左子树为空，则必为x的有右孩子的最底层祖先
     *
     * @param x 查询的节点
     * @return 后继节点
     */
    public static TreeNode preDecessor(TreeNode x) {
        if (x.left != null) {
            return maximum(x.left);
        }

        TreeNode y = x.parent;

        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /**
     * 插入
     * 必然插入到叶子结点的孩子位置
     *
     * @param root 二叉搜索树根结点
     * @param z    需插入的节点
     */
    public static void insert(TreeNode root, TreeNode z) {
        TreeNode y = null;
        TreeNode x = root;

        while (x != null) {
            y = x;
            if (z.val < x.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;

        //空树
        if (y == null) {
            root = z;
        } else if (z.val < y.val) {
            y.left = z;
        } else {
            y.right = z;
        }

    }

    /**
     * 用一颗子树替换另一棵子树
     *
     * @param root 根结点
     * @param u    被替换节点
     * @param v    替换节点
     */
    public static void transplant(TreeNode root, TreeNode u, TreeNode v) {
        //u是树根
        if (u.parent == null) {
            root.parent = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }

        if (v != null) {
            v.parent = u.parent;
        }

    }

    /**
     * 删除节点
     * <p>
     * 1.如果z没有孩子，将其删除并修改其父节点的孩子为null
     * 2.如果z只有一个孩子，将孩子提升至树中z的位置上，并修改z的父节点
     * 3.如果z有两个孩子l和r，找出z的后继y，y必定位于z的右子树中并且没有左孩子
     * 若y是z的右孩子，那么直接用y替换z
     * 否则，先用y的右孩子替换y，再置y为r的双亲，最后再用y替换z
     *
     * @param root 根结点
     * @param z    将被删除的节点
     */
    public static void delete(TreeNode root, TreeNode z) {
        if (z.left == null) {
            transplant(root, z, z.right);
        } else if (z.right == null) {
            transplant(root, z, z.left);

        } else {
            TreeNode y = minimum(z.right); //后继结点

            if (y.parent != z) {
                transplant(root, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            transplant(root, z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

}
