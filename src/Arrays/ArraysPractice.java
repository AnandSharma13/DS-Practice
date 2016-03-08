package Arrays;

/**
 * Created by Anand on 3/7/2016.
 */
public class ArraysPractice {


    //partition algorithm
    public static int kthLargest(int [] nums, int k){

        int lo =0;
        int hi = nums.length-1;

        while(lo<hi){
        int mid = partition(nums, lo, hi);
        if(mid == k) return nums[mid];
        else if (mid>k){
            hi = mid-1;
        }
        else
            lo = mid+1;
        }
        return -1;
    }

    public static int partition(int [] nums, int lo, int hi){

        int i =lo;
        int j = lo;
        int pivot = nums[hi];
        while(i<=hi && j<=hi){
            if(nums[i]>pivot)
                i++;

            else if (nums[i]<=pivot){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return j-1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 2, 5,0};
        System.out.println(kthLargest(nums,0 ));
        // arrayPrinter(nums);
    }

    public static void arrayPrinter(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }


}
