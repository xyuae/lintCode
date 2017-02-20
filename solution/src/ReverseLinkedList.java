/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class ReverseLinkedList {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode first = head;
        ListNode second = head;

        first = first.next;
        second.next = null;

        while (first.next != null){
            ListNode temp = first.next;
            first.next = second;
            second = first;
            first = temp;
        }
        first.next = second;
        return first;
    }
}
