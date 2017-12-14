package graph;

public class CreateBalanceTree {
    public static void main(String[] args) {

        int inputTree[] = new int[20];

        for (int i = 1; i < 20; i++) {
            inputTree[i] = i;
        }

        TreeNode head = constructTree(inputTree, 0, 19);
        traverse(head);
        System.out.println(heightOfTree(head));


        TreeNode treeNode = new TreeNode(100);
        treeNode.setRight(new TreeNode(200));
        head.setRight(treeNode);
        Response response = checkTreeBalance(head);
        System.out.println(response.isBalanced());
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

    public static int heightOfTree(TreeNode node) {

        if (node == null) {
            return 0;
        }
        return Math.max(heightOfTree(node.getRight()), heightOfTree(node.getLeft())) + 1;
    }

    public static Response checkTreeBalance(TreeNode treeNode) {
        if (treeNode == null) {
            return new Response(0, true);
        }

        Response left = checkTreeBalance(treeNode.getLeft());
        Response right = checkTreeBalance(treeNode.getRight());
        int heightDiff = left.getHeight() - right.getHeight();
        Response current = new Response(Math.max(left.getHeight(), right.getHeight()) + 1, true);
        if (Math.abs(heightDiff) <= 1 && left.isBalanced() && right.isBalanced()) {
            return current;
        }
        current.setBalanced(false);
        return current;


    }

}

class Response {
    private boolean isBalanced;
    private int height;

    Response(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }

    public boolean isBalanced() {
        return isBalanced;
    }

    public int getHeight() {
        return height;
    }

    public void setBalanced(boolean balanced) {
        isBalanced = balanced;
    }
}
