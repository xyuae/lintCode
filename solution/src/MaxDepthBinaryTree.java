/**
 * Created by Xiaojun YU on 2017-02-19.
 */
public class MaxDepthBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     * Use recursive call to calculate the depth of subtree.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) return 0;
        int result = 1;
        result += Math.max(maxDepth(root.left), maxDepth(root.right));
        return result;
    }
}
