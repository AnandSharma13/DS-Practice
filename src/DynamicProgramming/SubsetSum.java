package DynamicProgramming;

/**
 * Created by Anand on 4/6/2016.
 */
public class SubsetSum {


    public static boolean foo(int[] nums, int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        return foo(nums, n - 1, sum - nums[n - 1]) || foo(nums, n - 1, sum);
    }

    public static boolean fooDP(int[] nums, int n, int sum) {

        boolean[][] matrix = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            matrix[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            matrix[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                matrix[i][j] = matrix[i - 1][j];
                if (j >= nums[i - 1]) {
                    matrix[i][j] = matrix[i][j] ||matrix[i-1][j-nums[i-1]];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 4, 1, 3, 5, 8};
        System.out.println(foo(nums, nums.length, 29));

    }
}
