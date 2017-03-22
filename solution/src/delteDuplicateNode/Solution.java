package delteDuplicateNode;

import java.util.HashSet;

/**
 * Created by Xiaojun YU on 2017-03-17.
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) return null;
        HashSet<Integer> set = new HashSet<>();
        ListNode tempHead = head;
        set.add(head.val);
        while (head != null && head.next != null) {
            // skip all the node that is repeated
            while (head.next != null && set.contains(head.next.val)) {
                head.next = head.next.next;
            }
            if (head.next == null) {
                return tempHead;
            }
            else {
                set.add(head.next.val);
            }
            head = head.next;
        }
        return tempHead;
    }
}
