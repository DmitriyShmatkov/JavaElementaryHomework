package homework9;

import java.util.Collection;

public interface CustomCollection {

    boolean add(String str);

    boolean addAll(String[] strArr);

    boolean addAll(Collection<String> strColl);

    boolean remove(int index);

    boolean remove(String str);

    String get(int index);

    boolean contains(String str);

    void clear();

    int size();

    boolean compare(Collection<String> coll);
}
