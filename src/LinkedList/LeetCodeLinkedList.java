package LinkedList;

/**
 * Created by Anand on 1/31/2016.
 */
public class LeetCodeLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public static boolean cycleDetection(ListNode head) {

        if (head == null) {
            System.out.println("loop doesn't exist");
            return false;
        }
        boolean isLoop = false;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                System.out.println("Loop Exists");
                isLoop = true;
                break;
            }
        }
        if (isLoop) {
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            System.out.println("Loop starting node is " + slowPtr.val);
            return isLoop;
        }

        return isLoop;

    }

    public static ListNode reverseLinkedListPairs(ListNode head) {

        if(head == null ||head.next==null)
            return head;
       ListNode newHead = head.next;
        while (head!=null){
            ListNode newTail = head.next.next;
            head.next.next =null;
            ListNode temp = reverseLinkedListPairsUtils(head);
            temp.next = newTail;
            head = newTail;
        }
        return newHead;

    }

    public static ListNode reverseLinkedListPairsUtils(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        reverseLinkedListPairsUtils(head.next);
        head.next.next = head;
        head.next = null;
        return head;
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

        LinkedListPrinter.printLinkedList(n1);
        LinkedListPrinter.printLinkedList(reverseLinkedListPairs(n1));

    }


}
