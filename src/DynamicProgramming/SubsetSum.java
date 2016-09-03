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

        boolean[][] lookUp = new boolean[sum + 1][nums.length + 1];
        for (int i = 1; i <= sum; i++)
            lookUp[i][0] = false;
        for (int i = 0; i <= nums.length; i++)
            lookUp[0][i] = true;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= nums.length; j++) {
                lookUp[i][j] = lookUp[i][j-1];
                if(nums[j-1]<=i){
                    lookUp[i][j] = lookUp[i][j] || lookUp[i-nums[j-1]][j-1];
                }
            }
        }

        return lookUp[sum][nums.length];
    }



    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 4, 1, 3, 5, 8};
        System.out.println(fooDP(nums, nums.length, 29));

    }
}
