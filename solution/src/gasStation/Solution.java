package gasStation;

/**
 * Created by Xiaojun YU on 2017-03-08.
 */
public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if (gas == null || cost == null) {
            return -1;
        }
        int count = 0;
        int index = 0;
        //int max = 0;
        int i = 0;
        while (i < gas.length) {
            int temp = gas[i] - cost[i];
            count += temp;
            if (count < 0 && temp < 0) {
                index = i + 1;
            }
            i++;
        }
        if (count < 0) {
            //System.out.println(count);
            return -1;
        }
        return index % gas.length;
    }

    public void testPractice2() throws Exception {

    }
}
