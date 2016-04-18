package DynamicProgramming;

/**
 * Created by Anand on 4/12/2016.
 */
public class RodCutting {

    public static int rodCut(int len, int[] prices) {

        if (len == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, prices[i] +rodCut(len-i-1, prices));
        }
        return max;
    }

}
