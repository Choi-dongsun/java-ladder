package ladder.domain;

import ladder.view.InputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LadderGame {
    private ArrayList<LadderLine> ladders;
    private ArrayList<User> users;
    private List<String> resultOfGame;

    public LadderGame(ArrayList<User> users) {
        this.users = users;
    }

    public void readyGame(List<String> nameOfPlayer) {
        for (int i = 0; i < nameOfPlayer.size(); i++) {
            users.add(new User(nameOfPlayer.get(i), i));
        }
    }

    public void runGame(InputView input){
        List<String> nameOfPlayer = input.inputNameOfPlayer();
        resultOfGame = input.inputResult();
        readyGame(nameOfPlayer);

        this.ladders = makeLadders(input.inputNumOfLadder());
        for(LadderLine ladder : ladders){
            makeLines(nameOfPlayer.size(), ladder);
        }

        for(User user : users) {
            user.move(ladders);
            user.linkResult(resultOfGame);
        }
        makeResultDic();
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

    public HashMap<String, String> makeResultDic() {
        User.resultDic = new HashMap<>();
        for (User user : users) {
            user.makeEachResultDic();
        }
        return User.resultDic;
    }

    public ArrayList<LadderLine> getLadders() {
        return ladders;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public List<String> getResultOfGame() {
        return resultOfGame;
    }

}
