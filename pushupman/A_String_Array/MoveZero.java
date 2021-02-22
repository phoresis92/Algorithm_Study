
package pushupman.A_String_Array;

public class MoveZero {

    public static void main(String[] args) {
        int[] input = {0, 3, 2, 0, 8, 5};

        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                input[index++] = input[i];
            }
        }

        while (index < input.length) {
            input[index++] = 0;
        }

        for (int i : input) {
            System.out.println(i);
        }

    }

}
