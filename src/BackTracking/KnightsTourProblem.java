package BackTracking;

/**
 * Created by Anand on 4/7/2016.
 */
public class KnightsTourProblem {


    public static void solveKnights(int N) {

        int[][] matrix = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = -1;
            }

            int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
            int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

            solveKnightsUtils(0, 0, 1, matrix, xMove, yMove);
        }

    }

    static boolean isValid(int x, int y, int N, int[][] matrix) {
        return (x < N && x >= 0 && y < N && y >= 0 && matrix[x][y] == -1);
    }

    public static boolean solveKnightsUtils(int x, int y, int moveCount, int[][] matrix, int[] xMove, int[] yMove) {

        int N = matrix.length;
        if (moveCount == N * N)
            return true;


        for (int i = 0; i < xMove.length; i++) {

            int newX = x + xMove[i];
            int newY = x + yMove[i];

            if (isValid(newX, newY, N, matrix)) {
                matrix[newX][newY] = moveCount;
                if (solveKnightsUtils(newX, newY, moveCount + 1, matrix, xMove, yMove))
                    return true;
                else
                    matrix[newX][newY] = -1;
            }

        }
        return false;
    }


    public static void main(String[] args) {

        solveKnights(5);

    }

}
