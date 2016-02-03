package StackQueues;

import java.util.Stack;

/**
 * Created by Anand on 2/1/2016.
 */
public class MinStack {

    Stack<Integer> myStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min;

    public void push(int x) {
        myStack.push(x);
        if(!minStack.isEmpty() && minStack.peek()>=x){
            minStack.push(x);
        }
        else{
            minStack.push(x);
        }
    }

    public void pop() {
        int top = myStack.pop();
        if(top == minStack.peek())
            minStack.pop();
        System.out.println("Value popped is "+top);
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}
