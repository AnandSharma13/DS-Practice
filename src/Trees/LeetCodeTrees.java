package Trees;

/**
 * Created by Anand on 1/24/2016.
 */
public class LeetCodeTrees {



    public static boolean findInBinaryTree(TreeNode root, int data){

        if(root == null)
            return false;
        if(root.val == data)
            return true;
        else
        return findInBinaryTree(root.left,data) || findInBinaryTree(root.right,data);

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q ==  null)
            return  p ==q;

        if(p.val == q.val)
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        else
            return false;
    }

    public int sumNumbers(TreeNode root) {

        int value =0;
        return sumNumberHelper(root, value);
    }

    public int sumNumberHelper(TreeNode root, int value){

        if(root == null)
            return 0;
        int sum = value*10+root.val;
        if(root.left == null && root.right == null)
            return sum;
        else
            return sumNumberHelper(root.left,sum) + sumNumberHelper(root.right,sum);

    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {

        if(left == null || right == null)
            return left == right;
        if(left.val != right.val)
            return false;
        else
            return isSymmetricHelper(left.left, right.left) && isSymmetricHelper(left.right, right.left);

    }

    public static boolean isValidBstHelper(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return isValidBstHelper(root.left, min, root.val) && isValidBstHelper(root.right, root.val, max);
    }

    public static boolean isValidBst(TreeNode root) {

        return isValidBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int findMax(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int left_val;
        int right_val;
        int root_val = root.val;
        int max = root.val;

        left_val = findMax(root.left);
        right_val = findMax(root.right);

        max = left_val > right_val ? left_val : right_val;
        if (root_val > max)
            max = root_val;

        return max;


    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(8);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(22);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(findInBinaryTree(n1,23));
    }



}
