package homework14;

import homework14.Algorithms;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsTest {

    @Test
    public void bubbleSortTest() {
        int[] array = {3, 8, 2, 1, 5};
        int[] expected = {1, 2, 3, 5, 8};
        assertArrayEquals(expected, Algorithms.bubbleSort(array));
    }

    @Test
    public void insertionSortTest() {
        int[] array = {3, 8, 2, 1, 5};
        int[] expected = {1, 2, 3, 5, 8};
        assertArrayEquals(expected, Algorithms.insertionSort(array));
    }

    @Test
    public void binarySearchTest() {
        int[] array = {0, 3, 4, 6, 9, 12, 15};
        assertEquals(5, Algorithms.binarySearch(array, 12));
        assertEquals(-1, Algorithms.binarySearch(array, 20));
    }

    @Test
    public void interpolationSearchTest() {
        int[] array = {6, 9, 13, 14, 17, 19, 23};
        assertEquals(1, Algorithms.interpolationSearch(array, 9));
        assertEquals(-1, Algorithms.binarySearch(array, 20));
    }
}
