package Trees;

/**
 * Created by Anand on 2/13/2016.
 */
public class TreeMiscellaneous {


    public static TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start>end)
            return null;
        int mid = start +(end -start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }

    public static void main(String [] args){
       BTreePrinter.printNode(sortedArrayToBST(new int []{1,2,3}));
    }
}
