package dynamic;


import java.util.*;
import java.lang.*;
import java.io.*;

class TipDistribution {
    public static void main(String[] args) {
        int testcases, N, X, Y;
        Scanner sc = new Scanner(System.in);
        testcases = sc.nextInt();
        while (testcases-- != 0) {
            N = sc.nextInt();
            X = sc.nextInt();
            Y = sc.nextInt();
            List<Integer> aTipsSheet = new ArrayList<Integer>();
            List<Integer> bTipsSheet = new ArrayList<Integer>();
            for (int i = 0; i < N; i++) {
                aTipsSheet.add(sc.nextInt());
            }
            for (int i = 0; i < N; i++) {
                bTipsSheet.add(sc.nextInt());
            }
            int[][][][] sol = new int[N+1][N+1][X+1][Y+1];
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    for (int k = 0; k <= X; k++) {
                        for (int l = 0; l <= Y; l++) {
                            sol[i][j][k][l] = -1;
                        }
                    }
                }
            }
            dfs(sol, 1, N, X, Y, aTipsSheet, bTipsSheet);


        }
    }


    static int dfs(int[][][][] sol, int start, int end, int X, int Y, List<Integer> aTipsSheet, List<Integer> bTipsSheet) {
        if(start==end){
            if(X>Y){
                  sol[start][end][X-1][Y]= aTipsSheet.get(start-1);
                return sol[start][end][X-1][Y];
            }else{
                sol[start][end][X][Y-1]= bTipsSheet.get(start-1);
                return sol[start][end][X][Y-1];
            }
        }
        if (start > end)
            return 0;
        if (sol[start][end][X][Y] != -1) {
            return sol[start][end][X][Y];
        }
        if (X > 0 && Y > 0) {
            sol[start + 1][end][X - 1][Y] = dfs(sol, start + 1, end, X - 1, Y, aTipsSheet, bTipsSheet);
            sol[start + 1][end][X][Y - 1] = dfs(sol, start + 1, end, X, Y - 1, aTipsSheet, bTipsSheet);
            sol[start][end][X][Y] = Math.max(aTipsSheet.get(start-1) + sol[start + 1][end][X - 1][Y], bTipsSheet.get(start) + sol[start + 1][end][X][Y - 1]);
            return sol[start][end][X][Y];

        } else if (X == 0) {
            sol[start + 1][end][0][Y - 1] = dfs(sol, start + 1, end, 0, Y - 1, aTipsSheet, bTipsSheet);
            sol[start][end][X][Y] = bTipsSheet.get(start-1) + sol[start + 1][end][0][Y - 1];
            return sol[start][end][X][Y];
        } else {
            sol[start + 1][end][X - 1][0] = dfs(sol, start + 1, end, X - 1, 0, aTipsSheet, bTipsSheet);
            sol[start][end][X][Y] = aTipsSheet.get(start-1) + sol[start + 1][end][X - 1][0];
            return sol[start][end][X][Y];

        }


    }
}
