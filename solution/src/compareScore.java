import java.util.Scanner;

/**
 * Created by Xiaojun YU on 2017-03-06.

public class compareScore {
    import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

    public static class Solution {
        public static final int[] compare(int a0, int a1, int a2, int b0, int b1, int b2) {
            int countA = 0;
            int countB = 0;
            if (a0 > b0) {
                countA++;
            }
            else if (a0 < b0) {
                countB++;
            }
            if (a1 > b1) {
                countA++;
            }
            else if (a1 < b1) {
                countB++;
            }
            if (a2 > b2) {
                countA++;
            }
            else if (a2 < b2) {
                countB++;
            }
            return new int[]{countA, countB};
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a0 = in.nextInt();
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            int b0 = in.nextInt();
            int b1 = in.nextInt();
            int b2 = in.nextInt();
            int[] res = compare(a0, a1, a2, b0, b1, b2);
            System.out.println(res[0] + " " + res[1]);
        }
    }

}
*/