package DynamicProgramming;

/**
 * Created by Anand on 4/5/2016.
 */
public class LongestIncreasingSubsequence {

    //    nums = [1,2,0,3,4,5]
//    Arr = [1,2,1,3,1,1]
    public static int LIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int arr[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(nums[j]<nums[i] && arr[j]+1>arr[i]){
                arr[i] = arr[j]+1;
                }
            }
        }
        int max =1;
        for(int i=1;i<n;i++){
            if(max<arr[i])
                max = arr[i];
        }
        System.out.println(max);

        return arr[n - 1];
    }


    public static void main(String[] args) {
        LIS(new int[]{1,1,0,3,4,5});

    }
}
