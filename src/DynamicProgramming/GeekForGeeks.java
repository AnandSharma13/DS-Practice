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

    public static int minJumpsDP(int []arr){

        int n = arr.length;
        if(n==0|| arr[0]==0){
            return 0;
        }
        int [] jumps = new int[n];
        jumps[0] =0;

        for (int i =1; i<n;i++){
            jumps[i]= Integer.MAX_VALUE;
            for(int j =0;j<i;j++){
                if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE){
                    jumps[i] = Math.min(jumps[i],jumps[j]+1);
                }
            }
        }
        return jumps[n-1];
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


    public static void main(String[] args) {
        System.out.println(minJumpsDP(new int[]{2, 3, 0, 1, 4}));

    }
}
