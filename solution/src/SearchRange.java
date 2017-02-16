

/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class SearchRange {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) return new int[]{-1, -1};
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
                end = mid;
                while (start - 1 >= 0 && A[start-1] == target) start--;
                while (end + 1 <= A.length - 1 && A[end + 1] == target) end++;
                return new int[]{start, end};
            }
            if (A[mid] > target) {
                end = mid;
            }
            else start = mid;
        }
        if (A[start] == target && A[end] == target) return new int[]{start, end};
        if (A[start] == target) return new int[]{start, start};
        if (A[end] == target) return new int[]{end, end};
        return new int[]{-1, -1};
    }
    public static void main(String[] args) // unit tests (not graded)
    {
        int[] L;
        L = new int[]{232, 124, 456};
        int k = 124;
        int[] ans = new int []{1, 1};
        SearchRange s = new SearchRange();
        if (s.searchRange(L, k) == ans) System.out.println("Success");
        else System.out.println("fail");
    }
}
