package pushupman.section1;

public class MaxSubArray {

    public static void main(String[] args) {

        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = solve(input);

        System.out.println("result = " + result);

    }

    private static int solve(int[] input) {

        int newSum = input[0];
        int max = input[0];

        int idx = 1;

        while (idx < input.length) {

            newSum = Math.max(input[idx], newSum + input[idx]);

            max = Math.max(newSum, max);

            idx++;
        }

        return max;

    }


}
