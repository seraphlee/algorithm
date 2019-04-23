package tree.N_aryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的层序遍历
 */
public class NaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        traversal(ret, root, 0);
        return ret;

    }

    public static void traversal(List<List<Integer>> ret, Node root, int level) {
        if (root == null) {
            return;
        }

        if (level >= ret.size()) {
            ret.add(new ArrayList<>());
        }

        ret.get(level).add(root.val);

        for (Node n : root.children) {
            traversal(ret, n, level + 1);
        }
    }

    public static void main(String args[]) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(2);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.children.add(b);
        a.children.add(c);
        a.children.add(d);
        b.children.add(e);
        b.children.add(f);

        System.out.println(levelOrder(a));

    }
}
