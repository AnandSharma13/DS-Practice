package StackQueues;

import java.util.Stack;

/**
 * Created by Anand on 4/15/2016.
 */
public class SortReverseStack {

    public static void reverseStack(Stack<String> myStack){

        if(myStack.isEmpty())
            return;

        String str = myStack.pop();
        reverseStack(myStack);
        insertAtBottom(myStack, str);
    }

    /*
    *    1  2   3
    *
    *
    *
    *   str = 3
    *   reverse(1   2)
    *   str =   2
    *   reverse(1)
    *   str = 1
    *   reverse ()
    *
    *
    *
    * */


    public static void insertAtBottom(Stack<String> myStack, String str) {
        if (myStack.isEmpty()) {
            myStack.add(str);
            return;
        }
        String top = myStack.pop();
        insertAtBottom(myStack, str);
        myStack.push(top);
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.add("1");
        myStack.add("2");
        myStack.add("3");
        System.out.println(myStack);
        reverseStack(myStack);
        System.out.println(myStack);
    }
}
