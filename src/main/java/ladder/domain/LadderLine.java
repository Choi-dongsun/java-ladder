package ladder.domain;

import ladder.util.RandomGenerator;
import java.util.ArrayList;

public class LadderLine {
    public static final int ZERO = 0;
    private static final int ONE = 1;
    private ArrayList<Boolean> lines;

    public LadderLine(ArrayList<Boolean> lines) {
        this.lines = lines;
    }

    void makeHorizontalLine() {
        this.lines.add(this.decideNextHorizontalLine());
    }

    boolean decideNextHorizontalLine() {
        if (lines.size() != ZERO) {
            return checkBeforeHorizontalLine();
        }
        return RandomGenerator.makeRandomValue();
    }

    boolean checkBeforeHorizontalLine() {
        if (lines.get(lines.size() - ONE)) {
            return false;
        }
        return RandomGenerator.makeRandomValue();
    }

    void decideDirection(User user) {
        if (user.getPosition() == ZERO) {
            checkRightLine(ZERO, user);
            return;
        }
        if (user.getPosition() == this.lines.size()) {
            checkLastElement(this.lines.size(), user);
            return;
        }
        checkMiddleElement(user);
    }

    private boolean checkRightLine(int i, User user) {
        if (this.lines.get(i)) {
            user.moveRight();
            return true;
        }
        return false;
    }

    private boolean checkLeftLine(int i, User user) {
        if (this.lines.get(i - ONE)) {
            user.moveLeft();
            return true;
        }
        return false;
    }

    private void checkLastElement(int i, User user) {
        if (this.lines.get(i - ONE)) {
            user.moveLeft();
        }
    }

    private void checkMiddleElement(User user) {
        for (int i = 1; i < this.lines.size(); i++) {
            if (checkMiddleElementDetail(i, user)) break;
        }
    }

    private boolean checkMiddleElementDetail(int i, User user) {
        if (user.getPosition() == i) {
            return checkMiddleElementDirection(i, user);
        }
        return false;
    }

    private boolean checkMiddleElementDirection(int i, User user) {
        if (checkLeftLine(i, user)) {
            return true;
        }
        return checkRightLine(i, user);
    }

    public ArrayList<Boolean> getLines() {
        return this.lines;
    }
}
