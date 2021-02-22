package pushupman.A_String_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {

        List<Interval> intervals = Arrays.asList(
                new Interval(15, 18),
                new Interval(1, 3),
                new Interval(8, 10),
                new Interval(2, 6)
        );

        List<Interval> result = solve(intervals);

        result.forEach(System.out::println);

    }

    static List<Interval> solve(List<Interval> input){

        List<Interval> result = new ArrayList<>();

        Collections.sort(input, (a, b) -> a.start - b.start);
/*
        new Interval(1, 3),
        new Interval(2, 6)
        new Interval(8, 10),
        new Interval(15, 18),
*/

        Interval before = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            Interval current = input.get(i);
            if (before.end >= current.start) {
                before.end = Math.max(before.end, current.end);
            } else {
                result.add(before);
                before = current;
            }
        }

//        if (before != null) {
        if (!result.contains(before)){
            result.add(before);
        }

        return result;

    }

    static class Interval {
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

}
