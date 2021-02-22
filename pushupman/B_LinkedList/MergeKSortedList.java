package pushupman.B_LinkedList;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MergeKSortedList {

    public static void main(String[] args) {

        ListNode l1 = getListNode(new int[]{1, 4, 5});
        ListNode l2 = getListNode(new int[]{1, 3, 4});
        ListNode l3 = getListNode(new int[]{2, 6});

        ListNode resultHead = solve(Arrays.asList(l1, l2, l3));

        System.out.println("resultHead = " + resultHead);

    }

    public static ListNode solve(List<ListNode> nodes){

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

        nodes
                .stream()
                .forEach(listNode -> {
                    ListNode pointer = listNode;
                    while (Objects.nonNull(pointer)) {
                        queue.add(pointer);
                        pointer = pointer.next;
                    }
                });
//        for (ListNode node : nodes) {
//            queue.offer(node);
//        }

        ListNode resultHead = new ListNode(0);
        ListNode pointer = resultHead;

        ListNode poll = queue.poll();
        while (Objects.nonNull(poll)) {
            pointer.next = poll;
            pointer = pointer.next;

            poll = queue.poll();
        }

        return resultHead.next;

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

    public static <T>Collector<T, ?, T> toGetOne(){
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.get(0)
        );
    }

    private static class ListNode {
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
