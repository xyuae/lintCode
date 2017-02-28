/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class GrayCode {
    public static boolean isConsecutive(byte a, byte b)
    {
        byte c = (byte)(a ^ b);
        int count = 0;
        while (c != 0)
        {
            c &= (c - 1);
            count++;
            if (count > 1) return false;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        // auto-generated method stub
        byte a = 0x31, b = 0x33;
        System.out.println(isConsecutive(a, b));
    }
}
