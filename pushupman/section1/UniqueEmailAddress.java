package pushupman.section1;

import java.util.HashSet;

public class UniqueEmailAddress {

    public static void main(String[] args) {

        String[] input = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"
        };

        String[] output = solve(input);

        for (String s : output) {
            System.out.println("s = " + s);
        }

    }

    private static String[] solve(String[] input) {

        HashSet<String> resultSet = new HashSet<>();

        for (String email : input) {
            StringBuilder localName = makeLocalName(email);
            StringBuilder domainName = makeDomainName(email);

            resultSet.add(localName.append(domainName).toString());
        }


        String[] result = new String[resultSet.size()];
        int idx = 0;
        for (String email : resultSet) {
            result[idx++] = email;
        }

        return result;

    }

    private static StringBuilder makeLocalName(String email) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < email.length(); i++) {

            char charAt = email.charAt(i);

            if (charAt == '@') {
                break;
            }
            if (charAt == '+') {
                break;
            }
            if (charAt == '.') {
                continue;
            }

            sb.append(charAt);

        }

        return sb;

    }

    private static StringBuilder makeDomainName(String email) {
        StringBuilder sb = new StringBuilder();

        for (int i = email.indexOf('@'); i < email.length(); i++) {
            sb.append(email.charAt(i));
        }

        return sb;

    }


    private static String[] mySolve(String[] input) {

        HashSet<String> resultSet = new HashSet<>();

        for (String s : input) {

            StringBuilder sb = new StringBuilder();

            String[] split = s.split("@");

            String front = split[0];
            String back = split[1];

            front = front.substring(0, front.indexOf("+"));
            front = front.replaceAll("\\.", "");

            sb.append(front);
            sb.append("@");
            sb.append(back);

            resultSet.add(sb.toString());

        }

        String[] result = new String[resultSet.size()];
        int idx = 0;
        for (String s : resultSet) {
            result[idx++] = s;
        }

        return result;

    }

}
