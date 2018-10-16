package algorithmLearn.BinaryTree;

import javax.swing.*;

public class RedBlackTree {
    private static final int RED = 0;
    private static final int BLACK = 1;

    class Node{
        Node parent;
        Node left;
        Node right;
        int color;
        int val;

    }

    public static void main(String args[]) {

    }

    /**
     * 构造一颗红黑树
     *
     * @return 根结点
     */
    public static Node initTree() {
        return null;
    }


    /**
     * 左旋
     * @param root 根结点
     * @param x 左旋基准点
     */
    public static void leftRotate(Node root, Node x) {
        //换掉x的右孩子，置为y的左孩子
        Node y = x.right;
        x.right = y.left;
        if(y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if(x.parent == null) {
            root = y;
        }else if(x == x.parent.left) {//x是左孩子
            x.parent.left = y;
        }else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    /**
     * 右旋
     * @param root 根结点
     * @param y 右旋基准点
     */
    public static void rightRotate(Node root, Node y) {
        Node x = y.left;
        //换掉y的左孩子，置为x的右孩子
        y.left = x.right;
        if(x.right != null) {
            x.right.parent = y;
        }

        x.parent = y.parent;

        if(y.parent == null) {
            root = x;
        }else if(y == y.parent.left) {//y是左孩子
            y.parent.left = x;
        }else {
            y.parent.right = x;
        }

        x.right = y;
        y.parent = x;
    }

    /**
     * 插入
     *
     * @param root 根结点
     * @param z 插入结点
     */
    public static void insert(Node root, Node z) {
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            if(z.val < x.val) {
                x = x.left;
            }else {
                x = x.right;
            }
        }

        z.parent = y;
        if(y == null) {
            root = z;
        }else if(z.val < y.val) {
            y.left = z;
        }else {
            y.right = z;
        }

        z.left = null;
        z.right = null;
        z.color = RED;//每个插入结点预先置为红色

        insertFixUp(root, z);

    }

    /**
     * 插入辅助
     *
     * @param root 根结点
     * @param z 插入结点
     */
    public static void insertFixUp(Node root, Node z) {
        while (z.parent.color == RED) {
            //若z的父节点是左孩子
            if(z.parent == z.parent.parent.left){
                //y是叔结点
                Node y = z.parent.parent.right;

                //case1 如果叔结点是红色，与兄弟结点一起置为黑色，将其父亲置为红色，并将z指针上移两层
                if(y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                }
                //case2 如果叔结点是黑色，且z为右孩子，将其指针上移一层，然后左旋
                else if(z == z.parent.right) {
                    z = z.parent;
                    leftRotate(root, z);
                }
                //case3 如果叔结点是黑色，且z为左孩子，将其父节点置为黑色，祖父结点置为红色，将其祖父结点右旋
                else {
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rightRotate(root, z.parent.parent);
                }

            }
            //若z的父节点是右孩子
            else {
                Node y = z.parent.parent.left;

                //case 4
                if(y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                }
                //case 5
                else if(z == z.parent.left) {
                    z = z.parent;
                    rightRotate(root, z);
                }
                //case 6
                else {
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    leftRotate(root, z.parent.parent);

                }
            }
        }

        root.color = BLACK;
    }

    /**
     * 互换结点
     *
     * @param root 根结点
     * @param u 结点1
     * @param v 结点2
     */
    public static void transplant(Node root, Node u, Node v) {
        if(u.parent == null) {
            root = v;
        }else if(u == u.parent.left) {
            u.parent.left = v;
        }else {
            u.parent.right = v;
        }

        v.parent = u.parent;
    }

    /**
     * 查询最小值
     * @param x 二叉搜索树根结点
     * @return 最小值结点
     */
    public static Node minimum(Node x) {
        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    /**
     * 删除节点
     * @param root 根结点
     * @param z 被删除节点
     */
    public static void delete(Node root, Node z) {
        Node y = z;
        int yOriginalColor = y.color;
        Node x = null;

        if(z.left == null) {
            x = z.right;
            transplant(root, z, z.right);
        }else if(z.right ==null) {
            x = z.left;
            transplant(root, z, z.left);
        }else {
            y = minimum(z.right);
            x = y.right;
            if(y.parent == z) {
                x.parent = y;
            }else {
                transplant(root, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            transplant(root, z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if(yOriginalColor == BLACK) {

        }
    }

    public static void deleteFixUp(Node root, Node x) {
        while (x != root && x.color == BLACK) {
            if(x == x.parent.left) {
                Node w = x.parent.left;
                if(w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(root, x.parent);
                    w = x.parent.right;
                }
                if(w.left.color == BLACK && w.right.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                }else if(w.right.color == BLACK) {
                    w.left.color = BLACK;
                    w.color = RED;
                    rightRotate(root, w);
                    w = x.parent.right;
                }

                w.color = x.parent.color;
                x.parent.color = BLACK;
                w.right.color = BLACK;
                leftRotate(root, x.parent);
                x = root;
            }else {
                Node w = x.parent.right;
                if(w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rightRotate(root, x.parent);
                    w = x.parent.left;
                }
                if(w.right.color == BLACK && w.left.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                }else if(w.left.color == BLACK) {
                    w.right.color = BLACK;
                    w.color = RED;
                    leftRotate(root, w);
                    w = x.parent.left;
                }

                w.color = x.parent.color;
                x.parent.color = BLACK;
                w.left.color = BLACK;
                rightRotate(root, x.parent);
                x = root;
            }
        }

        x.color = BLACK;
    }
    
}
