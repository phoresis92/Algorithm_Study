package pushupman.D_Graph;

import java.util.Objects;
import java.util.Stack;

public class MaximumDepthOfBinaryTree_DFS {

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
        root.right = new BinaryTree(4);

        root.left.left = new BinaryTree(5);
        root.left.right = new BinaryTree(8);
        root.left.left.left = new BinaryTree(7);

        int max = solve(root);
        System.out.println("max = " + max);

    }

    static int solve(BinaryTree root){
        int max = 0;

        Stack<BinaryTree> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        stack.push(root);
        depthStack.push(1);

        while (!stack.isEmpty()) {
            BinaryTree node = stack.pop();
            Integer depth = depthStack.pop();
            max = Math.max(max, depth);

            if (Objects.nonNull(node.left)) {
                stack.push(node.left);
                depthStack.push(depth + 1);
            }
            if (Objects.nonNull(node.right)) {
                stack.add(node.right);
                depthStack.push(depth + 1);
            }

        }

        return max;
    }

}
