package random;

import java.util.Scanner;

public class SpiralPrinting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Dimen of the array
        int N = sc.nextInt();

        int input[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        spiralDisplay(input, N);
    }

    static void spiralDisplay(int[][] input, int size) {
        int rs, re, cs, ce;
        rs = 0;
        cs = 0;
        re = size - 1;
        ce = size - 1;
        while (rs <= re && cs <= ce) {
            for (int i = cs; i <= ce; i++) {
                System.out.print(" "+input[rs][i]);
            }
            rs++;
            for (int i = rs; i <= re; i++) {
                System.out.print(" " + input[i][ce]);
            }
            ce--;

            for (int i = ce; i >= cs; i--) {
                System.out.print(" " + input[re][i]);
            }
            re--;
            for (int i = re; i >= rs; i--) {
                System.out.print(" " + input[i][cs]);
            }
            cs++;
        }

    }
}
