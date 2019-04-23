package tree.N_aryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 */
public class NaryTreePostorderTraversal {

    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node n : root.children)
                postorder(n);
            list.add(root.val);
        }
        return list;
    }

}
