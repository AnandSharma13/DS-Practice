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


    //3-->4-->5-->6-->8-->9
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

        System.out.println(len - k % len);
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

    public static ListNode deleteDups(ListNode l1) {

        if (l1 == null || l1.next == null)
            return l1;


        ListNode cur = l1;
        int preVal = cur.val;
        ListNode prevPtr = cur;
        cur = cur.next;
        while (cur != null) {
            if (cur.val == preVal) {
                prevPtr.next = cur.next;
                cur.next = null;
                cur = prevPtr.next;
            } else {
                prevPtr = cur;
                preVal = cur.val;
                cur = cur.next;
            }
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(2);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(7);


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        LinkedListPrinter.printLinkedList(a1);
        LinkedListPrinter.printLinkedList(rotateRight(a1,8));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return addTwoNumbers(l1, l2, 0);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {

        if (l1 == null && l2 == null)
            return null;

        int sum = 0;
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }
        sum += carry;
        if (sum >= 10)
            carry = 1;
        else
            carry = 0;

        ListNode node = new ListNode(sum % 10);
        node.next = addTwoNumbers(l1, l2, carry);

        return node;
    }


}
