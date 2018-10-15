package ladder.controller;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();
        LadderGame ladder = new LadderGame(new ArrayList<>());

        ladder.runGame(input);
        ResultView.printResult(ladder);
    }
}