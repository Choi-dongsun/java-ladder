package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class LadderLine {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int BooleanCheckNum = 2;
    private static Random rnd = new Random();

    public ArrayList<Boolean> lines = new ArrayList<>();

    public void makeHorizontalLine() {
        this.lines.add(this.decideNextHorizontalLine());
    }

    public boolean decideNextHorizontalLine() {
        if (lines.size() != ZERO) {
            return checkBeforeHorizontalLine();
        }
        return this.makeRandomValue();
    }

    public boolean checkBeforeHorizontalLine() {
        if (lines.get(lines.size() - ONE)) {
            return false;
        }
        return this.makeRandomValue();
    }

    public boolean makeRandomValue() {
        return rnd.nextInt(BooleanCheckNum) == 1;
    }

    public ArrayList<Boolean> getLines() {
        return this.lines;
    }

}
