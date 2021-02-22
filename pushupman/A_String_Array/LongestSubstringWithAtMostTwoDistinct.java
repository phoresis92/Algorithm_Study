package pushupman.A_String_Array;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinct {

    public static void main(String[] args) {

        String input = "ccaabbb";
//        String input = "ccccccaadddddddbbbeeeeeeaaaaa";
//        String input = "aaaabbbbaaaabbbaabbaabbaabb";
//        String input = "aabbaaabbbbbaa";

//        int result = mySolve(input);
        int result = solve(input);

        System.out.println("result = " + result);

    }

    private static int solve(String input) {

        int start = 0;
        int end = 0;
        int length = 0;
        int counter = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (end < input.length()) {

            char endChar = input.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            if(map.get(endChar) == 1) counter++;
            end++;

            while (counter > 2) {
                char startChar = input.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if(map.get(startChar) == 0) counter--;
                start++;
            }

            length = Math.max(length, end - start);

        }

        return length;

    }

    private static int mySolve(String input) {

        ArrayList<Integer> countList = new ArrayList<>();

        Character before = null;
        int countSum = 1;

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (before == null) {
                before = c;
                continue;
            }

            if (before == c) {
                countSum++;
            }else{
                countList.add(countSum);

                countSum = 1;
                before = c;
            }

        }

        countList.add(countSum);

        int tempCount = 0;
        int maxCount = 0;

        for (int count : countList) {

            if (tempCount == 0) {
                tempCount = count;
                continue;
            }

            if (maxCount == 0) {

                maxCount = tempCount + count;

            } else {

                int tempMax = tempCount + count;

                if (maxCount < tempMax) {
                    maxCount = tempMax;
                }

            }

            tempCount = count;

        }

        return maxCount;

    }

}
