package Arrays;

/**
 * Created by Anand on 2/1/2016.
 */
public class MiscellaneousProblems {


    public static void findKthSmallest(int[] nums, int k) {

        boolean swapped = true;
        int j = 0;

        while (swapped == true) {
            swapped = false;
            if (j == k)
                break;
            else
                j++;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        arrayPrinter(nums);
    }

    public static void arrayPrinter(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 2, 5, 0, 4, 1, 2};
        findKthSmallest(nums, 3);
    }
}
