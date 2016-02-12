package StackQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anand on 2/1/2016.
 */
public class StackUsingQueues {

    Queue<Integer> Q1 = new LinkedList<>();
    Queue<Integer> Q2 = new LinkedList<>();

    public static void main(String[] args) {
        StackUsingQueues obj = new StackUsingQueues();
        System.out.println(obj.empty());
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(8);
        System.out.println(obj.empty());
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
    }

    public void push(int x) {
        if (Q1.isEmpty()) {
            Q1.add(x);
            while (!Q2.isEmpty()) {
                Q1.add(Q2.remove());
            }

        } else {
            Q2.add(x);
            while (!Q1.isEmpty()) {
                Q2.add(Q1.remove());
            }
        }
        System.out.println("Element pushed to stack");

    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!Q1.isEmpty()) {
            int el = Q1.remove();
            System.out.println("element popped " + el);
        } else if (!Q2.isEmpty()) {
            int el = Q2.remove();
            System.out.println("element popped is " + el);
        } else {
            System.out.println("Stack is empty");
        }

    }

    // Get the top element.
    public int top() {
        int el;
        if (!Q1.isEmpty()) {
            el = Q1.peek();
            System.out.println("element at top is " + el);
        } else if (!Q2.isEmpty()) {
            el = Q2.peek();
            System.out.println("element at top is " + el);
        } else {
            System.out.println("Stack is empty");
            el = -1;
        }
        return el;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if (Q1.isEmpty() && Q2.isEmpty())
            return true;
        return false;
    }
}
