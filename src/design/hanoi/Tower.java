package design.hanoi;

import java.util.Stack;


public class Tower {

    private Stack<Integer> stack;

    Tower() {
        stack = new Stack<Integer>();
    }

    public void pushToTop(int d) {
        if (!stack.isEmpty() && stack.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            stack.push(d);
        }
    }

    public void moveDiskToTop(Tower t) {
        int top = stack.pop();
        t.pushToTop(top);
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            System.out.println("current \n" + this + "\n");
            System.out.println("buffer \n" + buffer + "\n");
            System.out.println("destination \n" + destination + "\n");
            moveDiskToTop(destination);
            System.out.println("current \n" + this + "\n");
            System.out.println("buffer \n" + buffer + "\n");
            System.out.println("destination \n" + destination + "\n");
            buffer.moveDisks(n - 1, destination, this);
            System.out.println("current \n" + this + "\n");
            System.out.println("buffer \n" + buffer + "\n");
            System.out.println("destination \n" + destination + "\n");
        }
    }

    @Override
    public String toString() {
        return "Tower{" +
                "stack=" + stack +
                '}';
    }
}