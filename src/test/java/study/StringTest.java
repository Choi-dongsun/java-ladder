package study;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void 문자열_길이_구하기() throws Exception {
        String name = "최동선";
        assertThat(name.length()).isEqualTo(3);
    }

    @Test
    public void 문자열_더하기() throws Exception {
        String name = "최동선";
        String welcome = "안녕!";
        assertThat(welcome + name).isEqualTo("안녕!최동선");
    }

    @Test
    public void 문자열을_문자_단위로_출력() throws Exception {
        String name = "최동선";
        String[] words = name.split("");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

    @Test
    public void 문자열_뒤집기() throws Exception {
        String name = "최동선";
        String[] words = name.split("");
        String[] reverseName = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reverseName[i] = words[words.length - i - 1];
        }
        String Name = reverseName[0] + reverseName[1] + reverseName[2];

        assertThat(Name).isEqualTo("선동최");
    }

    @Test
    public void 문자열_뒤집기2() throws Exception {
        String name = "최동선";
        StringBuilder sb = new StringBuilder();
        String[] words = name.split("");
        String[] reverseName = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reverseName[i] = words[words.length - i - 1];
        }
        for (int i = 0; i < reverseName.length; i++) {
            sb.append(reverseName[i]);
        }

        assertThat(sb.toString()).isEqualTo("선동최");
    }
}