package auxiliary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// A class with functions that cover some frequently occurring tasks

public class Functions {

    private Functions() {}


    public static double enterNumber() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.err.println("Incorrect input, try again");
            }
        } while (true);
    }


    public static int enterInteger() {
        Scanner scanner = new Scanner(System.in);
        double a = enterNumber();
        while (Math.floor(a) != a) {
            System.err.println("Please, enter an integer");
            a = enterNumber();
        }
        return (int) a;
    }


    public static double enterPositiveNumber() {
        double a = enterNumber();
        while (a <= 0) {
            System.err.println("Please, enter a positive number");
            a = enterNumber();
        }
        return a;
    }


    public static int enterPositiveInteger() {
        int a = enterInteger();
        while (a <= 0) {
            System.err.println("Please, enter a positive number");
            a = enterInteger();
        }
        return a;
    }


    public static List<Double> enterListOfNumbers() {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        System.out.println("Start entering numbers\nEnter any symbol to stop");
        do {
            try {
                list.add(Double.parseDouble(scanner.next()));
            } catch (NumberFormatException e) {
                return list;
            }
        } while (true);
    }
}
