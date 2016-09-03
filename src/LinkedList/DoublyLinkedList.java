package LinkedList;

/**
 * Created by Anand on 6/5/2016.
 */
public class DoublyLinkedList {
    DoublyListNode head;
    DoublyListNode tail;

    public DoublyLinkedList(DoublyListNode head, DoublyListNode tail) {
        this.head = head;
        this.tail = tail;
        head.next = tail;
        tail.pre = head;
    }

    public void addToHead(DoublyListNode node){
        node.next = head.next;
        node.pre = head;
        head.next = node;
        node.next.pre = node;
    }

    public void removeNode(DoublyListNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.pre = null;
        node.next = null;
    }
    public void removeLast(){
        DoublyListNode prev = tail.pre;
        this.removeNode(prev);
    }
    public void moveToHead(DoublyListNode node){
        this.removeNode(node);
        this.addToHead(node);
    }
}
