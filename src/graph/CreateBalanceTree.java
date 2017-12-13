package graph;

public class CreateBalanceTree {
    public static void main(String[] args) {

        int inputTree[] = new int[20];

        for (int i = 1; i < 20; i++) {
            inputTree[i] = i;
        }

        TreeNode head = constructTree(inputTree, 0, 19);
        traverse(head);
        System.out.println(hieghtOfTree(head));
    }

    private static TreeNode constructTree(int[] inputTree, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(inputTree[mid]);
        if (start == end) {
            return node;
        }

        node.setLeft(constructTree(inputTree, start, mid - 1));

        node.setRight(constructTree(inputTree, mid + 1, end));

        return node;
    }

    public static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.getLeft());

        System.out.print(node
                .getValue() + "  ");

        traverse(node.getRight());
    }

    public static int hieghtOfTree(TreeNode node) {

        if (node == null) {
            return 0;
        }
        return Math.max(hieghtOfTree(node.getRight()), hieghtOfTree(node.getLeft())) + 1;
    }

}
