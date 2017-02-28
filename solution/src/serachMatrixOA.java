/**
 * Created by Xiaojun YU on 2017-02-26.
 */
public class serachMatrixOA {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right)
        {
            int middle = left + (right - left) / 2;
            int i = middle / n;
            int j = middle % n;
            if(matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) right = middle - 1;
            else left = middle + 1;
        }
        return false;
    }
}
