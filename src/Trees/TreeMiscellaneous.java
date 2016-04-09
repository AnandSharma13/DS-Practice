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

    public static int maxDepth(TreeNode root){
        if(root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }

    public static TreeNode LcaBT(TreeNode root, TreeNode node1, TreeNode node2){
        if(root == null)
            return null;
        if(root == node1|| root ==node2){
            return root;
        }
        TreeNode left = LcaBT(root.left, node1, node2);
        TreeNode right = LcaBT(root.right, node1, node2);

        if(left!=null && right!=null)
            return root;
        else
            return left==null?right:left;

    }

    public static boolean isValidBst(TreeNode root){
        return isValidBst(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    static boolean isValidBst(TreeNode root, int max, int min){
        if(root == null)
            return true;
        if(root.val<=min||root.val>=max)
            return false;

        return isValidBst(root.left, root.val, min)||isValidBst(root.right,max, root.val);

    }

    public static void main(String [] args){
       BTreePrinter.printNode(sortedArrayToBST(new int []{1,2,3}));
    }
}
