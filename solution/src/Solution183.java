/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class Solution183 {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        int max = 0;
        if (L == null || L.length == 0) return 0;
        for (int i = 0; i < L.length; i++) {
            if (L[i] > max) max = L[i];
        }
        // use binary search to find the maximum length of the small pieces.
        int start = 1;
        int end = max;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (count(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (count(L, end) >= k) return end;
        if (count(L, start) >= k) return start;
        return 0;
    }
    private int count(int[] L, int len) {
        int cnt = 0;
        for (int i = 0; i < L.length; i++) {
            cnt += L[i] / len;
        }
        return cnt;
    }
    public static void main(String[] args) // unit tests (not graded)
    {
        int[] L;
        L = new int[]{232, 124, 456};
        int k = 7;
        int ans = 114;
        Solution183 s = new Solution183();
        if (s.woodCut(L, k) == ans) System.out.println("Success");
        else System.out.println("fail");
    }
}
