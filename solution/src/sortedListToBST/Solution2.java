package sortedListToBST;

import DeleteBinaryTree.*;

/**
 * Created by Xiaojun YU on 2017-03-18.
 */
public class Solution2 {
    static class ListNodeWrapper {
        ListNode node;
    }
    public static TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        ListNodeWrapper headWrapper = new ListNodeWrapper();
        headWrapper.node = head;
        return sortedListToBST(headWrapper, 0, len - 1);
    }

    private static TreeNode sortedListToBST(ListNodeWrapper headWrapper, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(headWrapper, start, mid - 1);
        TreeNode parent = new TreeNode(headWrapper.node.val);
        parent.left = left;
        headWrapper.node = headWrapper.node.next;
        parent.right = sortedListToBST(headWrapper, mid + 1, end);
        return parent;
    }
}
