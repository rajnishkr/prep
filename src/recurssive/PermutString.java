package recurssive;

import java.util.ArrayList;

public class PermutString {

    public static void main(String[] args) {
        String input = "abcd";
        ArrayList<String> prems = getPerms(input.length(), input);

        System.out.println(prems);

    }

    public static ArrayList<String> getPerms(int n, String input) {

        ArrayList<String> allPerms = new ArrayList<>();

        if (n == 0) {
            allPerms.add("");
            return allPerms;
        }

        for (int i = 0; i < n; i++) {

            ArrayList<String> parts = getPerms(n - 1, input.substring(0, i) + input.substring(i + 1, n));
            for (String part : parts) {
                allPerms.add(input.charAt(i) + part);

            }

        }
        return allPerms;

    }
}