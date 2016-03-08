package Graphs;

/**
 * Created by Anand on 2/18/2016.
 */
public class BFSnDFS {

    public static void solve(char[][] board) {

        if (board == null)
            return;

        checkEdges(board);



        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 'O')
                    dfsMark(board, i, j, 'O', 'X');
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.println(String.valueOf(board[i][j]));
            }
        }

    }

    public static void checkEdges(char[][] board) {

        int rowLen = board.length;
        int colLen = 0;
        if (rowLen != 0)
            colLen = board[0].length;

        if (rowLen == 1) {
            for (int j = 0; j < colLen; j++) {
                if (board[0][j] == 'O')
                    dfsMark(board, 0, j, 'O', '*');
            }
            return;
        }

        if (colLen == 1) {
            for (int i = 0; i < rowLen; i++) {
                if (board[i][0] == 'O')
                    dfsMark(board, i, 0, 'O', '*');
            }
        }


        int rowCounter = 0;
        int colCounter = 0;

        for (int i = 0; i < colLen - 1; i++) {
            if (board[rowCounter][colCounter] == 'O')
                dfsMark(board, rowCounter, colCounter, 'O', '*');
            colCounter++;

        }

        for (int i = 0; i < rowLen - 1; i++) {
            if (board[rowCounter][colCounter] == 'O')
                dfsMark(board, rowCounter, colCounter, 'O', '*');
            rowCounter++;
        }


        for (int i = 0; i < colLen - 1; i++) {
            if (board[rowCounter][colCounter] == 'O')
                dfsMark(board, rowCounter, colCounter, 'O', '*');
            colCounter--;
        }

        for (int i = 0; i < rowLen - 1; i++) {
            if (board[rowCounter][colCounter] == 'O')
                dfsMark(board, rowCounter, colCounter, 'O', '*');
            rowCounter--;
        }

    }

    public static void dfsMark(char[][] board, int x, int y, char prevMarker, char marker) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }

        if ((board[x][y] != prevMarker) || (board[x][y] == marker)) {
            return;
        }
        char prev = board[x][y];
        board[x][y] = marker;
        dfsMark(board, x + 1, y, prev, marker);
        dfsMark(board, x - 1, y, prev, marker);
        dfsMark(board, x, y + 1, prev, marker);
        dfsMark(board, x, y - 1, prev, marker);

    }




    public static void main(String[] args) {

        char[][] multi = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        solve(multi);

    }

}
