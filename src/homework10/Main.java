package homework10;

import static auxiliary.Functions.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {}

    public static <E> Collection<E> removeDuplicates(Collection<E> collection) {
        Set<E> set = new LinkedHashSet<>(collection);
        collection.clear();
        collection.addAll(set);
        return collection;
    }

    public static List<Double> solveQuadraticEquation(int a, int b, int c) {

        if (a == 0) {
            throw new IllegalArgumentException("Coefficient \"a\" can't be 0");
        }

        List<Double> roots = new ArrayList<>();
        int discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return roots;
        } else if (discriminant == 0) {
            roots.add((double) -b / (2 * a));
            return roots;
        } else {
            roots.add((-b + Math.sqrt(discriminant)) / (2 * a));
            roots.add((-b - Math.sqrt(discriminant)) / (2 * a));
            return roots;
        }
    }
}
