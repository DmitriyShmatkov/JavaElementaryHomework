import homework15.DigitDrawer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DigitDrawerTest {

    @Test
    public void drawTestException() {
        assertThrows(IllegalArgumentException.class, () -> DigitDrawer.draw(new String("2 x 2")));
    }

    @Test
    public void drawTest() {
        String expected = """
                @@@@@@@@@@@@@@@@@@@@@@\t\t        @@@@@@\t\t@@@@@@@@@@@@@@@@@@@@@@\t\t
                @@@@@@@@@@@@@@@@@@@@@@\t\t      @@@@@@@@\t\t@@@@@@@@@@@@@@@@@@@@@@\t\t
                @@@@@@          @@@@@@\t\t    @@@@@@@@@@\t\t                @@@@@@\t\t
                @@@@@@          @@@@@@\t\t  @@@@@@@@@@@@\t\t                @@@@@@\t\t
                @@@@@@          @@@@@@\t\t@@@@@@@ @@@@@@\t\t                @@@@@@\t\t
                @@@@@@          @@@@@@\t\t        @@@@@@\t\t@@@@@@@@@@@@@@@@@@@@@@\t\t
                @@@@@@          @@@@@@\t\t        @@@@@@\t\t@@@@@@@@@@@@@@@@@@@@@@\t\t
                @@@@@@          @@@@@@\t\t        @@@@@@\t\t@@@@@@                \t\t
                @@@@@@          @@@@@@\t\t        @@@@@@\t\t@@@@@@                \t\t
                @@@@@@          @@@@@@\t\t        @@@@@@\t\t@@@@@@                \t\t
                @@@@@@@@@@@@@@@@@@@@@@\t\t        @@@@@@\t\t@@@@@@@@@@@@@@@@@@@@@@\t\t
                @@@@@@@@@@@@@@@@@@@@@@\t\t        @@@@@@\t\t@@@@@@@@@@@@@@@@@@@@@@\t\t
                """;

        String actual = DigitDrawer.draw(new String("012"));

        assertEquals(expected, actual);
    }
}
