package pushupman.section1;

import java.util.HashSet;

/**
 * @author : kyd
 * @created : 2020-12-11
 **/

public class JandS {

    public static void main(String[] args) {

        String j = "aA";
        String s = "aAAbbBBcccCC";

        int result = solve(j, s);

        System.out.println("result = " + result);

    }

    private static int solve(String j, String s){

        char[] chars = j.toCharArray();

        HashSet<Character> jSet = new HashSet<>();

        for (char jChar : chars) {
            jSet.add(jChar);
        }

        int result = 0;
        for (char sChar : s.toCharArray()) {
            if (jSet.contains(sChar)) {
                result++;
            }
        }

        return result;

    }

}
