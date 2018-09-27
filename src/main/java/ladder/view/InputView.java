package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUM_OF_PLAYER = "참여할 사람은 몇 명 인가요?";
    private static final String ASK_HEIGHT_OF_LADDER = "최대 사다리 높이는 몇 개인가요?";

    private static Scanner sc = new Scanner(System.in);

    public static int inputNumOfPlayer() {
        System.out.println(ASK_NUM_OF_PLAYER);
        return sc.nextInt();
    }

    public static int inputNumOfLadder() {
        System.out.println(ASK_HEIGHT_OF_LADDER);
        return sc.nextInt();
    }
}
