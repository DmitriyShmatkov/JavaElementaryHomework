package homework9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class LinkedListString implements CustomCollection {

    private NodeString first;
    private NodeString last;
    private int size;

    public LinkedListString() {
        first = new NodeString();
        last = new NodeString();
        first.setNext(last);
        last.setPrevious(first);
        size = 0;
    }

    @Override
    public boolean add(String str) {
        NodeString node = new NodeString(str);
        node.setNext(last);
        node.setPrevious(last.getPrevious());
        last.getPrevious().setNext(node);
        last.setPrevious(node);
        size++;
        return true;
    }

    @Override
    public boolean addAll(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String string : strArr) {
            add(string);
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<String> strColl) {
        if (strColl == null) {
            return false;
        }
        for (String string: strColl) {
            add(string);
        }
        return true;
    }

    private void remove(NodeString node) {
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
        size--;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        NodeString desiredNode = first.getNext();
        for (int i = 0; i < index; i++) {
            desiredNode = desiredNode.getNext();
        }
        remove(desiredNode);
        return true;
    }

    @Override
    public boolean remove(String str) {
        NodeString desiredNode = first.getNext();
        if (str == null) {
            for (int i = 0; i < size; i++) {
                if (desiredNode.getString() == null) {
                    remove(desiredNode);
                    return true;
                }
                desiredNode = desiredNode.getNext();
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (str.equals(desiredNode.getString())) {
                    remove(desiredNode);
                    return true;
                }
                desiredNode = desiredNode.getNext();
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        NodeString desiredNode = first.getNext();
        for (int i = 0; i < index; i++) {
            desiredNode = desiredNode.getNext();
        }
        return desiredNode.getString();
    }

    @Override
    public boolean contains(String str) {
        NodeString desiredNode = first.getNext();
        if (str == null) {
            for (int i = 0; i < size; i++) {
                if (desiredNode.getString() == null) {
                    return true;
                }
                desiredNode = desiredNode.getNext();
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (str.equals(desiredNode.getString())) {
                    return true;
                }
                desiredNode = desiredNode.getNext();
            }
        }
        return false;
    }

    @Override
    public void clear() {
        first.setNext(last);
        last.setPrevious(first);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean compare(Collection<String> coll) {
        if (coll == null) {
            return false;
        }
        if (coll.size() != size) {
            return false;
        }
        Iterator<String> iterator = coll.iterator();
        NodeString node = first.getNext();
        for (int i = 0; i < size; i++) {
            if (!(iterator.next().equals(node.getString()))) {
                return false;
            }
            node = node.getNext();
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        NodeString node = first.getNext();
        for (int i = 0; i < size - 1; i++) {
            result.append(node.getString()).append(", ");
            node = node.getNext();
        }
        return result.append(node.getString()).append("]").toString();
    }

    public static void main(String[] args) {
        LinkedListString myList = new LinkedListString();

        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.addAll(new String[] {"four", "five"});
        myList.addAll(Arrays.asList("six", "seven"));
        System.out.println(myList);

        System.out.println(myList.get(2));

        myList.remove(2);
        System.out.println(myList.remove("six"));
        System.out.println(myList);

        System.out.println(myList.compare(Arrays.asList("one", "two", "four", "five", "seven")));
    }
}
