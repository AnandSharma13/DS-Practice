package LinkedList;

/**
 * Created by Anand on 1/31/2016.
 */
public class KarumanchiLinkedList {

    public static void nthNode(ListNode head, int nth) {

        if (head == null)
            return;
        ListNode slowPtr = head;
        ListNode nthNodePtr = head;

        for (int i = 0; i < nth; i++) {
            if (nthNodePtr.next != null)
                nthNodePtr = nthNodePtr.next;
            else
                return;
        }
        while (nthNodePtr != null) {
            slowPtr = slowPtr.next;
            nthNodePtr = nthNodePtr.next;
        }
        System.out.println(slowPtr.val);

    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
       LinkedListPrinter.printLinkedList(n1);
        nthNode(n1,2);




    }

}
