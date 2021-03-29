package programmers.recommend.Hash;

import java.util.HashMap;

public class Marathon {

    public static void main(String[] args) {
        Marathon marathon = new Marathon();

        String[] participant = {"a", "b", "c", "d", "a"};
        String[] completion = {"a", "b", "c", "d"};

        String failPlayer = marathon.solve(participant, completion);

        System.out.println("failPlayer = " + failPlayer);

    }

    private String solve(String[] participant, String[] completion){

        HashMap<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            Integer cnt = map.get(player);
            if (cnt == null) {
                map.put(player, 1);
            } else {
                map.put(player, ++cnt);
            }
        }

        for (String cPlayer : completion) {
            Integer cnt = map.get(cPlayer);

            if (cnt == 1) {
                map.remove(cPlayer);
                continue;
            }

            map.put(cPlayer, --cnt);
        }

        return map.keySet().iterator().next();

    }

}
