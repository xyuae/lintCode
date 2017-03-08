

/**
 * Created by Xiaojun YU on 2017-02-13.

public class LinkedList327 {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]

    public int[] searchRange(int[] A, int target) {
        /**
         * @param node: the node in the list should be deleted
         * @return: nothing

        public void deleteNode(ListNode node) {
            // write your code here
            if (node.next == null) {
                node = null;
            }
            else {
                node.val = node.next.val;
                node.next = node.next.next;
            }
        }
    public static void main(String[] args) // unit tests (not graded)
    {
        int[] L;
        L = new int[]{232, 124, 456};
        int k = 124;
        int[] ans = new int []{1, 1};
        LinkedList327 s = new LinkedList327();
        if (s.searchRange(L, k) == ans) System.out.println("Success");
        else System.out.println("fail");
    }
}
*/