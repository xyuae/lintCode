package SortSinglyLInkedList;

import sortedListToBST.ListNode;

/**
 * Created by Xiaojun YU on 2017-03-19.
 */
public class Solution2 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode left = new ListNode(0), leftHead = left;
        ListNode right = new ListNode(0), rightHead = right;
        ListNode mid = new ListNode(0), midHead = mid;
        int val = head.val;

        while (head != null) {
            if (head.val < val) {
                left.next = head;
                left = head;
            } else if (head.val > val) {
                right.next = head;
                right = head;
            } else {
                mid.next = head;
                mid = head;
            }
            head = head.next;
        }

        left.next = null;
        right.next = null;
        mid.next = null;
        return merge(sortList(leftHead.next), midHead.next, sortList(rightHead.next));
    }

    private ListNode merge(ListNode left, ListNode mid, ListNode right) {
        ListNode leftTail = getTail(left);
        ListNode midTail = getTail(mid);
        midTail.next = right;
        if (leftTail !=null) {
            leftTail.next = mid;
            return left;
        } else {
            return mid;
        }
    }

    private ListNode getTail(ListNode head) {
        if (head == null) return head;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}
