package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ASK_NAME_OF_PLAYER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_HEIGHT_OF_LADDER = "최대 사다리 높이는 몇 개인가요?";
    private static final String WARNING_MESSAGE = "이름은 5자 이내로 입력하시오.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 0;

    private static Scanner sc = new Scanner(System.in);

    public static List<String> inputNameOfPlayer() {
        List<String> names;
        while(true) {
            try {
                System.out.println(ASK_NAME_OF_PLAYER);
                names = checkNameLength(splitNames(sc.nextLine()));
                return names;
            }
            catch(Exception e) {
                System.out.println(WARNING_MESSAGE);
            }
        }
    }

    private static List<String> splitNames(String inputNames) {
        List<String> names = Arrays.asList((inputNames).split(","));
        return names;
    }

    private static List<String> checkNameLength(List<String> names) throws Exception {
        for (String name : names) {
            raiseException(name);
        }
        return names;
    }

    private static void raiseException(String name) throws Exception {
        if (name.length() > MAX_NAME_LENGTH || name.length() <= MIN_NAME_LENGTH) {
            throw new Exception();
        }
    }

    public static int inputNumOfLadder() {
        System.out.println();
        System.out.println(ASK_HEIGHT_OF_LADDER);
        return sc.nextInt();
    }

    static int getMaxNameLength() {
        return MAX_NAME_LENGTH;
    }

}