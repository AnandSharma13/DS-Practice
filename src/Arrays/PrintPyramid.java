package Arrays;

/**
 * Created by Anand on 4/22/2016.
 */
public class PrintPyramid {



    public static void printPyramid(int depth){
        if(depth == 0)
            return;

        int rowCount = 1;
        for(int i =depth; i>=1;i--){

            for(int j =0;j<i;j++)
                System.out.print(" ");

            for(int k=0;k<rowCount;k++)
                System.out.print("# ");
            rowCount++;
            System.out.println();

        }
    }

    public static void printPyramidOnesTwos(int depth){
        if(depth == 0)
            return;

        int rowCount = 1;
        for(int i =depth-1; i>=0;i--){

            for(int j =0;j<i;j++)
                System.out.print(" ");

            for(int k=1;k<=rowCount;k++)
                System.out.print(k+" ");
            rowCount++;
            System.out.println();

        }
    }
    public static void main(String args[]) {
        printPyramid(3);
        printPyramidOnesTwos(3);
    }

}
