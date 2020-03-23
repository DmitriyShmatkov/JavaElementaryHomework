package homework10;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionMethods {

    private CollectionMethods() {}

    public static <E> Collection<E> removeDuplicates(Collection<E> collection) {
        Set<E> set = new LinkedHashSet<>(collection);
        collection.clear();
        collection.addAll(set);
        return collection;
    }
}
