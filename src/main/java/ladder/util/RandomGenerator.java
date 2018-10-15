package ladder.util;

import java.util.Random;

public class RandomGenerator {
    private static final int BooleanCheckNum = 2;
    private static Random rnd = new Random();

    public static boolean makeRandomValue() {
        return rnd.nextInt(BooleanCheckNum) == 1;
    }

}
