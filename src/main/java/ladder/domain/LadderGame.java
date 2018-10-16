package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LadderGame {
    private ArrayList<LadderLine> ladders;
    private ArrayList<User> users;
    private List<String> resultOfGame;
    private HashMap<String, String> resultDic;

    public LadderGame(ArrayList<User> users) {
        this.users = users;
    }

    public void readyGame(List<String> nameOfPlayer) {
        for (int i = 0; i < nameOfPlayer.size(); i++) {
            users.add(new User(nameOfPlayer.get(i), i));
        }
    }

    public void runGame(List<String> nameOfPlayer, List<String> resultOfGames, int numOfLadder){
        readyGame(nameOfPlayer);
        resultOfGame = resultOfGames;
        resultDic = new HashMap<>();

        this.ladders = makeLadders(numOfLadder);
        for(LadderLine ladder : ladders){
            makeLines(nameOfPlayer.size(), ladder);
        }

        for(User user : users) {
            user.move(ladders);
            user.linkResult(resultOfGame);
            resultDic.put(user.getName(), user.getResult());
        }
    }

    private static ArrayList<LadderLine> makeLadders(int numOfLadder){
        ArrayList<LadderLine> ladders = new ArrayList<>();
        for(int i = 0; i < numOfLadder; i++){
            ladders.add(new LadderLine(new ArrayList<>()));
        }
        return ladders;
    }

    private static void makeLines(int numOfPlayer, LadderLine ladder){
        for(int i = 0; i < numOfPlayer - 1; i++){
            ladder.makeHorizontalLine();
        }
    }

    public ArrayList<LadderLine> getLadders() {
        return this.ladders;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public List<String> getResultOfGame() {
        return this.resultOfGame;
    }

    public HashMap<String, String> getResultDic() {
        return this.resultDic;
    }

}
