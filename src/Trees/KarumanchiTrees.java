package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anand on 1/27/2016.
 */
public class KarumanchiTrees {

    public static TreeNode insertNodeIntoTree(TreeNode root, TreeNode node){
        if (root ==null)
            return node;

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            TreeNode tempNode = Q.remove();
            if(tempNode.left!=null)
                Q.add(tempNode.left);
            else {
                tempNode.left = node;
                return root;
            }
            if(tempNode.right!=null)
                Q.add(tempNode.right);
            else {
                tempNode.right = node;
                return root;
            }
        }
        return root;
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
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        BTreePrinter.printNode(n1);
        TreeNode val = insertNodeIntoTree(n1,n8);
        System.out.println();
        BTreePrinter.printNode(val);


    }



}
