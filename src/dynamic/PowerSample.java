package dynamic;

import java.util.ArrayList;

public class PowerSample {

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> input, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (input.size() == index) {
            System.out.println("once");
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(input, index + 1);
            int item = input.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
        System.out.println(subsets.toString());
    }


}
