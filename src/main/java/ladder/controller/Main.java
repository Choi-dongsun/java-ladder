package ladder.controller;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LadderGame ladder = new LadderGame(new ArrayList<>());
        ladder.runGame(InputView.inputNameOfPlayer(), InputView.inputResult(), InputView.inputNumOfLadder());
        ResultView.printResult(ladder);
    }
}