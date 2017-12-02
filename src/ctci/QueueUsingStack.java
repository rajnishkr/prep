package ctci;

import java.util.Random;
import java.util.Stack;

class Queue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    private int QueueSize;

    Queue() {
        this.popStack = new Stack();
        this.pushStack = new Stack();
        this.QueueSize = 0;
    }

    public void push(int value) {
        pushStack.push(value);
        this.QueueSize++;
        System.out.println("pushed: " + value);
    }

    public int pop() {
        if (popStack.isEmpty() && pushStack.empty()) {
            //System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {


        Queue queue = new Queue();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            if (random.nextBoolean()) {
                queue.push(i);
            } else {
                int popValue=queue.pop();
                if(popValue==Integer.MIN_VALUE){
                    System.out.println("Queue is Empty Cannot complete the operation");
                }else{
                    System.out.println("popped value "+popValue);
                }
            }
        }
    }
}
