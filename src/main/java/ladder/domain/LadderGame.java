package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private ArrayList<LadderLine> ladders = new ArrayList<>();
    private ArrayList<User> user = new ArrayList<>();

    private void readyGame(List<String> nameOfPlayer) {
        for (String userName : nameOfPlayer) {
            user.add(new User(userName));
        }
    }

    public ArrayList<LadderLine> runGame(List<String> nameOfPlayer, int numOfLadder){
        ladders = makeLadders(numOfLadder);
        int numOfPlayer = nameOfPlayer.size();
        readyGame(nameOfPlayer);

        for(LadderLine ladder : ladders){
            makeLines(numOfPlayer, ladder);
        }
        return ladders;
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

    public ArrayList<LadderLine> getLadders() {
        return ladders;
    }

    public ArrayList<User> getUsers() {
        return user;
    }

}
