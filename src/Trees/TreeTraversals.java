package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Anand on 1/24/2016.
 */
public class TreeTraversals {

    public static void PostOrder(TreeNode root) {
        if (root == null)
            return;
        else {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void InOrder(TreeNode root) {
        if (root == null)
            return;
        else {
            InOrder(root.left);
            System.out.print(root.val + " ");
            InOrder(root.right);
        }
    }

    public static void PreOrder(TreeNode root) {
        if (root == null)
            System.out.print("NULL");
        else {
            System.out.print(root.val + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }


    public static void LevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode node = Q.remove();
            System.out.println(node.val);
            if (node.left != null)
                Q.add(node.left);
            if (node.right != null)
                Q.add(node.right);
        }
    }

    public static void InOrderIterative(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty())
                    break;
                TreeNode node = stack.pop();
                System.out.println(node.val);
                root = node.right;
            }

        }
    }


    //TODO Go through this again and again.........................
    public static void postOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                if (root.right != null)
                    stack.push(root.right);
                stack.push(root);
                root = root.left;
            } else {

                if (!stack.isEmpty()) {
                    TreeNode r = stack.pop();
                    root = r;
                    if (root.right != null && !stack.isEmpty() && stack.peek() == root.right) {
                        TreeNode rt = stack.pop();
                        stack.push(r);
                        root = root.right;
                    } else {
                        System.out.println(root.val);
                        root = null;
                    }
                }
            }
            if (stack.isEmpty())
                break;
        }
    }


    public static void ZigZagTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> leftToRightStack = new Stack<>();
        Stack<TreeNode> rightToLeftStack = new Stack<>();
        //if flag is true, we go left to right
        boolean flag = true;
        rightToLeftStack.push(root);

        while (!rightToLeftStack.isEmpty() || !leftToRightStack.isEmpty()) {
            TreeNode temp;
            if (flag && !rightToLeftStack.isEmpty()) {
                temp = rightToLeftStack.pop();
                System.out.println(temp.val);
                if (temp.left != null)
                    leftToRightStack.push(temp.left);
                if (temp.left != null)
                    leftToRightStack.push(temp.right);
                if (rightToLeftStack.isEmpty())
                    flag = false;
            } else if (!flag && !leftToRightStack.isEmpty()) {
                temp = leftToRightStack.pop();
                System.out.println(temp.val);
                if (temp.right != null)
                    rightToLeftStack.push(temp.right);
                if (temp.left != null)
                    rightToLeftStack.push(temp.left);
                if (leftToRightStack.isEmpty())
                    flag = true;
            }

        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        BTreePrinter.printNode(n1);
        PreOrder(n1);

    }
}
