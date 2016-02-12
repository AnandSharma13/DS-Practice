package Arrays;

/**
 * Created by Anand on 1/30/2016.
 */
public class TwoDArrays {


    public static int[][] floodFill(int[][] array, int x, int y, int color) {
        int prevColor = array[x][y];
        return floodFillUtils(array, x, y, prevColor, color);
    }

    public static int[][] floodFillUtils(int[][] array, int x, int y, int prevColor, int color) {

        int width = array.length;
        int height = array[0].length;
        //base condition here
        //return if the bounds are reached
        if (x < 0 || x >= width || y < 0 || y >= height)
            return array;
        if (array[x][y] != prevColor || array[x][y] == color)
            return array;
        array[x][y] = color;
        floodFillUtils(array, x + 1, y, prevColor, color);
        floodFillUtils(array, x - 1, y, prevColor, color);
        floodFillUtils(array, x, y + 1, prevColor, color);
        floodFillUtils(array, x, y - 1, prevColor, color);
        return array;
    }


    public static void printMatrixSpiral(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int x = 0;
        int y = 0;
        while (rows > 0 && cols > 0) {

            if (rows == 1) {
                for (int i = 0; i < cols; i++)
                    System.out.println(matrix[0][i]);
                break;
            }

            if (cols == 1) {
                for (int i = 0; i < rows; i++)
                    System.out.println(matrix[i][0]);
                break;
            }

            //lets go right
            for (int i = 0; i < rows - 1; i++)
                System.out.println(matrix[x][y++]);

            for (int j = 0; j < cols - 1; j++)
                System.out.println(matrix[x++][y]);

            for (int i = 0; i < rows - 1; i++)
                System.out.println(matrix[x][y--]);

            for (int i = 0; i < cols - 1; i++)
                System.out.println(matrix[x--][y]);

            rows = rows - 2;
            cols = cols - 2;
            x++;
            y++;

        }

    }

//    write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//    Integers in each row are sorted in ascending from left to right.
//    Integers in each column are sorted in ascending from top to bottom.


    public static void main(String[] args) {
        int[][] inputArray = new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};

        printMatrixSpiral(inputArray);
    }




}
