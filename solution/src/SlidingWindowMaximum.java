import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Xiaojun YU on 2017-02-26.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while(!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offerLast(i);
            if(i >= k - 1) res[ri++] = nums[deque.peekFirst()];
        }
        return res;
    }
    public static void main(String args[]){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMaximum sol = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(sol.maxSlidingWindow(nums, k)));
    }
}
