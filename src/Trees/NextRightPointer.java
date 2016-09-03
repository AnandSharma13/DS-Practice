package Trees;

/**
 * Created by Anand on 5/20/2016.
 */
public class NextRightPointer {
    public static void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }


        public static void main(String[] args) {

            TreeLinkNode n1 = new TreeLinkNode(1);
            TreeLinkNode n2 = new TreeLinkNode(2);
            TreeLinkNode n3 = new TreeLinkNode(3);
            TreeLinkNode n4 = new TreeLinkNode(4);
            TreeLinkNode n5 = new TreeLinkNode(5);
            TreeLinkNode n6 = new TreeLinkNode(6);
            TreeLinkNode n7 = new TreeLinkNode(7);
            TreeLinkNode n8 = new TreeLinkNode(8);
            TreeLinkNode n9 = new TreeLinkNode(9);
            TreeLinkNode n10 = new TreeLinkNode(10);
            n1.left = n2;
            n1.right = n3;
            n2.left = n4;
            n2.right = n5;
            n3.left = n6;
            n3.right = n7;
            //BTreePrinter.printNode(n1);

            connect(n1);

        }
}

