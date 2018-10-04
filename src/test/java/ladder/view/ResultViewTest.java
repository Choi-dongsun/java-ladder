package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.LadderGame;
import ladder.domain.User;
import org.junit.Test;

public class ResultViewTest {
    // 사다리 결과를 출력할 때 최대 5 글자를 정확히 출력하는지 처리하는 로직에 대한 테스트
    @Test
    public void cutNameLength() {
        String name1 = "123456";
        String name2 = "12345";
        String name3 = "123456789999999999";

        assertThat(ResultView.cutNameLength(name1).length()).isEqualTo(5);
        assertThat(ResultView.cutNameLength(name2).length()).isEqualTo(5);
        assertThat(ResultView.cutNameLength(name3).length()).isEqualTo(5);
    }

    @Test
    public void printResult() {
        LadderGame ladder = new LadderGame();
        ladder.user.add(new User("4444"));
        ladder.user.add(new User("55555"));
        ladder.user.add(new User("666666"));
        ladder.user.add(new User("999999999"));

        ResultView.printResult(ladder);
    }



}
