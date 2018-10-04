package ladder.controller;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        LadderGame ladder = new LadderGame();
        ladder.runGame(InputView.inputNameOfPlayer(), InputView.inputNumOfLadder());
        ResultView.printResult(ladder);
    }
}