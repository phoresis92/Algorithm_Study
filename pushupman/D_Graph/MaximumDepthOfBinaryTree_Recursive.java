package pushupman.D_Graph;

import java.util.Objects;

public class MaximumDepthOfBinaryTree_Recursive {

    private static class BinaryTree{
        int val;

        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "BinaryTree{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(3);

        root.left = new BinaryTree(1);
        root.left = new BinaryTree(4);

        root.left.left = new BinaryTree(5);
        root.left.right = new BinaryTree(8);
        root.left.left.left = new BinaryTree(7);

        int max = mysolve(root);
        System.out.println("max = " + max);

        int solve = solve(root);
        System.out.println("solve = " + solve);

    }

    static int solve(BinaryTree root){
        if (Objects.isNull(root)) {
            return 0;
        }

        int leftMax = solve(root.left);
        int rightMax = solve(root.right);

        return Math.max(leftMax, rightMax) + 1;
    }

    static int mysolve(BinaryTree root){
        int max = 0;
        int depth = 0;
        if (Objects.isNull(root)) {
            return max;
        }

        max = recursive(root, max, depth);

        return max;
    }

    private static int recursive(BinaryTree node, int max, int depth) {
        depth += 1;
        max = Math.max(depth, max);


        if (Objects.nonNull(node.left)) {
            int leftMax = recursive(node.left, max, depth);
            max = Math.max(max, leftMax);

        }
        if (Objects.nonNull(node.right)) {
            int rightMax = recursive(node.right, max, depth);
            max = Math.max(max, rightMax);
        }

        return max;
    }

}
