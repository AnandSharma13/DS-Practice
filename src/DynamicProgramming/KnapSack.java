package DynamicProgramming;

/**
 * Created by Anand on 4/10/2016.
 */
public class KnapSack {


    public static int foo(int[] wt, int[] val, int len, int maxWt) {

        if (len == 0 || maxWt == 0)
            return 0;
        if (wt[len - 1] > maxWt)
            return foo(wt, val, len - 1, maxWt);

        return Math.max(val[len - 1] + foo(wt, val, len - 1, maxWt - wt[len - 1]), foo(wt, val, len - 1, maxWt));
    }

    public static int fooDP(int[] wt, int[] val, int len, int maxWt) {

        if (len == 0 || maxWt == 0)
            return 0;

        int[][] sol = new int[maxWt + 1][len + 1];

        for (int i = 0; i <= maxWt; i++) {
            for (int j = 0; j <= len; j++) {
                if (i == 0 || j == 0)
                    sol[i][j] = 0;

                else if (wt[j - 1] <= i) {
                    sol[i][j] = Math.max(val[j - 1] + sol[i - wt[j - 1]][j - 1], sol[i][j - 1]);
                } else {
                    sol[i][j] = sol[i][j - 1];
                }
            }
        }
        return sol[maxWt][len];
    }

    public static void main(String[] args) {
        int[] wt = new int[]{2, 4, 1};
        int[] val = new int[]{10, 5, 30};
        int maxWt = 4;
        System.out.println(foo(wt, val, 3, 4));
        System.out.println(fooDP(wt, val, 3, 4));

    }

}
