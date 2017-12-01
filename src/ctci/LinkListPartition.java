package ctci;

public class LinkListPartition {

    public static void main(String[] args) {
        LinkedListNode linkedListNode = LinkedListNode.createARandomLinkList(10);
        LinkedListNode.displayLL(linkedListNode, "new LinkList");
        LinkedListNode newPartitionList = partition(linkedListNode, Double.valueOf(Math.random() * 200).intValue());
        LinkedListNode.displayLL(newPartitionList, "partitioned List");
    }

    private static LinkedListNode partition(LinkedListNode linkedListNode, int K) {
        System.out.println("partition is "+K);
        if (linkedListNode == null) {
            return null;
        }
        LinkedListNode firstpart = null, firstpartHead = null;
        LinkedListNode secondPart = null, secondpartHead = null;

        while (linkedListNode != null) {
            LinkedListNode next = linkedListNode.next;
            if (linkedListNode.value < K) {
                if (firstpartHead == null) {
                    firstpart = linkedListNode;
                    firstpartHead = linkedListNode;
                } else {
                    firstpart.next = linkedListNode;
                    firstpart = firstpart.next;
                }
                firstpart.next = null;
            } else {
                if (secondpartHead == null) {
                    secondPart = linkedListNode;
                    secondpartHead = linkedListNode;
                } else {
                    secondPart.next = linkedListNode;
                    secondPart = secondPart.next;
                }
                secondPart.next = null;
            }
            linkedListNode = next;
        }
        firstpart.next = secondpartHead;
        return firstpartHead;
    }
}
