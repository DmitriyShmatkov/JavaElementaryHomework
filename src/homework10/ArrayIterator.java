package homework10;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {

    private E[] array;
    private int nextIndex;
    private int lastReturnedIndex;

    public ArrayIterator(E[] array) {
        this.array = array;
        nextIndex = 0;
        lastReturnedIndex = -1;
    }

    @Override
    public void remove() {
        if (lastReturnedIndex == -1) {
            throw new IllegalStateException();
        }
        for (int i = lastReturnedIndex; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array = Arrays.copyOf(array, array.length - 1);
        nextIndex--;
        lastReturnedIndex = -1;
    }

    @Override
    public boolean hasNext() {
        return nextIndex != array.length;
    }

    @Override
    public E next() {
        lastReturnedIndex = nextIndex;
        return array[nextIndex++];
    }
}
