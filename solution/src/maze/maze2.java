package maze;

import java.util.Arrays;

/**
 * Created by Xiaojun YU on 2017-03-01.

public class maze2 {

    private static final int[] DIRECTIONS = {0, 1, 0 , -1 , 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] startedHere = new boolean[maze.length][maze[0].length]; // mark vistied starting points
        return dfs(maze, startedHere, start, destination);
    }

    private boolean dfs(int[][] maze, boolean[][] startedHere, int[] start, int[] destination) {
        if (startedHere[start[0]][start[1]]) return false;
        if (Arrays.equals(start, destination)) return true;

        startedHere[start[0]][start[1]] = true; // in case we roll back to a point we already started at

        for (int i = 0; i < DIRECTIONS.length - 1; i++) {
            int[] newStart = roll(maze, start[0], start[1], DIRECTIONS[i], DIRECTIONS[i + 1]);
            if (dfs(maze, startedHere, newStart, destination)) return true;
        }
        return false;
    }
        private int[] roll(int[][] maze, int row, int col, int rowInc, int colInc) {
            while (canRoll(maze, row + rowInc, col + colInc)) {
                row += rowInc;
                col += colInc;
            }
            return new int[]{row, col};
        }

        private boolean canRoll(int[][] maze, int row, int col) {
        if (row >= maze.length || row < 0 || col >= maze[0].length || col < 0) return false;
        return maze[row][col] != 1;
    }
}
**/