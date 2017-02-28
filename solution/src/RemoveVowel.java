/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class RemoveVowel {
    public static String removeVowel(String s)
    {
        String t = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray())
        {
            if(t.indexOf(c) >= 0) continue;
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeVowel("abcdef"));
    }
}
