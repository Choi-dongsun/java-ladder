package study;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListTest {
    @Test
    public void arrayList() throws Exception {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.contains("first")).isTrue();
        assertThat(values.remove(0)).isEqualTo("first");
    }

    @Test
    public void LinkedList() throws Exception {
        LinkedList<Integer> text = new LinkedList<>();
        text.add(10);
        text.add(20);

        assertTrue(text.add(30));
        assertTrue(text.size() == 3);

        assertEquals(3, text.size());

        assertThat(text.get(0)).isEqualTo(10);
        assertThat(text.contains(30)).isTrue();
        assertThat(text.remove(2)).isEqualTo(30);


    }
}
