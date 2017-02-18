/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class MakeBinaryTree {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return null;
        int start = 0;
        int end = A.length - 1;
        return arrayToBST(A, start, end);
    }
    private TreeNode arrayToBST(int[] A, int start, int end){
        if (start == end) return new TreeNode(A[start]);
        if (start < end) {
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(A[mid]);
            root.left = arrayToBST(A, start, mid -1);
            root.right = arrayToBST(A, mid + 1, end);
            return root;
        }
        return null;
    }
}
