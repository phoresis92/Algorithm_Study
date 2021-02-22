package pushupman.C_Queue_Stack;

import java.util.Stack;

public class BaseballGame {

    private static final String Substract = "C";
    private static final String Double = "D";
    private static final String Plus = "+";

    public static void main(String[] args) {

        String[] input = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        int myResult = mySolve(input);

        System.out.println("myResult = " + myResult);

    }

    public static int mySolve(String[] input){

        Stack<Integer> stack = new Stack<>();

        for (String s : input) {
            switch (s) {
                case Substract:
                    stack.pop();
                    break;

                case Double:
                    Integer peek = stack.peek();
                    stack.add(peek * 2);
                    break;

                case Plus:
                    Integer lastOne = stack.pop();
                    Integer secondOne = stack.peek();

                    stack.add(lastOne);
                    stack.add(lastOne + secondOne);
                    break;

                default:
                    stack.add(Integer.parseInt(s));
            }
        }

        int result = 0;
        for (Integer integer : stack) {
            result += integer;
        }

        return result;

    }

}
