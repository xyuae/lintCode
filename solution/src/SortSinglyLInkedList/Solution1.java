package SortSinglyLInkedList;

/**
 * Created by Xiaojun YU on 2017-03-18.
 */
public class Solution1 {
    public static Node merge_sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node sHalf = middle.next;
        middle.next = null; // split the list into two halfs

        return merge(merge_sort(head), merge_sort(sHalf));
    }

    private static Node merge(Node a, Node b) {
        Node dummyHead, curr;
        dummyHead = new Node();
        curr = dummyHead;
        while (a != null && b != null) {
            if(a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        curr.next = (a == null) ? b: a;
        return dummyHead.next;
    }

    private static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
