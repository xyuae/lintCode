import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class hashMapDial {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */

    public ArrayList<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList();
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

        StringBuilder sb = new StringBuilder();
        helper(digits, map, res, sb, 0);
        return res;
    }
    private void helper(String digits, HashMap<Character, char[]> map, ArrayList<String> res, StringBuilder sb, int pos){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        //sb.length()表明当前在哪一位上
        for(char c : map.get(digits.charAt(pos))){
            sb.append(c);
            helper(digits, map, res, sb, pos + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
