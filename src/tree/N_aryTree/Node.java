package tree.N_aryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树结点数据结构
 */
public class Node {
    public int val;
    public List<Node> children = new ArrayList<>();

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}