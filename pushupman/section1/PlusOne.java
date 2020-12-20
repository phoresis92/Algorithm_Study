package pushupman.section1;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {

//        int[] input = {1,2,3};
//        int[] input = {9,9,9};
        int[] input = {2,1,9,9,9};


        int[] output = solve(input);

        Arrays.stream(output)
                .forEach(System.out::println);

    }

    private static int[] solve(int[] digits) {

        int index = digits.length - 1;
        int carry = 1;

        while (index >= 0 && carry > 0) {

            digits[index] = (digits[index] + 1) % 10;

            if (digits[index] == 0) {
                carry = 1;
            } else {
                carry = 0;
            }

            index--;

        }

        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;

            return result;
        } else {
            return digits;
        }

    }

    private static int[] mySolve(int[] input) {

        boolean carry = true;
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = input.length - 1; i >= 0; i--) {

            int lastOne = input[i];

            if (carry) {

                PlusResult plusResult = plusOne(lastOne);

                carry = plusResult.carry;
                resultList.add(plusResult.num);

            } else {

                resultList.add(lastOne);

            }

        }

        if (carry) {
            resultList.add(1);
        }

        int[] result = new int[resultList.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = resultList.get(result.length - 1 - i);
        }

        return result;

    }

    private static PlusResult plusOne(int input){

        int result = input + 1;

        boolean carry = result >= 10;

//        resultList.add(result % 10);

        return new PlusResult(carry, result % 10);

    }

    static class PlusResult{

        public PlusResult(boolean carry, int num) {
            this.carry = carry;
            this.num = num;
        }

        boolean carry;
        int num;

    }

}
