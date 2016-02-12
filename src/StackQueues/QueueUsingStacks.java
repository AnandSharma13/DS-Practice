package StackQueues;

import java.util.Stack;

/**
 * Created by Anand on 2/1/2016.
 */
public class QueueUsingStacks {

    Stack<Integer> poppingStack = new Stack<>();
    Stack<Integer> storingStack = new Stack<>();

    public static void main(String[] args) {
        QueueUsingStacks obj = new QueueUsingStacks();
        System.out.println(obj.empty());
        obj.push(5);
        obj.push(8);
        obj.push(2);
        obj.push(9);
        System.out.println(obj.empty());
        System.out.println(obj.peek());
        obj.pop();
        System.out.println(obj.peek());
    }

    public void push(int x) {
        storingStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!poppingStack.isEmpty()) {
            int element = poppingStack.pop();
            System.out.println("Element removed is " + element);
        } else {
            while (!storingStack.isEmpty()) {
                poppingStack.push(storingStack.pop());
            }
            if (!poppingStack.isEmpty()) {
                int element = poppingStack.pop();
                System.out.println("Element removed is " + element);
            }
        }
    }

    // Get the front element.
    public int peek() {
        if (!poppingStack.isEmpty())
            return poppingStack.peek();
        else {
            while (!storingStack.isEmpty()) {
                poppingStack.push(storingStack.pop());
            }
            int element = -1;
            if (!poppingStack.isEmpty()) {
                element = poppingStack.peek();
                System.out.println("Element on head is " + element);
            }
            return element;
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (poppingStack.isEmpty() && storingStack.isEmpty())
            return true;
        return false;

    }


}
