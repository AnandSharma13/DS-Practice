package DynamicProgramming;

/**
 * Created by Anand on 2/5/2016.
 */
public class GeekForGeeks {


    public static void LongestIncreasingSubsequence(int[] nums) {

        int[] lis = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] > max)
                max = lis[i];
        }
        System.out.println(max);
    }

    public static int minJumpsDP(int[] arr) {

        int n = arr.length;
        if (n == 0 || arr[0] == 0) {
            return 0;
        }
        int[] jumps = new int[n];
        jumps[0] = 0;

        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }
        return jumps[n - 1];
    }

    public static void fib(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        System.out.println(f[n]);
    }

    public static boolean subsetSum(int[] nums, int k) {
        //i,j - i will be the sum of the array
        boolean[][] solution = new boolean[k + 1][nums.length + 1];
        for (int i = 0; i <= k; i++)
            solution[i][0] = false;
        for (int j = 0; j <= nums.length; j++)
            solution[0][j] = true;

        for (int i = 1; i <= k; i++)
            for (int j = 1; j <= nums.length; j++) {
                solution[i][j] = solution[i][j - 1];
                if (i >= nums[j - 1]) {
                    solution[i][j] = solution[i][j] || solution[i - nums[j - 1]][j - 1];
                }
            }
        return solution[k][nums.length];
    }

    // no dp version of largest sub array sum
    public static int largestSubArraySum(int[] nums) {

        int curr_max = 0;
        int max_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            curr_max += nums[i];
            if (curr_max < 0)
                curr_max = 0;
            else if (curr_max > max_sum) {
                max_sum = curr_max;
            }
        }
        return max_sum;
    }

    public static int largestSubArraySumDP(int [] nums){
        int curr_max =0;
        int max_sum =0;

        for(int i =0;i<nums.length;i++){
            curr_max = Math.max(nums[i], curr_max + nums[i]);
            max_sum = Math.max(curr_max, max_sum);
        }
        return max_sum;
    }



    public static void main(String[] args) {
        System.out.println(largestSubArraySumDP(new int[]{2, -1, 0,-5, 4}));

    }
}
