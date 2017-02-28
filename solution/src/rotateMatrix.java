/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class rotateMatrix {
    public static int[][] rotate(int[][] matrix, int flag)
    {
        if (matrix == null || matrix.length == 0) return matrix;
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++) res[j][i] = matrix[i][j];
        }
        if(flag == 1)
        {
            for(int i = 0; i < n; i++)
            {
                for (int j = 0; j < m / 2; j++)
                {
                    int temp = res[i][j];
                    res[i][j] = res[i][m - 1 - j];
                    res[i][m - 1 -j] = temp;
                }
            }
        }
        else
        {
            for (int j = 0; j < m; j++)
            {
                for(int i = 0; i < n / 2; i++)
                {
                    int temp = res[i][j];
                    res[i][j] = res[n - 1 -i][j];
                    res[n - 1 - i][j] = temp;
                }
            }
        }
        return res;
    }
    public static void printMatrix(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
            System.out.println("");
        }
    }
}
