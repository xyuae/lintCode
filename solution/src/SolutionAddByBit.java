

/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class SolutionAddByBit {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    // while (!n) is not allowed if n is negative
    public static int add(int a, int b) {
        while (b != 0) {
            // get all the added bit without upgrading
            int _a = a ^ b;
            // _b all the bit waiting to be upgraded
            int _b = a & b;
            // upgrade by shifting
            b = (_b << 1);
            a = _a;
        }
        return a;
    }
    public static void main(String[] args) // unit tests (not graded)
    {

    }
}
