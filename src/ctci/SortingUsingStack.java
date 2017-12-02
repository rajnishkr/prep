package ctci;

import java.util.Random;
import java.util.Stack;

public class SortingUsingStack {

    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            inputStack.push(random.nextInt(100));
        }
        sortStack(inputStack);
        displayPopStack(inputStack);

    }

    private static void displayPopStack(Stack<Integer> inputStack) {
        while (!inputStack.isEmpty()) {
            System.out.println(inputStack.pop());
        }
    }

    private static void sortStack(Stack<Integer> inputStack) {
        Stack<Integer> temp = new Stack<>();
        while (!inputStack.isEmpty()) {

            int current = inputStack.pop();
            if (temp.isEmpty() || current >= temp.peek()) {
                temp.push(current);
            } else {
                while (!temp.isEmpty() && current < temp.peek()) {
                    inputStack.push(temp.pop());
                }
                temp.push(current);
            }
        }
        while (!temp.isEmpty()) {
            inputStack.push(temp.pop());
        }

    }
}
