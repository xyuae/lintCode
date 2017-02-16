

/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class SolutionBitFlip {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    // while (!n) is not allowed if n is negative
    public static int bitSwapRequired(int a, int b) {
        int n = a ^ b;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
    public static void main(String[] args) // unit tests (not graded)
    {

    }
}
