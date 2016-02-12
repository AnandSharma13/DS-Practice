package Arrays;

/**
 * Created by Anand on 2/1/2016.
 */
public class LeetCodeArrays {


    public static void findSortedArray(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (nums[lo] > nums[hi]) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        System.out.println("Array is rotated from " + nums[lo]);
    }

    public static void searchRotatedSorted(int[] nums, int k) {

        //find the rotation of sorting
        int lo = 0;
        int length = nums.length;
        int hi = length - 1;

        while (nums[lo] > nums[hi]) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        int index = lo;
        lo = 0;
        hi = length - 1;
        while (lo <= hi) {
            int mid = lo + hi / 2;
            int realMid = (index + mid) % length;
            if (nums[realMid] == k) {
                System.out.println("Number found");
                return;
            } else if (nums[realMid] < k)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{7, 8, 9, 10, 11, 12, 13, -1, 2, 4};
        searchRotatedSorted(nums, 2);
    }
}
