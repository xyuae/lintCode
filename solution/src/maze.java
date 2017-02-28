import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class maze {
    static final int[][] dir = {{1,0}, {-1, 0}, {0, 1},{0, -1}};
    public static int checkMaze(int[][] maze)
    {
        if(maze == null || maze.length ==0 || maze[0].length == 0 || maze[0][0] == 0) return 0;
        if(maze[0][0] == 9) return 1;
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        maze[0][0] = 0;
        while(!queue.isEmpty())
        {
            int[] p = queue.poll();
            for (int k = 0; k < 4; k++)
            {
                int x = p[0] + dir[k][0];
                int y = p[1] + dir[k][1];
                if (x >= 0 && x < m && y >= 0 && y < n)
                {
                    if(maze[x][y] == 9) return 1;
                    else if (maze[x][y] == 1)
                    {
                        queue.offer(new int[]{x, y});
                        maze[x][y] = 0;
                    }
                }
            }
        }
        return 0;
    }

}
