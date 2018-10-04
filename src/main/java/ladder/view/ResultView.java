package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderLine;
import ladder.domain.User;

import java.util.ArrayList;

import static ladder.view.InputView.getMaxNameLength;

public class ResultView {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";
    private static final String BLANK = " ";
    private static final String EXPLAIN_RESULT = "실행결과";
    private static final int ZERO = 0;
    public static int MAX_NAME_LENGTH_OF_USER = 0;

    private static StringBuilder resultOfLadder = new StringBuilder();

    public static void printResult(LadderGame ladder){
        decideMaxNameLengthOfUser(ladder.getUsers());

        System.out.println();
        System.out.println(EXPLAIN_RESULT);

        for (User user : ladder.getUsers()) {
            System.out.printf(cutNameLength(user.getName()) + BLANK);
        }
        System.out.println();

        for(LadderLine ladderLine : ladder.getLadders()){
            System.out.println(printLineImage(ladderLine.getLines()));
        }
    }

    private static String printLineImage(ArrayList<Boolean> lines){
        String horizontal = calculateNumHorizontal(HORIZONTAL);
        String blank = calculateNumHorizontal(BLANK);

        resultOfLadder.setLength(ZERO);
        resultOfLadder.append(VERTICAL);
        for(boolean line : lines){
            resultOfLadder.append(!line ? blank : horizontal);
            resultOfLadder.append(VERTICAL);
        }
        return resultOfLadder.toString();
    }

    public static String cutNameLength(String name) {
        if(name.length() > getMaxNameLength()) {
            return  name.substring(ZERO, getMaxNameLength());
        }
        return String.format("%-5s", name);
    }

    private static void decideMaxNameLengthOfUser(ArrayList<User> users) {
        for (User user : users) {
            if (compareMaxNameLengthOfUser(user)) return;
        }
    }

    private static boolean compareMaxNameLengthOfUser(User user) {
        int size = user.getName().length();
        if (size > MAX_NAME_LENGTH_OF_USER) {
            MAX_NAME_LENGTH_OF_USER = size;
        }
        return false;
    }

    private static String calculateNumHorizontal(String horizontal) {
        StringBuilder horizontalLines = new StringBuilder();
        for (int i = 0; i < MAX_NAME_LENGTH_OF_USER; i++) {
            horizontalLines.append(horizontal);
        }
        return horizontalLines.toString();
    }
}

