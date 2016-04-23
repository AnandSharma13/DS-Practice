package Trees;

/**
 * Created by Anand on 4/18/2016.
 */
public class RecoverBinarySearchTree {

    TreeNode firstNode;
    TreeNode secondNode;
    TreeNode prevElement;


    public void recoverTree(TreeNode root) {
        TreeInorder(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public void TreeInorder(TreeNode root) {
        if (root == null)
            return;
        TreeInorder(root.left);
        if (firstNode == null && prevElement.val > root.val)
            firstNode = root;
        if (secondNode == null & prevElement.val < root.val)
            secondNode = root.right;
        prevElement = root;
        TreeInorder(root.right);
    }
}
