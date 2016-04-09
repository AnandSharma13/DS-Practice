package DynamicProgramming;

/**
 * Created by Anand on 4/6/2016.
 */
public class LongestCommonSubsequence {

    public static int LCSRecursive(String str1, int m, String str2, int n) {
        if (m < 0 || n < 0 || str1 == null || str2 == null)
            return 0;
        if (str1.charAt(m) == str2.charAt(n)) {
            return 1 + LCSRecursive(str1, m - 1, str2, n - 1);
        }
        return Math.max(LCSRecursive(str1, m - 1, str2, n), LCSRecursive(str1, m, str2, n - 1));
    }

    public static int LCSDynamicProgramming(String str1, int m, String str2, int n) {
        int matrix[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1] +1;
                else
                    matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
            }
        }
        printMatrix(matrix);
        return matrix[m][n];
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
        System.out.println(LCSRecursive("AGGTAB" ,5,"GXTXAYB",6));
        System.out.println(LCSDynamicProgramming( "AGGTAB" ,6,"GXTXAYB",7));
    }


}
