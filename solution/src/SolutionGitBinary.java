

/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class SolutionGitBinary {
    /**
     * public class SVNRepo {
     *     public static boolean isBadVersion(int k);
     * }
     * you can use SVNRepo.isBadVersion(k) to judge whether
     * the kth code version is bad or not.
     */

    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        if (n == 0) return -1;

        int start = 1;
        int end = n;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) end = mid;
            else start = mid;
        }
        if (SVNRepo.isBadVersion(start)) return start;
        if (SVNRepo.isBadVersion(end)) return end;
        return -1;
    }


    public static void main(String[] args) // unit tests (not graded)
    {

    }
}
