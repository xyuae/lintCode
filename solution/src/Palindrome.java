import java.util.Stack;

import static java.lang.Character.isAlphabetic;

/**
 * Created by Xiaojun YU on 2017-02-22.
 */
public class Palindrome {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) return true;
        String copy = s.toLowerCase();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < copy.length(); i++){
            char letter = copy.charAt(i);
            if (!Character.isLetterOrDigit(letter)) continue;
            stack.push(letter);
        }
        for (int i = 0; i < copy.length(); i++){
            char letter = copy.charAt(i);
            if (!Character.isLetterOrDigit(letter)) continue;
            Character letter2 = stack.pop();
            if (letter != letter2) return false;
        }
        return true;
    }
}