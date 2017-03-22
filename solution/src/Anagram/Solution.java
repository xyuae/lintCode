package Anagram;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Xiaojun YU on 2017-03-19.
 */
public class Solution {
    public static int NUMBER_LETTERS = 26;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        System.out.println(numberNeeded(first, second));
    }

    private static int numberNeeded(String first, String second) {
        int[] charCount1 = getCharCounts(first);
        int[] charCount2 = getCharCounts(second);
        return getDelta(charCount1, charCount2);
    }

    private static int getDelta(int[] charCount1, int[] charCount2) {
        if (charCount1.length != charCount2.length) {
            return -1;
        }
        int delta = 0;
        for (int i = 0; i < charCount1.length; i++) {
            int difference = Math.abs(charCount1[i] - charCount2[i]);
            delta += difference;
        }
        return delta;
    }

    private static int[] getCharCounts(String s) {
        int[] charCounts = new int[NUMBER_LETTERS];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int offset = (int) 'a';
            int code = c - offset;
            charCounts[code]++;
        }
        return charCounts;
    }
}