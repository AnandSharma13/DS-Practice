package DynamicProgramming;

/**
 * Created by Anand on 6/14/2016.
 */
public class SubSum {


    public static boolean subSumRecursive(int [] num, int len, int sum){

        if(sum ==0)
            return true;

        if(len ==0)
            return false;
        if(num[len-1] > sum)
            return subSumRecursive(num, len-1, sum);

        return subSumRecursive(num, len-1, sum - num[len-1]) || subSumRecursive(num, len-1, sum);
    }

    public static boolean subSumDp(int [] num, int len, int sum){

        boolean [][] lookUp = new boolean [len +1][sum+1];

        for(int i =0;i<=len;i++)
            lookUp[i][0] = true;
        for(int i =1;i<=sum;i++)
            lookUp[0][i] = false;

        for(int i =1;i<=len;i++)
            for(int j=1;j<=sum;j++){
                lookUp[i][j] = lookUp[i-1][j];
                if(num[i-1]<=j){
                     lookUp[i][j] = lookUp [i][j] || lookUp[i-1][j-num[i-1]];
                }

            }
        return lookUp[len][sum];
    }


        public static void main(String[] args) {
        int[] nums = new int[]{5, 1};
        System.out.println(subSumRecursive(nums, nums.length, 6));

    }
}
