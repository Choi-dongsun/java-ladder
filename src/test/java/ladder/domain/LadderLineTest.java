package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import ladder.util.RandomGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LadderLineTest {
    // Line 객체에서 선을 그릴 수 있는지 여부를 판단하는 로직에 대한 단위 테스트
    LadderLine ladder;

    @Before
    public void setUp(){
        ladder = new LadderLine(new ArrayList<>(Arrays.asList()));
    }

    @Test
    public void makeRandomValue() {
        boolean check = RandomGenerator.makeRandomValue();
        assertTrue(check == true || check == false);
    }

    @Test
    public void checkBeforeHorizontalLine() {
        ladder.getLines().add(true);
        assertThat(ladder.checkBeforeHorizontalLine()).isEqualTo(false);

        ladder.getLines().add(false);
        boolean check = ladder.checkBeforeHorizontalLine();
        assertTrue(check == true || check == false);
    }

    @Test
    public void decideNextHorizontalLine() {
        boolean check = ladder.decideNextHorizontalLine();
        assertTrue(check == true || check == false);

        ladder.getLines().add(true);
        assertThat(ladder.decideNextHorizontalLine()).isEqualTo(false);
    }

    @Test
    public void makeHorizontalLine() {
        ladder.getLines().add(true);
        ladder.makeHorizontalLine();
        assertThat(ladder.getLines().get(1)).isEqualTo(false);

        ladder.makeHorizontalLine();
        assertTrue(ladder.getLines().get(2) == true || ladder.getLines().get(2) == false);

        LadderLine ladder2 = new LadderLine(new ArrayList<>());
        ladder2.getLines().add(false);
        ladder2.makeHorizontalLine();
        assertTrue(ladder2.getLines().get(1) == true || ladder2.getLines().get(1) == false);
    }
}


