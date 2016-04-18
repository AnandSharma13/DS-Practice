package LeetCode;

/**
 * Created by Anand on 4/16/2016.
 */
public class SudokuSolver {

    public static void solve(char[][] board) {


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
}