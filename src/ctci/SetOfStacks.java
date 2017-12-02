package ctci;

import java.util.Random;
import java.util.Stack;

class Stacks {
    private Stack<Stack<Integer>> setOfStack;
    private Integer stackSize;

    Stacks(int limit) {
        this.setOfStack = new Stack<>();
        this.stackSize = limit;
    }

    public boolean push(int value) {
        if (setOfStack.empty() || setOfStack.peek().size() == stackSize) {
            setOfStack.push(new Stack<Integer>());
        }
        setOfStack.peek().push(value);
        System.out.println("pushed element: "+value);
        return true;
    }
    //TODO issues
    public int pop()  {
        if (setOfStack.peek().size() == 0) {
            setOfStack.pop();
        }
        if (setOfStack.empty()) {
            try {
                throw new StackEmptyException("Stack Empty");
            } catch (StackEmptyException e) {
                e.printStackTrace();
            }
        }
        return setOfStack.peek().pop();
    }
}

public class SetOfStacks{
    public static void main(String[] args) {
        int limit = 5;
        Stacks stacks= new Stacks(limit);
        Random rn = new Random();
        for (int i=0;i<12;i++){
            stacks.push(rn.nextInt(1000));
        }
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());

    }
}
