package pushupman.A_String_Array;

import java.util.*;
import java.util.stream.Collectors;

public class KClosest {

    public static void main(String[] args) {

//        int[][] input = {{1,3}, {-2,2}};
//        int k = 1;
        int[][] input = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;

        int[][] output = solve(input, k);

        print(output);

    }

    private static void print(int[][] output) {
        Arrays.stream(output)
                .forEach(ints -> {
                    System.out.print("[");

                    String collect = Arrays.stream(ints)
                            .mapToObj(i -> ((Integer) i).toString())
                            .collect(Collectors.joining(","));
                    System.out.print(collect);

                    System.out.print("]");
                    System.out.println();
                });
    }

    private static int[][] solve(int[][] input, int k) {

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            double bLength = Math.pow(b[0], 2) + Math.pow(b[1], 2);
            double aLength = Math.pow(a[0], 2) + Math.pow(a[1], 2);

            return (int) (aLength - bLength);
        });

        Arrays.stream(input).forEach(queue::offer);

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;

    }


}
