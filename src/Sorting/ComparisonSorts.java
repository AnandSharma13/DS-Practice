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

    public static void QuickSort(int[] nums, int lo, int hi) {

        if (lo < hi) {
            int mid = partition(nums, lo, hi);
            QuickSort(nums, lo, mid - 1);
            QuickSort(nums, mid + 1, hi);
        }
    }

    public static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        int j = lo;
        while (j <= hi && i <= hi) {
            if (nums[j] > pivot) {
                j++;
            } else if (nums[j] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return i - 1;
    }

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSort(nums, lo, mid);
            mergeSort(nums, mid + 1, hi);
            merge(nums, lo, mid, hi);
        }
    }

    public static void merge(int[] nums, int lo, int mid, int hi) {

        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        int[] temp1 = new int[n1 + 1];
        int[] temp2 = new int[n2 + 1];

        for (int i = 0; i < n1; i++)
            temp1[i] = nums[lo + i];

        for (int i = 0; i < n2; i++) {
            temp2[i] = nums[mid + i + 1];
        }

        // for the last value to prevent a null pointer
        temp1[n1] = Integer.MAX_VALUE;
        temp2[n2] = Integer.MAX_VALUE;

        for (int i = lo, j = 0, k = 0; i <= hi; i++) {

            if (temp1[j] < temp2[k]) {
                nums[i] = temp1[j];
                j++;
            } else if (temp2[k] < temp1[j]) {
                nums[i] = temp2[k];
                k++;
            } else {
                k++;
            }

        }

    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        arrayPrinter(arr);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 2, 5};
        insertionSort(nums);
        // arrayPrinter(nums);
    }


    public static void arrayPrinter(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
