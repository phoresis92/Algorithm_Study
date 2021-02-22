package pushupman.A_String_Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2 {

    private static class Interval {
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;

        @Override
        public String toString() {
            return "start = " + start + " | end = " + end;
        }
    }

    public static void main(String[] args) {

//        List<Interval> intervals = Arrays.asList(
//                new Interval(5, 10),
//                new Interval(15, 20),
//                new Interval(0, 30)
//        );
        Interval[] intervals = {
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(10, 40),
                new Interval(15, 20),
        };


        long result = solve(intervals);

        System.out.println("result = " + result);

    }

    private static long solve(Interval[] input) {
        if (input == null || input.length == 0) return 0;

        // 1. 데이터 정리
        Arrays.sort(input, (a, b) -> a.start - b.start);
/*
            new Interval(0, 30),
            new Interval(5, 10),
            new Interval(10, 40),
            new Interval(15, 20),
*/

        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);

        int max = 0;

        // 2. 계산
        for (int i = 0; i < input.length; i++) {
            Interval current = input[i];

            System.out.println("current = " + current);

            while (!minHeap.isEmpty() && minHeap.peek().end <= current.start) {
                minHeap.poll(); // [5, 10]
            }

            minHeap.offer(current); // [0 30], [15, 20]
            max = Math.max(max, minHeap.size());

            System.out.println("minHeap = " + minHeap);


            System.out.println("========================================");
        }

        return max;

    }

}
