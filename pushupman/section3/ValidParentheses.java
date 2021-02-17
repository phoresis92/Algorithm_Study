package pushupman.section3;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

//        String input = "{[]}";
//        String input = "([)]";
//        String input = "()[]{}";
//        String input = "(]";
        String input = "]]";

        boolean result = mySolve(input);

        System.out.println("result = " + result);

    }

    public static boolean mySolve(String input){

        HashMap<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        Stack<String> stack = new Stack<>();

        String[] split = input.split("");

        boolean isError = true;

        for (String s : split) {
            String open = map.get(s);

            if (Objects.isNull(open)) {
                // 여는 괄호
                if(isError) isError = false;
                stack.add(s);
                continue;
            }

            // 닫는 괄호
            if (!stack.isEmpty()) {
                String peek = stack.peek();
                if (peek.equals(open)) {
                    stack.pop();
                }
            }
        }

        if (isError) {
            return false;
        }

        return stack.isEmpty();

    }

    public static boolean pushupmanSolve(String input) {

        if (input.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            switch (c) {
                case ')':
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    break;

                case ']':
                    if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    break;

                case '}':
                    if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                    break;

                default:
                    stack.add(c);
            }
        }

        return stack.isEmpty();

    }

}
