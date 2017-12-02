package ctci;

public class RecurCheckPalin {

    public static class Result {
        public LinkedListNode node;
        public boolean result;

        public Result(LinkedListNode n, boolean res) {
            node = n;
            result = res;
        }
    }

    //Good recursive implementation
    public static Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length <= 0) { // Even number of nodes
            return new Result(head, true);
        } else if (length == 1) { // Odd number of nodes
            return new Result(head.next, true);
        }

		/* Recurse on sublist. */
        Result res = isPalindromeRecurse(head.next, length - 2);

		/* If child calls are not a palindrome, pass back up
         * a failure. */
        if (!res.result || res.node == null) {
            return res;
        }

		/* Check if matches corresponding node on other side. */
        res.result = (head.value == res.node.value);

		/* Return corresponding node. */
        res.node = res.node.next;

        return res;
    }

    public static int lengthOfList(LinkedListNode n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    public static boolean isPalindrome(LinkedListNode head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    public static void main(String[] args) {
        int length = 10;
        LinkedListNode[] nodes = new LinkedListNode[length + 1];
        for (int i = 0; i <= length / 2; i++) {
            nodes[i] = new LinkedListNode(i);
        }
        for (int i = length / 2; i >= 0; i--) {
            nodes[length - i] = new LinkedListNode(i);
        }
        for (int i = 0; i < length; i++) {
            nodes[i].next = nodes[i + 1];
        }
        //nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        LinkedListNode.displayLL(head, "content of LL");
        head = nodes[0];
        System.out.println(isPalindrome(head));

    }

}


