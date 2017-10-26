package arrays;

import java.util.ArrayList;
import java.util.List;

public class PossibilityMovingMaze {

    public static void main(String[] args) {
        List<Integer> input= new ArrayList<>();
        input.add(1);
        input.add(2);
        String direction="><";
        System.out.println(verify(input,direction));

        input.clear();
        input.add(2);
        input.add(1);
        input.add(1);
        direction=">><";
        System.out.println(verify(input,direction));
    }

    public static String verify(List<Integer> input, String direction){
        if(input.size()==0 || input.size()!=direction.length()){
            return "Invalid input";
        }
        int itr=0;
        while(itr>=0 && itr<direction.length()){
            int currentPos=itr;

            if(input.get(itr)<0){
                return "loop found";
            }
            if(direction.charAt(itr)=='>'){
                itr+=input.get(itr);
            }else if(direction.charAt(itr)=='<'){
                itr-=input.get(itr);
            }else{
                return "invalid input direction";
            }
            input.set(currentPos,-1*input.get(currentPos));
        }
        return "no loop";
    }
}