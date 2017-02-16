

/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class SearchRoatedArray {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            boolean isRotated = false;
            if (A[start] > A[end]) isRotated = true;
            if (A[mid] == target) return mid;
            // if the current array is Rotated array
            if (!isRotated) {
                if (A[mid] > target) {
                    end = mid;
                }
                else start = mid;
            }
            else {
                if (A[mid] > target) {
                    if (A[end] > A[mid]) end = mid;
                    else {
                        if (target == A[end]) return end;
                        else if (target < A[end]) start = mid;
                        else end = mid;
                    }
                }
                else {
                    if (A[end] > A[mid]) {
                        if (target == A[end]) return end;
                        else if (target < A[end]) start = mid;
                        else end = mid;
                    }
                    else start = mid;
                }
            }
        }
        if (A[start] == target) return start;
        if (A[end] == target) return end;
        return -1;
    }
    public static void main(String[] args) // unit tests (not graded)
    {
        int[] L;
        L = new int[]{232, 124, 456};
        int k = 124;
        int ans = 1;
        SearchRoatedArray s = new SearchRoatedArray();
        if (s.search(L, k) == ans) System.out.println("Success");
        else System.out.println("fail");
    }
}
