package ladder.controller;

import ladder.model.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        LadderGame ladder = new LadderGame();
        ladder.runGame(InputView.inputNumOfPlayer(), InputView.inputNumOfLadder());
        ResultView.printResult(ladder.ladders);
    }
}
