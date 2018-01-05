package flipkart;

import java.util.Scanner;

/**
 * Beautiful odds
 **/
public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        int m = sc.nextInt();


        long solution = getSolution(n, input, m);
        System.out.println(solution);

    }

    private static long getSolution(int n, int[] input, int m) {
        long dp[] = new long[n + 1];
        long solution = 0;
        int start = 0;
        int prevOne = -1;
        int countOfOdds = 0;
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            long temp = solution;
            if (input[i] % 2 != 0) {
                if (prevOne == -1) {
                    prevOne = i;
                }
                countOfOdds++;
                if (countOfOdds == m) {
                    solution += (prevOne - start) + 1;

                } else if (countOfOdds > m) {
                    start = prevOne;
                    prevOne++;
                    countOfOdds--;
                    while (input[prevOne] % 2 == 0 && prevOne < i) {
                        prevOne++;
                    }
                    solution += prevOne - start;

                }
            } else {
                if (countOfOdds == m) {
                    solution += dp[i - 1];
                }
            }

            dp[i] = solution - temp;

        }
        return solution;
    }
}
