package pushupman.B_LinkedList;

import java.util.Objects;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode list1 = getList1();
        ListNode list2 = getList2();

        ListNode solve = solve(list1, list2);

        System.out.println("solve = " + solve);

    }

    public static ListNode solve(ListNode l1, ListNode l2){

        ListNode newHead = new ListNode(0);

        ListNode p1 = l1 , p2 = l2, p3 = newHead;

        int carry = 0;

        while (Objects.nonNull(p1) || Objects.nonNull(p2)) {
            if (Objects.nonNull(p1)) {
                carry += p1.val;
                p1 = p1.next;
            }
            if (Objects.nonNull(p2)) {
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }

        if (carry == 1) {
            p3.next = new ListNode(1);
        }

        return newHead.next;

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

    private static ListNode getList1(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        return l1;
    }

    private static ListNode getList2(){
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        return l2;
    }
}
