package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anand on 1/27/2016.
 */
public class KarumanchiTrees {

    public static int treeHeight(TreeNode root) {
        return treeHeightHelper(root, 0);
    }

    public static int treeHeightHelper(TreeNode root, int max) {

        if (root == null)
            return 0;

        int leftHeight = treeHeightHelper(root.left, max) + 1;
        int rightHeight = treeHeightHelper(root.left, max) + 1;
        max = leftHeight > rightHeight ? leftHeight : rightHeight;
        return max;

    }

    public static TreeNode insertNodeIntoTree(TreeNode root, TreeNode node) {
        if (root == null)
            return node;

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode tempNode = Q.remove();
            if (tempNode.left != null)
                Q.add(tempNode.left);
            else {
                tempNode.left = node;
                return root;
            }
            if (tempNode.right != null)
                Q.add(tempNode.right);
            else {
                tempNode.right = node;
                return root;
            }
        }
        return root;
    }

    public static int findLeaves(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> Q = new LinkedList<>();
        int count = 0;
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode tempNode = Q.remove();
            if (tempNode.left == null && tempNode.right == null) {
                count++;
            }
            if (tempNode.left != null)
                Q.add(tempNode.left);
            if (tempNode.right != null)
                Q.add(tempNode.right);
        }
        return count;
    }

    public static int fullNodes(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> Q = new LinkedList<>();
        int count = 0;
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode temp = Q.remove();
            if (temp.left != null && temp.right != null)
                count++;
            if (temp.left != null) {
                Q.add(temp.left);
            }
            if (temp.right != null) {
                Q.add(temp.right);
            }
        }
        return count;
    }

    public static int halfNodes(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> Q = new LinkedList<>();
        int count = 0;
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode temp = Q.remove();
            if ((temp.left != null && temp.right == null) || (temp.left == null && temp.right != null)) {
                count++;
            }
            if (temp.left != null)
                Q.add(temp.left);
            if (temp.right != null)
                Q.add(temp.right);
        }
        return count;
    }

    public static boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        if (p.val == q.val) {
            return isSymmetric(p.left, q.left) && isSymmetric(p.right, q.right);
        } else
            return false;
    }

    public static int maxSumLevel(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> Q = new LinkedList<>();
        TreeNode identifierNode = new TreeNode(-1);
        int sum = 0;
        int maxSum = 0;
        int level = 1;
        int maxLevel = 1;
        Q.add(root);
        Q.add(identifierNode);
        while (!Q.isEmpty()) {
            TreeNode temp = Q.remove();
            if (temp == identifierNode) {
                if (sum > maxSum) {
                    maxSum = sum;
                    maxLevel = level;
                    sum = 0;

                }
                if (!Q.isEmpty()) {
                    Q.add(identifierNode);
                    level++;
                }
            } else {
                sum += temp.val;
                if (temp.left != null)
                    Q.add(temp.left);
                if (temp.right != null)
                    Q.add(temp.right);
            }
        }
        return level;
    }

    public static void printPaths(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        printPathsHelper(root, path, 0);
    }

    public static void printPathsHelper(TreeNode root, ArrayList<Integer> path, int pathLen) {
        if (root == null)
            return;
        path.add(pathLen, root.val);
        pathLen++;
        if (root.left == null && root.right == null) {
            printArray(path, pathLen);
        } else {
            printPathsHelper(root.left, path, pathLen);
            printPathsHelper(root.right, path, pathLen);
        }
    }

    public static void printArray(ArrayList<Integer> arr, int len) {
        for (int i = 0; i < len; i++)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }



    public static int nodesSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + nodesSum(root.left) + nodesSum(root.right);
    }

    public static TreeNode treeMirror(TreeNode root) {
        if (root == null)
            return root;
        else {
            TreeNode left = treeMirror(root.left);
            TreeNode right = treeMirror(root.right);
            root.left = right;
            root.right = left;
        }
        return root;
    }


    public static void printAncestorsNonRecursive(TreeNode root) {


    }

    public static void printNodeAncestorsRecursive(TreeNode root, TreeNode node) {
        printAncestorsHelper(root, node);
    }

    public static boolean printAncestorsHelper(TreeNode root, TreeNode node) {
        if (root == null)
            return false;
        if (root == node)
            return true;

        if (printAncestorsHelper(root.left, node) || printAncestorsHelper(root.right, node)) {
            System.out.println(root.val);
            return true;
        }
        return false;
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
        printAncestorsHelper(n1, n8);
    }


}
