package dynamic;

import java.util.HashMap;

public class ExpressionEval {
    public static void main(String[] args) {
        String expression = "0&0&0&1^1|0";
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(countExpression(expression, true, map));
    }

    private static int countExpression(String expression, boolean result, HashMap<String, Integer> map) {


        if (expression.equals("")) {
            return 0;
        }

        if (expression.length() == 1) {
            boolean booleanValue = expression.charAt(0) == '1' ? true : false;
            return booleanValue == result ? 1 : 0;
        }
        if (map.containsKey(result + expression)) {
            return map.get(result + expression);
        }

        int noOfWays = 0;
        for (int i = 1; i < expression.length(); i += 2) {
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1, expression.length());
            int leftTrue = countExpression(left, true, map);
            int leftFalse = countExpression(left, false, map);
            int rightTrue = countExpression(right, true, map);
            int rightFalse = countExpression(right, false, map);
            int totalCount = (leftFalse + leftTrue) * (rightFalse + rightTrue);

            int totalTrue = 0;
            Character c = expression.charAt(i);
            if (c == '^') {
                totalTrue = (leftTrue * rightFalse) + (leftFalse * rightTrue);
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = (rightTrue * leftFalse) + (rightTrue * leftTrue) + (leftTrue * rightFalse);
            }
            int ways = result ? totalTrue : totalCount - totalTrue;
            noOfWays += ways;
        }
        map.put(result + expression, noOfWays);
        return noOfWays;

    }
}
