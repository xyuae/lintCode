/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class ReplaceBlank {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if (string == null || length == 0) return 0;
        // count the new array length
        int num = 0;
        for (int ithChar : string) {
            if (ithChar == ' ') num++;
        }
        int newLen = length + 2 * num;
        string[newLen] = 0;
        int j = 1;
        for (int i = length - 1; i>= 0; i--) {
            if (string[i] != ' ') {
                string[newLen - j] = string[i];
                j++;
            }
            else {
                string[newLen - j] = '0';
                j++;
                string[newLen - j] = '2';
                j++;
                string[newLen - j] = '%';
                j++;
            }
        }
        return newLen;
    }
}
