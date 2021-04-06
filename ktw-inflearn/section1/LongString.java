/**
 * Created by Young on 2021-04-06.
 */

package section1;

public class LongString {
    public static void main(String[] args){

        LongString fs = new LongString();

        String str = "it is time to study";

        String result = fs.solution(str);

        System.out.println("result = " + result);

    }

    private String solution(String str) {
        String answer = "";

        String[] strArr = str.split(" ");

        int max = 0;
        for(String s : strArr){
            int l = s.length();

            if (max < l) {
                max = l;
                answer = s;
            }
        }

        return answer;
    }
}
