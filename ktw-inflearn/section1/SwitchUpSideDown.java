/**
 * Created by Young on 2021-04-06.
 */

package section1;

public class SwitchUpSideDown {
    public static void main (String args[]){

        SwitchUpSideDown s = new SwitchUpSideDown();

        String str = "sTuDy";

        String solution = s.solution(str);

        System.out.println("solution = " + solution);

    }

    private String solution(String str) {
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }

        return sb.toString();
    }

}
