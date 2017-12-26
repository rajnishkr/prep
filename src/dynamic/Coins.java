package dynamic;

public class Coins {

    public static void main(String[] args) {
        int targetDeno = 10;
        int[] coinsType = {1, 5, 10, 25};
        System.out.println(getNumberOfWays(targetDeno, coinsType));
    }

    private static int getNumberOfWays(int targetDeno, int[] coinsType) {
        int[] result = new int[targetDeno + 1];

        result[0] = 1;


            for (int i = 0; i < coinsType.length; i++) {
                for (int j = coinsType[i]; j < targetDeno + 1; j++) {
                    result[j] += result[j - coinsType[i]];

            }

        }
        for (int i = 1; i < result.length; i++) {
            System.out.print(result[i] + " ");

        }
        System.out.println();
        return result[targetDeno];

    }
}
