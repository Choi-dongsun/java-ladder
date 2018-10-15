package ladder.domain;

import ladder.util.RandomGenerator;
import java.util.ArrayList;

public class LadderLine {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    private ArrayList<Boolean> lines;

    public LadderLine(ArrayList<Boolean> lines) {
        this.lines = lines;
    }

    public void makeHorizontalLine() {
        this.lines.add(this.decideNextHorizontalLine());
    }

    public boolean decideNextHorizontalLine() {
        if (lines.size() != ZERO) {
            return checkBeforeHorizontalLine();
        }
        return RandomGenerator.makeRandomValue();
    }

    public boolean checkBeforeHorizontalLine() {
        if (lines.get(lines.size() - ONE)) {
            return false;
        }
        return RandomGenerator.makeRandomValue();
    }

    public ArrayList<Boolean> getLines() {
        return this.lines;
    }




}
