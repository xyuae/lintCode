/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class nthLastElement166 {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode first = head;
        for (int i = 1; i < n; i++) {
            first = first.next;
        }
        ListNode second = head;
        // check corner case where head == null, n = 0;
        if (first == null) return second;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
