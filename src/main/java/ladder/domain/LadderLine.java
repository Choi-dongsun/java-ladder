package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class LadderLine {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int BooleanCheckNum = 2;
    private static Random rnd = new Random();
    private ArrayList<Integer> lines = new ArrayList<>();

    void makeHorizontalLine() {
        this.lines.add(this.decideNextHorizontalLine());
    }

    private int decideNextHorizontalLine() {
        if (lines.size() != 0) {
            return checkBeforeHorizontalLine();
        }
        return this.makeRandomValue();
    }

    private int checkBeforeHorizontalLine() {
        if (lines.get(lines.size() - ONE) == ONE) {
            return ZERO;
        }
        return this.makeRandomValue();
    }

    private int makeRandomValue() {
        return (rnd.nextInt(BooleanCheckNum));
    }

    public ArrayList<Integer> getLines() {
        return this.lines;
    }

}
