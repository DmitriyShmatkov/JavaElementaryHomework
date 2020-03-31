package homework12;

import java.util.Arrays;

public class StringCollection {

    private static final int INITIAL_SIZE = 16;

    private String[] strings;
    private int elementsNumber;

    public StringCollection() {
        strings = new String[INITIAL_SIZE];
        elementsNumber = 0;
    }

    public boolean add(String string) {
        if (string == null) {
            return false;
        }
        if (elementsNumber == strings.length * 3 / 4) {
            strings = Arrays.copyOf(strings, strings.length * 2);
        }
        strings[elementsNumber] = string;
        elementsNumber++;
        return true;
    }

    public boolean remove(String string) {
        if (string == null) {
            return false;
        }
        int i;
        for (i = 0; i < elementsNumber; i++) {
            if (strings[i].equals(string)) {
                break;
            }
        }
        if (i == elementsNumber) {
            return false;   // No such element
        }
        for (; i < elementsNumber - 1; i++) {
            strings[i] = strings[i + 1];
        }
        elementsNumber--;
        return true;
    }

    public String get(int index) {
        if (index < 0 || index >= elementsNumber) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return strings[index];
    }

    public boolean contains(String string) {
        if (string == null) {
            return false;
        }
        for (int i = 0; i < elementsNumber; i++) {
            if (strings[i].equals(string)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof StringCollection collection)) {
            if (collection.elementsNumber != elementsNumber) {
                return false;
            }
            for (int i = 0; i < elementsNumber; i++) {
                if (!strings[i].equals(collection.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void clear() {
        strings = new String[INITIAL_SIZE];
    }

    public int indexOf(String string) {
        if (string == null) {
            return -1;
        }
        for (int i = 0; i < elementsNumber; i++) {
            if (strings[i].equals(string)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return elementsNumber;
    }

    public static void main(String[] args) {
        StringCollection collection = new StringCollection();
        collection.add("first");
        collection.add("second");
        collection.add("third");
        System.out.println(collection.get(0));
        System.out.println(collection.get(1));
        System.out.println(collection.get(2));
    }
}
