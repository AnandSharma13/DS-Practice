package LinkedList;

/**
 * Created by Anand on 1/31/2016.
 */
public class LinkedListPrinter {

    public static void printLinkedList(ListNode head) {

        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + " --> ");
            } else {
                System.out.print(head.val);
            }
            head = head.next;
        }
        System.out.println();
    }
}
