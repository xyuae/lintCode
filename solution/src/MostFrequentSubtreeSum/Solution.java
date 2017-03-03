package MostFrequentSubtreeSum;


import DeleteBinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xiaojun YU on 2017-03-02.
 */
public class Solution {
    int maxFreq = 0;
    int count = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        int[] res = new int[count];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == maxFreq) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }

    private int traverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left, map);
        int right = traverse(root.right, map);

        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if (map.get(sum) > maxFreq){
            maxFreq = map.get(sum);
            count = 1;
        } else if (map.get(sum) == maxFreq) {
            count++;
        }
        return sum;
    }
}
