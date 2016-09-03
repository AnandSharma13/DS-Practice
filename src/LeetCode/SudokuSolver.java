package LeetCode;

import java.util.HashSet;

/**
 * Created by Anand on 4/16/2016.
 */
public class SudokuSolver {


    public static boolean isSudokoValid(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> col = new HashSet<>();
        HashSet<Character> cube = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            row.clear();
            col.clear();
            cube.clear();
            for (int j = 0; j < board[0].length; j++) {
                // check for rows
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                int colIndex = 3 * (i % 3);
                int rowIndex = 3 * (i / 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] inputArray = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 9}};
        int i = 4;
        int j = 4;
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                System.out.println((i / 3) * 3);
                System.out.println((j / 3) * 3);

            }

    }

    public boolean solve(char[][] board){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; i++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= 9; c++) {
                        board[i][j] = c;
                        if(isSudokoValid(board)){
                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


}