package homework10;

import java.util.ArrayList;
import java.util.List;

public class MathMethods {

    private MathMethods() {}

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
