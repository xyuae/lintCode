package Palindrome_Permutation;

import java.util.HashMap;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        } else if (s.length() == 1 || s.length() == 0) {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                int count = map.get(temp);
                map.put(temp, count + 1);
            } else {
                map.put(temp, 1);
            }
        }
        Object[] count = map.values().toArray();
        int sum = 0;
        for (Object i : count) {
            sum += (int) i;
        }
        return (sum % 2 == 0);
    }
}