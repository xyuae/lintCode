import java.util.Stack;

/**
 * Created by Xiaojun YU on 2017-02-26.
 */
public class ValidParentehses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')')
            {
                if (!stack.empty() && stack.peek() == '(') stack.pop();
                else return false;
            }
            else if (c == ']')
            {
                if (!stack.empty() && stack.peek() == '[') stack.pop();
                else return false;
            }
            else if (c == '}')
            {
                if (!stack.empty() && stack.peek() == '{') stack.pop();
                else return false;
            }
            else stack.push(c);
        }
        return stack.empty();
        /*
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if(c == ')')
            {
                if (!stack.empty() && stack.peek() == '(') stack.pop();
                else return false;
            }
            else if (c == ']')
            {
                if (!stack.empty() && stack.peek() == '[') stack.pop();
                else return false;
            }
            else if (c == '}')
            {
                if (!stack.empty() && stack.peek() == '{') stack.pop();
                else return false;
            }
            else stack.push(c);
        }
        return stack.empty();
        */
    }
}
