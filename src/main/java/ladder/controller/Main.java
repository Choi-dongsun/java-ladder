package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderLine;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LadderGame ladder = new LadderGame();
        ArrayList<LadderLine> ladders = ladder.runGame(InputView.inputNameOfPlayer(), InputView.inputNumOfLadder());
        ResultView.printResult(ladders, LadderGame.user);
    }
}