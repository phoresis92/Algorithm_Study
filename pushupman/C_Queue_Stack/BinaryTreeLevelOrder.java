package pushupman.C_Queue_Stack;

import java.util.*;

public class BinaryTreeLevelOrder {

    private static final class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left =  new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);

        List<List<Integer>> result = solve(root);

        System.out.println("result = " + result);


        List<List<Integer>> mySolve = mySolve(root);

        System.out.println("mySolve = " + mySolve);

    }

    public static List<List<Integer>> mySolve(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();

        if (Objects.isNull(root)) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> step = new LinkedList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                step.add(node.val);

                TreeNode left = node.left;
                if (Objects.nonNull(left)) {
                    queue.offer(left);
                }

                TreeNode right = node.right;
                if (Objects.nonNull(right)) {
                    queue.offer(right);
                }
            }

            result.add(step);

        }

        return result;

    }


















    public static List<List<Integer>> solve(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if (Objects.isNull(root)) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> nodes = new LinkedList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodes.add(node.val);

                TreeNode left = node.left;
                if (Objects.nonNull(left)) {
                    queue.offer(left);
                }

                TreeNode right = node.right;
                if (Objects.nonNull(right)) {
                    queue.offer(right);
                }
            }

            result.add(nodes);
        }

        return result;
    }

}
