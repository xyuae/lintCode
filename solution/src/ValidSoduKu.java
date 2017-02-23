import java.util.HashSet;

/**
 * Created by Xiaojun YU on 2017-02-22.
 */
public class ValidSoduKu {
    /**
     * @param board: the board
     @return: wether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        HashSet<Character> set = new HashSet<>();
        int n = 9;
        // check each row
        for (int i = 0; i < n; i++){
            set.clear();
            for (int j = 0; j < n; j++) {
                if(!isValidChar(board[i][j], set)) return false;
            }
        }
        // check each column
        for (int j = 0; j < n; j++){
            set.clear();
            for (int i = 0; i < n; i++){
                if (!isValidChar(board[i][j], set)) return false;
            }
        }

        // check sub matrix
        for (int i = 0; i < n; i += 3){
            for (int j = 0; j < n; j += 3){
                set.clear();
                for (int k = 0; k < n; k++){
                    if(!isValidChar(board[i + k/3][j + k % 3], set)) return false;
                }
            }
        }
        return true;
    }

    private boolean isValidChar(char character, HashSet<Character> set){
        if (character == '.') return true;
        int num = character - '0';
        if (num < 1 || num > 9 || set.contains(character)) return false;
        set.add(character);
        return true;
    }
}
