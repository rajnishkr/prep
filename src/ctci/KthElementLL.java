package ctci;

class LinkedListNode {
    int value;
    LinkedListNode next;

    LinkedListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public static LinkedListNode createARandomLinkList(int n) {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode iterator = head;
        for (int i = 0; i < n - 1; i++) {
            iterator.next = new LinkedListNode(i * Double.valueOf(Math.random() * 100).intValue());
            iterator = iterator.next;
        }
        return head;
    }

    public static LinkedListNode createARandomLinkListWithMod(int n, int base) {
        LinkedListNode head = new LinkedListNode(Double.valueOf(Math.random() * 100).intValue() % base);
        LinkedListNode iterator = head;
        for (int i = 0; i < n - 1; i++) {
            iterator.next = new LinkedListNode((i * Double.valueOf(Math.random() * 100).intValue()) % base);
            iterator = iterator.next;
        }
        return head;
    }


    public static void displayLL(LinkedListNode iterator, String message) {
        System.out.println(message);
        while (iterator != null) {
            System.out.print(iterator.value + " ");
            iterator = iterator.next;
        }
        System.out.println();

    }

    public static void displayReverseLL(LinkedListNode iterator) {
        if (iterator == null) {
            return;
        }
        displayReverseLL(iterator.next);
        System.out.print(iterator.value + " ");


    }
}

public class KthElementLL {
    public static void main(String[] args) {
        LinkedListNode head = LinkedListNode.createARandomLinkList(10);
        LinkedListNode iterator = head;
        LinkedListNode.displayLL(iterator, "newList");
        int K = 5;
        iterator = head;
        getKthBYPrint(iterator, 3);
        iterator = head;
        getKthBYPrint(iterator, 1);
        iterator = head;


    }

    private static int getKthBYPrint(LinkedListNode input, int K) {
        if (input == null) {
            return 0;
        }
        int current = getKthBYPrint(input.next, K) + 1;
        if (current == K) {
            System.out.println(input.value);
        }
        return current;

    }
}
