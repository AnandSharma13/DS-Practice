package DynamicProgramming;

/**
 * Created by Anand on 4/7/2016.
 */
public class CoinChange {

    public static int foo(int[] nums, int n, int sum) {

        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n <= 0 && sum >= 0)
            return 0;

        return foo(nums, n - 1, sum) + foo(nums, n, sum - nums[n - 1]);
    }

    public static int fooDP(int[] nums, int n, int sum) {

        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        int[] sol = new int[sum + 1];

        for (int i = 0; i <= sum; i++) {
            for (int j = sol[i]; j < n; j++) {
                sol[i] += sol[i - nums[j - 1]];
            }

        }
        return -1;
    }


    public static void main(String ars[]) {
        System.out.println(foo(new int[]{1, 2, 3}, 3, 4));

    }


}
