package homework10;

import static auxiliary.Functions.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int a, b, c;

        System.out.println();
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║   Quadratic equation solver   ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println("\nEnter the coefficients");
        System.out.print("a = ");
        a = enterInteger();
        while (a == 0) {
            System.out.println("Coefficient \"a\" can't be 0, enter again");
            System.out.print("a = ");
            a = enterInteger();
        }
        System.out.print("b = ");
        b = enterInteger();
        System.out.print("c = ");
        c = enterInteger();

        // User-friendly console output
        String equationToString =
                factorToString(a, "x²") +
                        factorToString(b, "x") +
                        factorToString(c) + "= 0";
        System.out.println("\n" + equationToString + "\n");

        int discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("No roots");
        } else if (discriminant == 0) {
            System.out.println("One root");
            System.out.println("x = " + (-b / (2 * a)));
        } else {
            System.out.println("Two roots");
            System.out.println("x₁ = " + ((-b + Math.sqrt(discriminant)) / (2 * a)));
            System.out.println("x₂ = " + ((-b - Math.sqrt(discriminant)) / (2 * a)));
        }
    }

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
