package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderLine;
import ladder.domain.User;
import java.util.ArrayList;
import java.util.Iterator;

import static ladder.view.InputView.getMaxNameLength;

public class ResultView {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";
    private static final String BLANK = " ";
    private static final String COLON = ":";
    private static final String EXPLAIN_RESULT = "사다리 결과";
    private static final String EXPLAIN_PLAYER_RESULT = "실행 결과";
    private static final int FIVE = 5;

    private static StringBuilder resultOfLadder = new StringBuilder();

    public static void printResult(LadderGame ladder){
        System.out.println(EXPLAIN_RESULT);
        for (User user : ladder.getUsers()) {
            System.out.printf(cutNameLength(user.getName()) + BLANK);
        }
        System.out.println();
        for(LadderLine ladderLine : ladder.getLadders()){
            System.out.println(printLineImage(ladderLine.getLines()));
        }
        for (String inputResult : ladder.getResultOfGame()) {
            System.out.printf(String.format("%-5s", inputResult) + BLANK);
        }

        System.out.println();
        printResultDetails(ladder);
    }

    private static String printLineImage(ArrayList<Boolean> lines){
        String horizontal = calculateNumHorizontal(HORIZONTAL);
        String blank = calculateNumHorizontal(BLANK);

        resultOfLadder.setLength(LadderLine.ZERO);
        resultOfLadder.append(VERTICAL);
        for(boolean line : lines){
            resultOfLadder.append(!line ? blank : horizontal);
            resultOfLadder.append(VERTICAL);
        }
        return resultOfLadder.toString();
    }

    private static void printResultDetails(LadderGame ladder) {
        boolean flag = true;

        while(flag) {
            String userInput = InputView.inputPlayerResult();
            printEachPlayerResult(userInput, ladder);
            System.out.println();
            if(userInput.equals("all"))
                flag = false;
        }
        System.out.println(EXPLAIN_PLAYER_RESULT);
        printAllResultDetails(ladder);
    }

    private static void printEachPlayerResult(String userInput, LadderGame ladder) {
        if (ladder.getResultDic().containsKey(userInput)) {
            System.out.println(EXPLAIN_PLAYER_RESULT);
            System.out.println(ladder.getResultDic().get(userInput));
        }
    }

    private static void printAllResultDetails(LadderGame ladder) {
        Iterator<String> keySetIterator = ladder.getResultDic().keySet().iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            System.out.println(key + BLANK + COLON + BLANK + ladder.getResultDic().get(key));
        }
    }

    public static String cutNameLength(String name) {
        if(name.length() > getMaxNameLength()) {
            return  name.substring(LadderLine.ZERO, getMaxNameLength());
        }
        return String.format("%-5s", name);
    }

    private static String calculateNumHorizontal(String horizontal) {
        StringBuilder horizontalLines = new StringBuilder();
        for (int i = 0; i < FIVE; i++) {
            horizontalLines.append(horizontal);
        }
        return horizontalLines.toString();
    }
}

