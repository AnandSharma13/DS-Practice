package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    public static void reverseNumber(int x) {
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        System.out.println(result);
    }

    public static void sortThreeColors(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0 && i > begin) {
                int temp = nums[i];
                nums[i] = nums[begin];
                nums[begin] = temp;
                begin++;
            } else if (nums[i] == 2 && i < end) {
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
            } else
                i++;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{7, 8, 12, 13, -1, 2, 4};

        int res = 6 ^ 54 ^ 2 ^ 3 ^ 4 ^ 1 ^ 5;
        int two = 1 ^ 2 ^ 3 ^ 4 ^ 5;
        System.out.println(res);
        System.out.println(two);
        System.out.println(res ^ two);

    }


    //  Find three integers that sum to 0
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 2)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = nums[i];
                while (lo < hi) {
                    sum += nums[lo] + nums[hi];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        //avoid dupicates
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (sum > 0) {
                        hi--;
                    } else
                        lo++;
                }
            }
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {

        int max = 0;
        int area = 0;
        int i;
        Stack<Integer> myStack = new Stack<>();
        if (heights.length == 1)
            return heights[0];
        myStack.push(heights[0]);
        for (i = 0; i < heights.length; ) {
            if (myStack.isEmpty() || heights[myStack.peek()] <= heights[i])
                myStack.push(i++);
            else {
                int top = myStack.pop();
                if (myStack.isEmpty())
                    area = heights[top] * i;
                else {
                    area = heights[top] * (i - myStack.peek() - 1);

                }
                max = Math.max(area, max);
            }

        }

        while (!myStack.isEmpty()) {
            int top = myStack.pop();
            if (myStack.isEmpty())
                area = heights[top] * i;
            else {
                area = heights[top] * (i - myStack.peek() - 1);
                max = Math.max(area, max);
            }

        }
        return max;

    }


}
