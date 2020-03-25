package auxiliary;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// A class with functions that cover some frequently occurring tasks

public class Functions {

    private Functions() {
    }

    private static BigDecimal enterBigDecimal() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return new BigDecimal(scanner.next());
            } catch (NumberFormatException e) {
                System.err.println("Incorrect input, try again");
            }
        }
    }

    public static double enterNumber() {
        return enterBigDecimal().doubleValue();
    }

    public static int enterInteger() {
        while (true) {
            BigDecimal a = enterBigDecimal();
            if (a.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0) {
                System.err.println("Please, enter a less number");
                continue;
            }
            if (a.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) < 0) {
                System.err.println("Please, enter a greater number");
                continue;
            }
            if (a.stripTrailingZeros().scale() > 0) {
                System.err.println("Please, enter an integer");
                continue;
            }
            return a.intValue();
        }

    }

    public static double enterPositiveNumber() {
        while (true) {
            double a = enterNumber();
            if (a > 0) {
                return a;
            }
            System.err.println("Please, enter a positive number");
        }
    }

    public static int enterPositiveInteger() {
        while (true) {
            int a = enterInteger();
            if (a > 0) {
                return a;
            }
            System.err.println("Please, enter a positive number");
        }
    }

    public static double setPrecision(double number, int precision) {
        if (precision < 0) {
            throw new IllegalArgumentException("Negative precision value");
        }
        return BigDecimal.valueOf(number)
                .setScale(precision, RoundingMode.HALF_UP)
                .doubleValue();

    }

    public static String factorToString(int factor) {
        if (factor != 0) {
            StringBuilder factorToString = new StringBuilder();
            if (factor > 0) {
                factorToString.append("+ ");
            } else {
                factorToString.append("- ");
            }
            return factorToString
                    .append(Math.abs(factor))
                    .append(" ")
                    .toString();
        }
        return "";
    }

    public static String factorToString(int factor, String variableName) {
        if (factor != 0) {
            StringBuilder factorToString = new StringBuilder();
            if (factor > 0) {
                factorToString.append("+ ");
            } else {
                factorToString.append("- ");
            }
            return factorToString
                    .append((Math.abs(factor) == 1) ? "" : Math.abs(factor))
                    .append(variableName)
                    .append(" ")
                    .toString();
        }
        return "";
    }
}
