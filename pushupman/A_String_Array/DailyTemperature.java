package pushupman.A_String_Array;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {

        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = solve(input);

        Arrays.stream(result)
                .forEach(System.out::println);

    }

    private static int[] solve(int[] input) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {

            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {

                Integer index = stack.pop();
                result[index] = i - index;

            }

            stack.push(i);

        }

        return result;

    }

    /*

        input = new int[]{75, 71, 69, 72, 76};

    * 75 :
    *   [ 0 ]
    * result = [0] [0] [0] [0] [0]
    *
    * 71 :
    *   [ 0, 1 ]
    * result = [0] [0] [0] [0] [0]
    *
    * 69 :
    *   [ 0, 1, 2 ]
    * result = [0] [0] [0] [0] [0]
    *
    * 72 :
    *   [ 0, 3 ]
    * result = [0] [2] [1] [0] [0]
    *
    * 76 :
    *   [ 4 ]
    * result = [4] [2] [1] [1] [0]
    * */

}
