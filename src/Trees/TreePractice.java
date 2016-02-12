package Trees;

import java.util.ArrayList;

/**
 * Created by Anand on 2/4/2016.
 */
public class TreePractice {


    public static void printRootLeaf(TreeNode root) {

        ArrayList<TreeNode> path = new ArrayList<>();
        printRootLeafUtils(root, path, 0);
    }

    public static void printRootLeafUtils(TreeNode root, ArrayList<TreeNode> mylist, int len) {

        if (root == null)
            return;

        else {
            mylist.add(len, root);
            len++;

            if (root.left == null && root.right == null)
                printArray(mylist, len);
            else {
                printRootLeafUtils(root.left, mylist, len);
                printRootLeafUtils(root.right, mylist, len);

            }
        }
    }

    public static void printArray(ArrayList<TreeNode> arr, int len) {
        for (int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i).val + " ");
        System.out.println();
    }


    public static void main(String[] args) {

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
        n4.right = n9;
        BTreePrinter.printNode(n1);
        printRootLeaf(n1);

    }
}
