/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0)
        {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}
