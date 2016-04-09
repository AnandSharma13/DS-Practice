package BackTracking;

/**
 * Created by Anand on 4/7/2016.
 */
public class RatMaze {

    static boolean solveRatMaze(int[][] maze) {

        int[][] sol = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        return solveRatMazeUtils(maze, 0, 0, sol, 3, 3);

    }

    static boolean isValid(int[][] maze, int x, int y, int N) {
        return (x < N && x >= 0 && y < N && y >= 0 && maze[x][y] == 1);
    }

    static boolean solveRatMazeUtils(int[][] maze, int x, int y, int[][] sol, int destX, int destY) {
        if (x == destX - 1 && y == destY - 1) {
            printMatrix(sol);
            return true;
        }
        if (isValid(maze, x, y, maze.length)) {
            sol[x][y] = 1;
            if (solveRatMazeUtils(maze, x, y + 1, sol, destX, destY)) {
                return true;
            }
            if (solveRatMazeUtils(maze, x + 1, y, sol, destX, destY)) {
                return true;
            }
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        int maze[][] = new int[][]{{1, 0, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(solveRatMaze(maze));

    }
}
