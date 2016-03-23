package Trees;

import java.util.*;

/**
 * Created by Anand on 1/24/2016.
 */
public class LeetCodeTrees {


    public static boolean findInBinaryTree(TreeNode root, int data) {


        if (root == null)
            return false;
        if (root.val == data)
            return true;
        else
            return findInBinaryTree(root.left, data) || findInBinaryTree(root.right, data);

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

    public static TreeNode arrayToBT(int[] nums) {
        TreeNode root = new TreeNode(-1);
        if (nums.length >= 1) {
            root = new TreeNode(nums[0]);
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        for (int i = 1; i < nums.length; ) {
            TreeNode temp = Q.remove();
            TreeNode leftNode = new TreeNode(nums[i]);
            temp.left = leftNode;
            Q.add(leftNode);
            i++;
            if (i < nums.length) {
                TreeNode rightNode = new TreeNode(nums[i]);
                temp.right = rightNode;
                Q.add(rightNode);
                i++;
            } else
                break;

        }
        return root;
    }

    public static TreeNode sortedArrayToBst(int[] nums) {
        if (nums.length == 0)
            return null;
        return sortedArrayToBstHelper(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBstHelper(int[] nums, int low, int hi) {

        if (low > hi) {
            return null;
        }
        int mid = low + (hi - low) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = sortedArrayToBstHelper(nums, low, mid - 1);
        temp.right = sortedArrayToBstHelper(nums, mid + 1, hi);
        return temp;
    }

    //Since the tree is not balanced we need to decide where to go - Left/Right
    public static int kthSmallest(TreeNode root, int k) {

        int count = countNode(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
        }

        return root.val;
    }

    public static int countNode(TreeNode node) {
        if (node == null)
            return 0;
        else
            return 1 + countNode(node.left) + countNode(node.right);

    }

    public static void InOrderIterative(TreeNode root, int k) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty() || k == 0) {
                    break;
                }
                root = stack.pop();
                k--;
                if (k == 0)
                    System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public static TreeNode LCABinaryTree(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null)
            return root;
        if (root == n1 || root == n2)
            return root;
        TreeNode left = LCABinaryTree(root.left, n1, n2);
        TreeNode right = LCABinaryTree(root.right, n1, n2);

        if (left != null && right != null)
            return root;
        else
            //both node are on the same side and one is the ancestor of the other
            return left != null ? left : right;
    }

    public static TreeNode LCABinarySearchTree(TreeNode root, int n1, int n2) {
        if (root == null)
            return root;

        if (root.val == n1 || root.val == n2)
            return root;
        if ((root.val < n1 && root.val > n2) || (root.val > n1 && root.val < n2))
            return root;

        if (root.val > n1 && root.val > n2) {
            return LCABinarySearchTree(root.left, n1, n2);
        } else {
            return LCABinarySearchTree(root.right, n1, n2);
        }
    }

    public static List<Integer> createList(List<Integer> tempList, int pathlen) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < pathlen; ++i) {
            list1.add(tempList.get(i));
        }
        return list1;
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<Integer> tempList = new ArrayList<>();
        printPathSum(root, sum, result, tempList, 0);
        return result;
    }

    public static void printPathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tempList, int pathlen) {


        if (root == null) {
            return;
        }
        tempList.add(root.val);
        pathlen++;
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(createList(tempList, pathlen));
        }

        sum -= root.val;

        printPathSum(root.left, sum, result, tempList, pathlen);
        printPathSum(root.right, sum, result, tempList, pathlen);
    }

    public static void flatten(TreeNode root) {

        if (root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;

        TreeNode cur = root;
        while (cur.right != null)
            cur = cur.right;
        cur.right = right;
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> answer = new ArrayList<>();
        binaryTreePathsHelper(root, "", answer);
        return answer;
    }

    public static void binaryTreePathsHelper(TreeNode root, String path, List<String> answer) {

        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
        }
        if (root.left != null)
            binaryTreePathsHelper(root.left, path + root.val+"->", answer);
        if (root.right != null)
            binaryTreePathsHelper(root.right, path +  root.val+"->" , answer);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;

        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }

    public int sumNumbers(TreeNode root) {

        int value = 0;
        return sumNumberHelper(root, value);
    }

    public int sumNumberHelper(TreeNode root, int value) {

        if (root == null)
            return 0;
        int sum = value * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        else
            return sumNumberHelper(root.left, sum) + sumNumberHelper(root.right, sum);

    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {

        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        else
            return isSymmetricHelper(left.left, right.left) && isSymmetricHelper(left.right, right.left);

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return sum == root.val;
        else {
            sum -= root.val;
            return hasPathSum(root.left, sum) && hasPathSum(root.right, sum);
        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(22);
        TreeNode n8 = new TreeNode(80);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        //   TreeNode temp = sortedArrayToBst(new int[]{1, 2, 3, 4, 5, 6});
        BTreePrinter.printNode(n1);
        System.out.println(binaryTreePaths(n1));

    }

}
