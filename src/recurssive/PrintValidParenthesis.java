package recurssive;

import java.util.ArrayList;

public class PrintValidParenthesis {
    public static void main(String[] args) {
        int inputLen = 3;

        ArrayList<String> generatedStrings = new ArrayList<>();

        generateParenthesis(generatedStrings, inputLen, inputLen, "");

        System.out.println(generatedStrings);

    }

    private static void generateParenthesis(ArrayList<String> generatedStrings, int left, int right, String s) {

        if (left < 0 || right < left) {
            return;
        }
        if (left == 0 && right == 0) {
            generatedStrings.add(s);
            return;
        }
        generateParenthesis(generatedStrings, left - 1, right, s + '(');
        generateParenthesis(generatedStrings, left, right - 1, s + ')');

    }
}



