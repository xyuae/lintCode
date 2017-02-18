import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class PowerOf2 {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // check negative number
        if (n < 0) return false;
        return (n!= 0 && (n&(n - 1)) == 0);
    }
}
