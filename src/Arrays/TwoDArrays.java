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


    public static void main(String[] args) {
        int[][] inputArray = new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};
        int color = 3;
        floodFill(inputArray, 1, 1, color);
    }


}
