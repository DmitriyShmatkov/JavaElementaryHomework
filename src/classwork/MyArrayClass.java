package classwork;

import java.util.Arrays;

public class MyArrayClass {

    int size;
    int[] array;

    public MyArrayClass(int size) {
        this.size = size;
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    public int min() {
        int min = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public int max() {
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public double average() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        return (double) sum / size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
