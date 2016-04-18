package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anand on 4/17/2016.
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> mList = new ArrayList<>();
        Arrays.sort(nums);
        Boolean[] used = new Boolean[nums.length];
        permuteHelper(mList, used, nums, 0, nums.length);
        System.out.println(mList);
        return mList;
    }

    public static void permuteHelper(List<List<Integer>> mList, Boolean used[], int[] nums, int i, int len) {
        if (i == len) {
            List<Integer> sol = new ArrayList<>();
            for (int n : nums)
                sol.add(n);
            mList.add(sol);
        }


        //takes care of duplicates too
        for (int k = i; k < len; k++) {
            if (!isDuplicate(nums, i, k)) {
                used[i] = true;
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                permuteHelper(mList, used, nums, i + 1, len);
                temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static boolean isDuplicate(int[] nums, int begin, int i) {
        for (int a = begin; a < i; a++) {
            if (nums[a] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        permute(new int[]{1, 1, 2});
    }

}
