/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class RotateString {
    public static boolean isRotated(String s, String t)
    {
        if(s == null && t == null) return true;
        else if (s == null || t == null) return false;
        return (s.length() == t.length()) && ((s + s).indexOf(t) != -1);
    }

    public static void main(String[] args) {
        String s = "abcdef", t = "efabcd";
        System.out.println(isRotated(s, t));
    }
}
