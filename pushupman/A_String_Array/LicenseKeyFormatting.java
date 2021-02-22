package pushupman.A_String_Array;

public class LicenseKeyFormatting {

    public static void main(String[] args) {

        String str1 = "8F3Z-2e-9-w";
        String str2 = "8-5g-3J";
        String str3 = "8F3Z-2e-9-wabcdef";
        /**
         * Output :
         *  8F3Z-2E9W
         *  8-5G3J
         * */

        int k = 4;

        String s1 = solve(str1, k);
        String s2 = solve(str2, k);
        String s3 = solve(str3, k);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);

    }

    private static String solve(String str, int k) {

        // 대시 제거
        String removeDash = str.replaceAll("-", "");

        // 대문자 변경
        String upperCase = removeDash.toUpperCase();

        StringBuilder sb = new StringBuilder();

        sb.append(upperCase);

        // 뒤에서 4번째 - 대시 추가
        for (int i = k; i < upperCase.length(); i+=k) {

            sb.insert(upperCase.length() - i, "-");

        }

        return sb.toString();

    }

}
