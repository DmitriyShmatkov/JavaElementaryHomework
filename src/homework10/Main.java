package homework10;

import static auxiliary.Functions.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 2, 5));
        CollectionMethods.removeDuplicates(list);
        System.out.println("Collection without duplicates: " + list);

        List<Double> roots = MathMethods.solveQuadraticEquation(1, -1, -2);
        System.out.println("Roots of quadratic equation: " + roots);
    }
}
