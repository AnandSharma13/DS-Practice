package Trees;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anand on 1/24/2016.
 */
public class TreeTraversals {

    public static void PostOrder(TreeNode root){
        if (root == null)
            return;
        else {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.val+ " ");
        }
    }

    public static void InOrder(TreeNode root){
        if (root == null)
            return;
        else {
            InOrder(root.left);
            System.out.print (root.val + " ");
            InOrder(root.right);
        }
    }

    public static void PreOrder(TreeNode root){
        if(root == null)
            return;
        else{
            System.out.print (root.val + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public static void LevelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()){
            TreeNode node = Q.remove();
            System.out.println(node.val);
            if (node.left!=null)
                Q.add(node.left);
            if (node.right!=null)
                Q.add(node.right);
        }
    }

    public static void main(String [] args){

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

        PreOrder(n1);
        System.out.println();
        InOrder(n1);
        System.out.println();
        PostOrder(n1);
        System.out.println();
        LevelOrder(n1);

    }
}
