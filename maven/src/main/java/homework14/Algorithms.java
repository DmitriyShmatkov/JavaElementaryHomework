package homework14;

public class Algorithms {

    private Algorithms() {
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int swapCount = 0;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapCount++;
                }
            }
            if (swapCount == 0) {
                break;
            }
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (key < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = key;
                }
            }
        }
        return array;
    }

    public static int binarySearch(int[] array, int key) {
        return binarySearch(array, key, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int key, int from, int to) {
        if (key == array[from]) {
            return from;
        }
        if (key == array[to]) {
            return to;
        }
        if (from == to) {
            return -1;
        }

        int mid = (from + to) >> 1;

        if (key < array[mid]) {
            return binarySearch(array, key, from, mid);
        }
        if (key > array[mid]) {
            return binarySearch(array, key, mid + 1, to);
        }
        return mid;
    }

    public static int interpolationSearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (key > array[left] && key < array[right]) {
            int mid = left + (key - array[left]) * (right - left) / (array[right] - array[left]);
            if (array[mid] < key) {
                left = mid + 1;
            } else if (array[mid] > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        if (array[left] == key) {
            return left;
        }
        if (array[right] == key) {
            return right;
        }
        return -1;
    }
}
