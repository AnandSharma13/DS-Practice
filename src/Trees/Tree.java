package Trees;

/**
 * Created by Anand on 1/24/2016.
 */
public class Tree {

    TreeNode root;
    TreeNode n1;
    TreeNode n2;
    TreeNode n3;
    TreeNode n4;
    TreeNode n5;
    TreeNode n6;
    TreeNode n7;







    public Tree() {
        n1 = new TreeNode(3);
        n2 = new TreeNode(4);
        n3 = new TreeNode(5);
        n4 = new TreeNode(6);
        n5 = new TreeNode(7);
        n6 = new TreeNode(8);
        n7 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
    }
}
