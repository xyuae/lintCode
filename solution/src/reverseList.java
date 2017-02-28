/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = slow.next;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null, cur = slow.next;
        while (cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = pre;
        return head;
    }
}
