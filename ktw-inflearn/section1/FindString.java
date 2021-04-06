/**
 * Created by Young on 2021-04-06.
 */

package section1;

public class FindString {
    public static void main(String[] args){

        FindString fs = new FindString();

        String str = "aseflnasejfnksdrag";
        String target = "a";

        int result = fs.solution(str, target);

        System.out.println("result = " + result);

    }

    private int solution(String str, String target) {
        int answer = 0;

        String upperCase = str.toUpperCase();
        char[] chars = upperCase.toCharArray();

        char targetChar = target.toUpperCase().charAt(0);

        for (char c : chars) {
            if (c == targetChar) {
                answer++;
            }
        }

        return answer;
    }
}
