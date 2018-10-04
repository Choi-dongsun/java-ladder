package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LadderLineTest {
    // Line 객체에서 선을 그릴 수 있는지 여부를 판단하는 로직에 대한 단위 테스트
    @Test
    public void makeRandomValue() {
        LadderLine ladder = new LadderLine();
        boolean check = ladder.makeRandomValue();
        assertTrue(check == true || check == false);
    }

    @Test
    public void checkBeforeHorizontalLine() {
        LadderLine ladder = new LadderLine();
        ladder.lines.add(true);
        assertThat(ladder.checkBeforeHorizontalLine()).isEqualTo(false);

        ladder.lines.add(false);
        boolean check = ladder.checkBeforeHorizontalLine();
        assertTrue(check == true || check == false);
    }

    @Test
    public void decideNextHorizontalLine() {
        LadderLine ladder = new LadderLine();
        boolean check = ladder.decideNextHorizontalLine();
        assertTrue(check == true || check == false);

        ladder.lines.add(true);
        assertThat(ladder.decideNextHorizontalLine()).isEqualTo(false);
    }

    @Test
    public void makeHorizontalLine() {
        LadderLine ladder1 = new LadderLine();
        ladder1.lines.add(true);
        ladder1.makeHorizontalLine();
        assertThat(ladder1.lines.get(1)).isEqualTo(false);

        ladder1.makeHorizontalLine();
        assertTrue(ladder1.lines.get(2) == true || ladder1.lines.get(2) == false);

        LadderLine ladder2 = new LadderLine();
        ladder2.lines.add(false);
        ladder2.makeHorizontalLine();
        assertTrue(ladder2.lines.get(1) == true || ladder2.lines.get(1) == false);
    }
}


