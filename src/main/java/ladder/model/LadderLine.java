package ladder.model;

import java.util.ArrayList;
import java.util.Random;

public class LadderLine {
    private static Random rnd = new Random();
    private ArrayList<Integer> lines = new ArrayList<>();

    void makeHorizontalLine() {
        this.lines.add(this.makeRandomValue());
    }

    private int makeRandomValue() {
        return (rnd.nextInt(2));
    }

    public ArrayList<Integer> getLines() {
        return this.lines;
    }

}
