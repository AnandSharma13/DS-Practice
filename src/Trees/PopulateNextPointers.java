package Trees;

/**
 * Created by Anand on 4/17/2016.
 */
public class PopulateNextPointers {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode prev = root;
        TreeLinkNode curr;
        while (prev.left != null) {
            curr = prev;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            prev= prev.left;
        }
    }

    class TreeLinkNode {
        TreeLinkNode next;
        TreeLinkNode right;
        TreeLinkNode left;
    }


}
