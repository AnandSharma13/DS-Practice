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
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        while (head != null) {
            ListNode newTail = head.next.next;
            head.next.next = null;
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

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy.next, slowPtr = dummy.next;
        int len = 0;
        while (ptr.next != null) {
            ptr = ptr.next;
            len++;
        }
        for (int i = len - k % len; i > 0; i--) {
            slowPtr = slowPtr.next;
        }
        ptr.next = dummy.next;
        dummy.next = slowPtr.next;
        slowPtr.next = null;
        return dummy.next;
    }

    public static ListNode reverseKGroups(ListNode head, int k) {

        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previous = dummy;
        int count = 0;
        while (head != null) {
            count++;
            if (count % k == 0) {
                previous = reverse(previous, head.next);
                head = previous.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head1.next != null && head2.next != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 == null)
            tail.next = head2;
        if (head2 == null)
            tail.next = head1;

        return dummy.next;
    }

    public static ListNode mergeTwoListsRecursive(ListNode head1, ListNode head2) {

        ListNode newHead;
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.val < head2.val) {
            newHead = head1;
            newHead.next = mergeTwoListsRecursive(head1.next, head2);

        } else {
            newHead = head2;
            head2.next = mergeTwoListsRecursive(head1, head2.next);
        }
        return newHead;
    }

    public static ListNode reverse(ListNode dummyHead, ListNode endNode) {

        ListNode last = dummyHead.next;
        ListNode cur = last.next;

        while (cur != endNode) {
            last.next = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = last.next;
        }
        return last;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(7);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(6);
        ListNode a6 = new ListNode(7);


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        LinkedListPrinter.printLinkedList(n1);
        LinkedListPrinter.printLinkedList(mergeTwoListsRecursive(n1, a1));
    }


}
