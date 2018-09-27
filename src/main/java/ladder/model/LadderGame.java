package ladder.model;

import java.util.ArrayList;

public class LadderGame {

    public static ArrayList<LadderLine> ladders = new ArrayList<>();

    public static void runGame(int numOfPlayer, int numOfLadder){
        ladders = makeLadders(numOfLadder);
        for(LadderLine ladder : ladders){
            makeLines(numOfPlayer, ladder);
        }
    }

    private static ArrayList<LadderLine> makeLadders(int numOfLadder){
        ArrayList<LadderLine> ladders = new ArrayList<>();
        for(int i = 0; i < numOfLadder; i++){
            ladders.add(new LadderLine());
        }
        return ladders;
    }

    private static void makeLines(int numOfPlayer, LadderLine ladder){
        for(int i = 0; i < numOfPlayer - 1; i++){
            ladder.makeHorizontalLine();
        }
    }

}
