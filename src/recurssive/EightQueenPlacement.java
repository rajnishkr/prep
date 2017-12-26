package recurssive;

import java.util.ArrayList;

public class EightQueenPlacement {
    public static void main(String[] args) {


        int N = 8;
        ArrayList<ArrayList<Integer>> queenPlacements = new ArrayList<>();
        ArrayList<Integer> currentSol = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            currentSol.add(-1);
        }

        placeQueen(queenPlacements, currentSol, 0);
        System.out.println(queenPlacements);
        System.out.println(queenPlacements.size());
    }

    private static void placeQueen(ArrayList<ArrayList<Integer>> queenPlacements, ArrayList<Integer> currentSol, int row) {
        if (row == 8) { // Found valid placement
            queenPlacements.add(new ArrayList<>(currentSol));
        } else {
            for (int i = 0; i < 8; i++) {
                if (valid(currentSol, row, i)) {
                    currentSol.set(row, i);
                    placeQueen(queenPlacements, currentSol, row + 1);

                }
            }
        }
    }

    private static boolean valid(ArrayList<Integer> currentSol, int row, int col) {

        for(int i=0;i<row;i++){
            if(currentSol.get(i)==col){
                return false;
            }

            if((row-i) == Math.abs(col-currentSol.get(i))){
                return false;
            }
        }
        return true;
    }


}
