package pushupman.B_LinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode myResult = mySolve(getListNode(new int[]{1, 2, 3, 4}));
        ListNode pushupmanResult = pushupmanSolve(getListNode(new int[]{1, 2, 3, 4}));

        System.out.println("myResult = " + myResult);
        System.out.println("pushupmanResult = " + pushupmanResult);

    }

    public static ListNode mySolve(ListNode listNode){

        Stack<ListNode> stack = new Stack<>();

        ListNode p = listNode;
        while (Objects.nonNull(p)) {
            stack.push(p);
            p = p.next;
        }

        ListNode newHead = new ListNode(0);
        p = newHead;
        while (!stack.isEmpty()) {
            p.next = stack.pop();
            p = p.next;
        }
        p.next = null;

        return newHead;

    }

    public static ListNode pushupmanSolve(ListNode current){

        ListNode prev = null;
        ListNode next = null;

        while (Objects.nonNull(current)) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

    }

    private static ListNode getListNode(int[] intArr){
        ListNode head = new ListNode(0);
        ListNode pointer = head;

        List<ListNode> nodes = Arrays.stream(intArr)
                .mapToObj(ListNode::new)
                .collect(Collectors.toList());

        for (ListNode node : nodes) {
            pointer.next = node;
            pointer = pointer.next;
        }

        return head.next;
    }

    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
