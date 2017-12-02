package ctci;

public class SumTwoLinkList {
    public static void main(String[] args) {
        LinkedListNode linkedListNode1 = LinkedListNode.createARandomLinkListWithMod(7, 10);
        LinkedListNode linkedListNode2 = LinkedListNode.createARandomLinkListWithMod(5, 10);
        LinkedListNode itr = linkedListNode1;
        System.out.println("first LL");
        LinkedListNode.displayReverseLL(itr);
        itr = linkedListNode2;
        System.out.println("\n second LL");
        LinkedListNode.displayReverseLL(itr);
        System.out.println();
        //TODO assumption linklist represents number in reverse order
        LinkedListNode sumLinkList = getSum(linkedListNode1, linkedListNode2);
        System.out.println("\n sum LL");
        itr = sumLinkList;
        LinkedListNode.displayReverseLL(itr);

    }

    private static LinkedListNode getSum(LinkedListNode linkedListNode1, LinkedListNode linkedListNode2) {
        LinkedListNode sumLL = null, head = null;
        int carry = 0;
        while (linkedListNode1 != null || linkedListNode2 != null) {
            int sum = (linkedListNode1 != null ? linkedListNode1.value : 0) + (linkedListNode2 != null ? linkedListNode2.value : 0) + carry;
            if (head == null) {
                head = new LinkedListNode(sum % 10);
                head.next = null;
                sumLL = head;
            } else {
                sumLL.next = new LinkedListNode(sum % 10);
                sumLL = sumLL.next;
            }
            carry = sum / 10;
            if (linkedListNode1 != null)
                linkedListNode1 = linkedListNode1.next;
            if (linkedListNode2 != null)
                linkedListNode2 = linkedListNode2.next;
        }
        if (carry != 0) {
            sumLL.next = new LinkedListNode(carry);
        }
        return head;
    }

}
