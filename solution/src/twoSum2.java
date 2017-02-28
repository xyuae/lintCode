import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class twoSum2 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i])) return new int[] {map.get(target - nums[i]), i};
            else map.put(nums[i], i);
        }
        return null;
    }
}
