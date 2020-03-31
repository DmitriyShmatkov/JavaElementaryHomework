import homework13.StreamUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamUtilsTest {

    @Test
    public void averageTest() {
        Set<Integer> set = new HashSet<>(Arrays.asList(4, 5, 6, 7));
        assertEquals(5.5, StreamUtils.average(set));
    }

    @Test
    public void toUpperCaseTest() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("one", "ONE");
        expected.put("two", "TWO");
        expected.put("three", "THREE");

        Map<String, String> actual = StreamUtils.toUpperCase(list);

        assertEquals(expected.entrySet(), actual.entrySet());
    }
}
