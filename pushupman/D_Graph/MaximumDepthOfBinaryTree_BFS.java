package pushupman.D_Graph;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_BFS {

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

        int max = mySolve(root);
        System.out.println("max = " + max);

    }

    static int mySolve(BinaryTree root){
        int max = 0;
        if (Objects.isNull(root)) {
            return max;
        }

        Queue<BinaryTree> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree node = queue.poll();

                if (Objects.nonNull(node.left)) {
                    queue.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.offer(node.right);
                }
            }

            max++;
        }

        return max;
    }

}
