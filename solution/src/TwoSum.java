import java.util.Arrays;

/**
 * Created by Xiaojun YU on 2017-02-25.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        if(nums == null || nums.length < 2) return res;
        int[] copyList = new int[nums.length];
        System.arraycopy(nums, 0, copyList, 0, nums.length);
        Arrays.sort(copyList);

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int sum = copyList[low] + copyList[high];
            if(target > sum) {
                low++;
            } else if (target < sum){
                high--;
            } else {
                res[0] = copyList[low];
                res[1] = copyList[high];
                break;
            }
        }
        int index1 = -1;
        int index2 = -2;
        for (int i = 0; i < nums.length; i++){
            if (index1 != -1 && index2 != -1) break;
            if (index1 == -1 && nums[i] == res[0]){
                index1 = i;
            } else if (index2 == -1 && nums[i] == res[1]){
                index2 = i;
            }
        }
        res[0] = index1;
        res[1] = index2;
        return res;

        /*
        int low=0;
        int high=nums.length-1;

        while(low<high){
            if(target>copyList[low]+copyList[high]){
                low++;
            }else if(target<copyList[low]+copyList[high]){
                high--;
            }else if(target == copyList[low]+copyList[high]){
                res[0]=copyList[low];
                res[1]=copyList[high];
                break;
            }
        }

        int index1=-1;
        int index2=-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == res[0] && index1 == -1){
                index1=i;
            }else if(nums[i] == res[1] && index2 == -1){
                index2=i;
            }
        }

        res[0]=index1;
        res[1]=index2;
        Arrays.sort(res);
        return res;
        */
    }
}
