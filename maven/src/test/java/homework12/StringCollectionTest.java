package homework12;

import homework12.StringCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCollectionTest {

    private StringCollection collection;

    @BeforeEach
    public void setUp() {
        collection = new StringCollection();
        collection.add("one");
        collection.add("two");
        collection.add("three");
    }

    @Test
    public void addTest() {
        assertFalse(collection.add(null));
        assertTrue(collection.add("four"));

        StringCollection expectedCollection = new StringCollection();
        expectedCollection.add("one");
        expectedCollection.add("two");
        expectedCollection.add("three");
        expectedCollection.add("four");

        assertEquals(expectedCollection, collection);
    }

    @Test
    public void removeTest() {
        assertFalse(collection.remove(null));
        assertFalse(collection.remove("four"));
        assertTrue(collection.remove("one"));

        StringCollection expectedCollection = new StringCollection();
        expectedCollection.add("two");
        expectedCollection.add("three");

        assertEquals(expectedCollection, collection);
    }

    @Test
    public void getTest() {
        assertEquals("one", collection.get(0));
    }

    @Test
    public void getInvalidIndexTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> collection.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> collection.get(4));
    }

    @Test
    public void containsTest() {
        assertFalse(collection.contains(null));
        assertFalse(collection.contains("four"));
        assertTrue(collection.contains("one"));
    }

    @Test
    public void equalsTest() {
        StringCollection comparedCollection = new StringCollection();
        for (int i = 0; i < collection.size(); i++) {
            comparedCollection.add(collection.get(i));
        }
        comparedCollection.add("four");

        assertNotEquals(collection, new Object());

        assertNotEquals(collection, comparedCollection);

        comparedCollection.remove("four");
        assertEquals(collection, comparedCollection);

        comparedCollection.remove("three");
        comparedCollection.add("five");
        assertNotEquals(collection, comparedCollection);
    }

    @Test
    public void indexOfTest() {
        assertEquals(1, collection.indexOf("two"));
        assertEquals(-1, collection.indexOf(null));
        assertEquals(-1, collection.indexOf("four"));
    }
}
