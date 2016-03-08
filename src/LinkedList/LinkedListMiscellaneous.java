package LinkedList;

/**
 * Created by Anand on 2/13/2016.
 */
public class LinkedListMiscellaneous {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode newHead;
        if (l1.val <= l2.val) {
            newHead = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            newHead = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return newHead;
    }

    public static ListNode[] partitionArray(ListNode[] original, int start, int end) {

        ListNode[] result = new ListNode[end - start];

        int j = 0;
        for (int i = start; i < end; i++) {
            result[j] = original[i];
            j++;
        }

        return result;
    }

    public static ListNode reverseLinkedListPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;
        newHead.next.next = reverseLinkedListPairs(newHead.next.next);
        return newHead;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0)
            return null;
        if (length == 1)
            return lists[0];
        if (length == 2)
            return mergeTwoLists(lists[0], lists[1]);


        return mergeTwoLists(mergeKLists(partitionArray(lists, 0, length / 2)), mergeKLists(partitionArray(lists, length / 2, length)));
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(15);


        n1.next = n2;
        n2.next = n3;


        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(19);
        ListNode a5 = new ListNode(1);


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        //    LinkedListPrinter.printLinkedList(n1);
        LinkedListPrinter.printLinkedList(a1);
        LinkedListPrinter.printLinkedList(reverseLinkedListPairs(a1));
    }




}
