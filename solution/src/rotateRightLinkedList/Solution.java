package rotateRightLinkedList;

import delteDuplicateNode.ListNode;

/**
 * Created by Xiaojun YU on 2017-03-18.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode  p = root;
        ListNode q = root;

        int count = 0;
        for (int i = 0; i <= n; i++) {
            p = p.next;
            count++;
            if (p == null) {
                count--;
                n = n % count;
                i = 0;
                p = head;
            }
        }

        while (p != null) {
            p = p.next;
            q = q.next;
        }

        p = q;
        q = root;

        if (p != null && p.next != null) {
            ListNode node;
            while (p.next != null) {
                node = p.next;
                p.next = node.next;

                node.next = q.next;
                q.next = node;
                q = node;

            }
        }
        return root.next;

    }
}
