package validParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Xiaojun YU on 2017-03-14.
 */
public class isValid {
    ArrayList test;

    public static boolean isValid(String s) {
        // corner case when s is null or ''
        if (s == null || s.length() == 0) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
    // the string is valid if the stack is empty
    return stack.isEmpty();
    }
}

