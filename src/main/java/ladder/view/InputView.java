package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ASK_NAME_OF_PLAYER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_HEIGHT_OF_LADDER = "최대 사다리 높이는 몇 개인가요?";

    private static Scanner sc = new Scanner(System.in);

    public static List<String> inputNameOfPlayer() {
        System.out.println(ASK_NAME_OF_PLAYER);
        return splitNames(sc.nextLine());
    }

    private static List<String> splitNames(String inputNames) {
        List<String> names = Arrays.asList((inputNames).split(","));
        return names;
    }

    public static int inputNumOfLadder() {
        System.out.println();
        System.out.println(ASK_HEIGHT_OF_LADDER);
        return sc.nextInt();
    }
}