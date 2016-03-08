package Trees;

import sun.reflect.generics.tree.Tree;

/**
 * Created by Anand on 2/4/2016.
 */
public class TreePractice {


    public static void FindInTree(TreeNode root, int val) {

        if (root == null)
            return;

        if (root.val == val) {
            System.out.println("Found");
        }
        FindInTree(root.left, val);
        FindInTree(root.right, val);
    }


    public static TreeNode arrayToBST(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        TreeNode node = arrayToBSTHelper(arr, 0, arr.length - 1);
        return node;
    }

    static TreeNode arrayToBSTHelper(int[] arr, int start, int end) {

        if(start>end)
            return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = arrayToBSTHelper(arr, start, mid -1);
        node.right = arrayToBSTHelper(arr, mid + 1, end);
        return node;
    }


    public static TreeNode findLCABT(TreeNode root, int n1, int n2){

        if(root == null)
            return null;
        if(root.val == n1 || root.val == n2){
            return root;
        }
        TreeNode left = findLCABT(root.left, n1, n2);
        TreeNode right = findLCABT(root.right, n1, n2);
        if(left!=null && right!=null){
            return root;
        }
        return left!=null?left:right;
    }



    public static TreeNode kthSmallestNode(TreeNode root, int k){

        int count = countNodes(root.left);

        if(k<=count){
            kthSmallestNode(root.left, k);
        }
        else if(k>count+1) {
            kthSmallestNode(root.right, k - count - 1);
        }
        return root;

    }

    public static int countNodes(TreeNode root){
        if(root ==null)
            return 0;

        int count = countNodes(root.left) + countNodes(root.right) + 1;
        return count;
    }



    public static void main(String[] args) {


        TreeNode root =  arrayToBST(new int[]{1,2,4,6,7,9,12});
        BTreePrinter.printNode(root);



        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(8);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(22);
        TreeNode n8 = new TreeNode(45);
        TreeNode n9 = new TreeNode(45);
        TreeNode n10 = new TreeNode(45);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;


        System.out.println(findLCABT(root, 7,12).val);



    }
}
