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

    public static boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

    public static void reverseNumber(int x){
        int result =0;
        while(x>0){
            result = result*10 + x%10;
            x=x/10;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        int[] nums = new int[]{7, 8, 12, 13, -1, 2, 4};

        int res = 6^54^2^3^4^1^5;
        int two = 1^2^3^4^5;
        System.out.println(res);
        System.out.println(two);
        System.out.println(res^two);

    }


}
