package Sorting;

/**
 * Created by Anand on 2/1/2016.
 */
public class ComparisonSorts {


    public static void BubbleSort(int[] nums) {

        boolean swapped = true;
        //tracks the progress
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < nums.length - j; i++) {
                if (nums[i] > nums[i + 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tmp;
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
        int[] nums = new int[]{3, 4, 1, 2, 5};
        BubbleSort(nums);
    }

}
