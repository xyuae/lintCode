import java.util.List;

/**
 * Created by Xiaojun YU on 2017-02-21.
 */
public class MergeSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        ListNode res = null;
        if (lists == null) return null;

        for (ListNode list: lists) {
            res = merge2Lists(res, list);
        }
        return res;
    }

    private ListNode merge2Lists(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (first != null && second != null) {
            if (first.val > second.val) {
                res.next = new ListNode(second.val);
                res = res.next;
                second = second.next;
            }
            else {
                res.next = new ListNode(first.val);
                res = res.next;
                first = first.next;
            }
        }
        while (first != null) {
            res.next = new ListNode(first.val);
            res = res.next;
            first = first.next;
        }
        while (second != null) {
            res.next = new ListNode(second.val);
            res = res.next;
            second = second.next;
        }
        return head.next;
    }
}