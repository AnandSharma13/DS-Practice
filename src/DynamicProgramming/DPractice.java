package DynamicProgramming;

/**
 * Created by Anand on 5/23/2016.
 */
public class DPractice {

    public static void fibonacci(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[n]);
    }

    public static int LongestIncreasingSubsequence(int[] nums) {
        int sol = 0;
        if (nums == null || nums.length == 0)
            return sol;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i] > dp[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            sol = Math.max(sol, dp[i]);
        }
        return sol;
    }

    public static int LongestCommonSubsequence(String str1, String str2) {
        if (str1 == null || str2 == null)
            return 0;
        int str1Len = str1.length();
        int str2Len = str2.length();
        int[][] lookUp = new int[str1Len + 1][str1Len + 1];
        for (int i = 0; i < str1Len; i++)
            lookUp[0][i] = 0;
        for (int j = 0; j < str2Len; j++)
            lookUp[j][0] = 0;

        for (int i = 1; i < str1Len; i++) {
            for (int j = 1; j < str2Len; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    lookUp[i][j] = 1 + lookUp[i - 1][j - 1];
                else {
                    lookUp[i][j] = Math.max(lookUp[i - 1][j], lookUp[j][i - 1]);
                }
            }
        }
        return lookUp[str1Len][str2Len];
    }

    public static int coinChange(int[] coins, int sum) {
        return 0;
    }

    public static boolean subSetSum(int[] nums, int sum) {
        boolean[][] lookUp = new boolean[sum + 1][nums.length + 1];
        for (int i = 1; i <= sum; i++)
            lookUp[i][0] = false;
        for (int i = 0; i <= nums.length; i++)
            lookUp[0][i] = true;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= nums.length; j++) {
                lookUp[i][j] = lookUp[i][j - 1];
                if (nums[j - 1] <= i) {
                    lookUp[i][j] = lookUp[i][j] || lookUp[i - nums[j - 1]][j - 1];
                }
            }
        }
        printMatrix(lookUp);
        return lookUp[sum][nums.length];
    }

    public static int editDistanceRecursive(String word1, int n, String word2, int m) {
        if (n == 0)
            return m;
        if (m == 0)
            return n;

        if (word1.charAt(m - 1) == word2.charAt(n - 1))
            return editDistanceRecursive(word1, n - 1, word2, m - 1);
        else
            return 1 + Math.min(Math.min(editDistanceRecursive(word1, n, word2, m - 1),      //insert
                    editDistanceRecursive(word1, n - 1, word2, m)),              //replace
                    editDistanceRecursive(word1, n - 1, word2, m - 1));          //remove
    }

//    public static int editDistanceDP(String word1, String word2){
//        int word1Len = word1.length();
//        int word2Len = word2.length();
//
//        int [][]lookUp = new int [word1Len+1][word2Len+1];
//
//    }

    public static void printMatrix(boolean[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 8, 10};
        System.out.println(subSetSum(nums, 8));
    }
}
