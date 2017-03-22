package sortedListToBST;


/**
 * Created by Xiaojun YU on 2017-03-18.
 */
public class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // use fast and slow pointer to find the middle node
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = null;
        while (fast.next != null && fast.next.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // recursively build he left and right part of the tree
        TreeNode mid = new TreeNode(slow.val);
        if (preSlow != null) {
            preSlow.next = null;
            mid.left = sortedListToBST(head);
        }
        if (slow.next != null) {
            mid.right = sortedListToBST(slow.next);
        }
        return mid;
    }
}
