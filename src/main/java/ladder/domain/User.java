package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private Integer position;
    private String result;

    public User(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    void move(ArrayList<LadderLine> ladders) {
        for (LadderLine ladder : ladders) {
            decideDirection(ladder);
        }
    }

    private void decideDirection(LadderLine ladder) {
        if (this.position == LadderLine.ZERO) {
            checkRightLine(ladder, LadderLine.ZERO);
            return;
        }
        if (this.position == ladder.getLines().size()) {
            checkLastElement(ladder, ladder.getLines().size());
            return;
        }
        checkMiddleElement(ladder);
    }

    private boolean checkRightLine(LadderLine ladder, int i) {
        if (ladder.getLines().get(i)) {
            this.position++;
            return true;
        }
        return false;
    }

    private boolean checkLeftLine(LadderLine ladder, int i) {
        if (ladder.getLines().get(i - LadderLine.ONE)) {
            this.position--;
            return true;
        }
        return false;
    }

    private void checkLastElement(LadderLine ladder, int i) {
        if (ladder.getLines().get(i - LadderLine.ONE)) {
            this.position--;
            return;
        }
    }

    private void checkMiddleElement(LadderLine ladder) {
        for (int i = 1; i < ladder.getLines().size(); i++) {
            if (checkMiddleElementDetail(ladder, i)) break;
        }
    }

    private boolean checkMiddleElementDetail(LadderLine ladder, int i) {
        if (this.position == i) {
            if (checkMiddleElementDirection(ladder, i)) return true;
        }
        return false;
    }

    private boolean checkMiddleElementDirection(LadderLine ladder, int i) {
        if (checkLeftLine(ladder, i)) {
            return true;
        }
        if (checkRightLine(ladder, i)) {
            return true;
        }
        return false;
    }

    void linkResult(List<String> resultOfGame) {
        for (int i = 0; i < resultOfGame.size(); i++) {
            checkLinkResult(resultOfGame, i);
        }
    }

    private void checkLinkResult(List<String> resultOfGame, int i) {
        if(this.position == i) {
            this.result = resultOfGame.get(i);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getResult() {
        return this.result;
    }
}