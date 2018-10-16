package algorithmLearn.BinaryTree;

public class BinarySearchTree {
    public static void main(String args[]) {
        Tree.TreeNode root = Tree.initSearchTree();

        delete(root, search(root, 4));

        Tree.preOrder(root);
        System.out.println();
        Tree.middleOrderDev(root);
        System.out.println();
        Tree.postOrder(root);

    }

    /**
     * 查询指定key值-递归
     * @param x 二叉搜索树根结点
     * @param key 查询值
     * @return 指定结点
     */
    public static Tree.TreeNode search(Tree.TreeNode x, int key) {
        if (x == null || key == x.val) {
            return x;
        }

        if(key < x.val) {
            return search(x.left, key);
        }else {
            return search(x.right, key);
        }
    }

    /**
     * 查询指定key值-非递归
     * @param x 二叉搜索树根结点
     * @param key 查询值
     * @return 指定结点
     */
    public static Tree.TreeNode searchV2(Tree.TreeNode x, int key) {
        while (x != null && key != x.val) {
            if(key < x.val) {
                x = x.left;
            }else {
                x = x.right;
            }
        }

        return x;
    }

    /**
     * 查询最大值
     * @param x 二叉搜索树根结点
     * @return 最大值结点
     */
    public static Tree.TreeNode maximum(Tree.TreeNode x) {
        while (x.right != null) {
            x = x.right;
        }

        return x;
    }

    /**
     * 查询最小值
     * @param x 二叉搜索树根结点
     * @return 最小值结点
     */
    public static Tree.TreeNode minimum(Tree.TreeNode x) {
        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    /**
     * 后继结点，大于x的最小关键字的节点
     * 若右子树非空，则必为右子树最左节点
     * 若右子树为空，则必为x的有左孩子的最底层祖先
     * @param x 查询的节点
     * @return 后继节点
     */
    public static Tree.TreeNode successor(Tree.TreeNode x) {
        if(x.right != null) {
            return minimum(x.right);
        }

        Tree.TreeNode y = x.parent;

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
     * @param x 查询的节点
     * @return 后继节点
     */
    public static Tree.TreeNode preDecessor(Tree.TreeNode x) {
        if(x.left != null) {
            return maximum(x.left);
        }

        Tree.TreeNode y = x.parent;

        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /**
     * 插入
     * 必然插入到叶子结点的孩子位置
     * @param root 二叉搜索树根结点
     * @param z 需插入的节点
     */
    public static void insert(Tree.TreeNode root, Tree.TreeNode z) {
        Tree.TreeNode y = null;
        Tree.TreeNode x = root;

        while (x != null) {
            y = x;
            if(z.val < x.val) {
                x = x.left;
            }else {
                x = x.right;
            }
        }
        z.parent = y;

        //空树
        if(y == null) {
            root = z;
        }else if(z.val < y.val) {
            y.left = z;
        }else {
            y.right =z;
        }

    }

    /**
     * 用一颗子树替换另一棵子树
     *
     * @param root 根结点
     * @param u 被替换节点
     * @param v 替换节点
     */
    public static void transplant(Tree.TreeNode root, Tree.TreeNode u, Tree.TreeNode v) {
        //u是树根
        if(u.parent == null) {
            root.parent = v;
        }else if(u == u.parent.left) {
            u.parent.left = v;
        }else {
            u.parent.right = v;
        }

        if(v != null) {
            v.parent = u.parent;
        }

    }

    /**
     * 删除节点
     *
     * 1.如果z没有孩子，将其删除并修改其父节点的孩子为null
     * 2.如果z只有一个孩子，将孩子提升至树中z的位置上，并修改z的父节点
     * 3.如果z有两个孩子l和r，找出z的后继y，y必定位于z的右子树中并且没有左孩子
     *      若y是z的右孩子，那么直接用y替换z
     *      否则，先用y的右孩子替换y，再置y为r的双亲，最后再用y替换z
     *
     * @param root 根结点
     * @param z 将被删除的节点
     */
    public static void delete(Tree.TreeNode root, Tree.TreeNode z) {
        if(z.left == null) {
            transplant(root, z, z.right);
        }else if(z.right == null) {
            transplant(root, z, z.left);

        }else {
            Tree.TreeNode y = minimum(z.right); //后继结点

            if(y.parent != z) {
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
