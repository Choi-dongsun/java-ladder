package ladder.view;

import ladder.model.LadderLine;
import java.util.ArrayList;

public class ResultView {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";
    private static final String BLANK = " ";
    private static final int ZERO = 0;

    private static StringBuilder resultOfLadder = new StringBuilder();

    public static void printResult(ArrayList<LadderLine> ladders){
        for(LadderLine ladder : ladders){
            System.out.println(printLineImage(ladder.getLines()));
        }
    }

    private static String printLineImage(ArrayList<Integer> lines){
        resultOfLadder.setLength(ZERO);
        resultOfLadder.append(VERTICAL);
        for(int line : lines){
            resultOfLadder.append(line == ZERO ? BLANK : HORIZONTAL);
            resultOfLadder.append(VERTICAL);
        }
        return resultOfLadder.toString();
    }
}
