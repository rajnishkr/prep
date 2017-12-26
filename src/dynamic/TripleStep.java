package dynamic;

public class TripleStep {

    public static void main(String[] args) {

        /**lengthOfStairs**
         * part of the input
         */
        int lengthOfStairs = 4;
        System.out.println("numberOfWaysHeCanClimb: " + numberOfWaysHeCanClimb(lengthOfStairs));
    }

    private static int numberOfWaysHeCanClimb(int lengthOfStairs) {
        if (lengthOfStairs < 0) {
            return 0;
        }
        if (lengthOfStairs == 1) {
            return 1;
        }
        int[] steps = new int[lengthOfStairs + 1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;

        for (int i = 3; i < lengthOfStairs + 1; i++) {
            steps[i] = steps[i - 1] + steps[i - 2] + steps[i -3];
        }

        return steps[lengthOfStairs];
    }

}
