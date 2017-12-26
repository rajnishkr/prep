package recurssive;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationWithRepition {


    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        String str = "aab";
        map.put('a', 2);
        map.put('b', 1);
        //map.put('c', 1);
        ArrayList<String> result = new ArrayList<>();
        getPerms(map, "", str.length(), result);
        System.out.println(result);

    }

    private static void getPerms(HashMap<Character, Integer> map, String prefix, int length, ArrayList<String> result) {

        if (length == 0) {
            result.add(prefix);
            return;
        }

        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                getPerms(map, prefix + c, length - 1, result);
                map.put(c, count);
            }

        }

    }

}
