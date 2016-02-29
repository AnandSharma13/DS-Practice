package Trees;

import java.util.Stack;

/**
 * Created by Anand on 2/29/2016.
 */
public class BSTIterator {

    Stack <TreeNode>myStack;


    public BSTIterator(TreeNode root) {

        TreeNode cur = root;
        myStack = new Stack();

        while (cur != null) {
            myStack.push(cur);
            cur = cur.left;
        }
    }

    public boolean hasNext(){
        return !myStack.isEmpty();
    }

    public int next(){
        TreeNode node = myStack.pop();
        TreeNode cur = node;
        if(cur.right!=null){
            myStack.push(cur.right);
            TreeNode mleft = cur.right.left;
            while(mleft !=null){
                myStack.push(mleft);
                mleft= mleft.left;
            }
        }

        return node.val;

    }
}