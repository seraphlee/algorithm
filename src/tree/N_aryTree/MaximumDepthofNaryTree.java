package tree.N_aryTree;

/**
 * N叉树的最大深度
 */
public class MaximumDepthofNaryTree {
    int ans = 0;

    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        traversal(root, 1);

        return ans;

    }

    private void traversal(Node node, int depth) {
        if (node  == null) {
            return;
        }

        ans = Math.max(ans, depth);

        if(node.children != null) {
            for (int i = 0; i < node.children.size(); i++) {
                traversal(node.children.get(i), depth + 1);
            }
        }
    }
}
