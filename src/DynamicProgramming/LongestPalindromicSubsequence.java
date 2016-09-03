package DynamicProgramming;

/**
 * Created by Anand on 6/6/2016.
 */
public class LongestPalindromicSubsequence {


    public static int longestPalindromicSubsequence(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int n = str.length();
        int[][] lookUp = new int[n][n];
        for(int i =0;i<n;i++)
            lookUp[i][i] = 1;

        for (int i = 2; i <= n; i++) {
            for(int j =0;j<n-i+1;j++){
                int k = i + j -1;
                if(i==2 && str.charAt(j) == str.charAt(k))
                    lookUp[j][k] =2;
                else if(str.charAt(j) == str.charAt(k))
                    lookUp[j][k] = 2 + lookUp[j+1][k-1];
                else
                    lookUp[j][k] = Math.max(lookUp[j+1][k], lookUp[j][k-1]);
            }
        }
        return lookUp[0][n-1];
    }

    public static void main(String [] args){
        System.out.println(longestPalindromicSubsequence("abada"));
    }
}
