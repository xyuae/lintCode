import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class SolutionMatrixZero {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // when the matrix is not null, the matrix.length represent the length of the column, it won't be null
        if (matrix == null || matrix.length == 0) return;
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<int[]> zero = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) zero.add(new int[]{i, j});
            }
        }
        HashMap<Integer, Integer> rowZero = new HashMap<>();
        HashMap<Integer, Integer> colZero = new HashMap<>();

        for (int[] item: zero) {
            rowZero.put(item[0], 1);
            colZero.put(item[1], 1);
        }

        for (int i: rowZero.keySet()) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j: colZero.keySet()) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }
    public static void main(String[] args) // unit tests (not graded)
    {

    }
}
