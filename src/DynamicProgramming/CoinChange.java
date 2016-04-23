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
        sol[0]=1;
        for(int i=0; i<n; i++)
            for(int j=nums[i]; j<=sum; j++)
                sol[j] += sol[j-nums[i]];

        return sol[sum];
    }


    public static void main(String ars[]) {
        System.out.println(fooDP(new int[]{1, 2, 3}, 3, 1));

    }


}
