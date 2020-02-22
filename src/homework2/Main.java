package homework2;

import auxiliary.Money;

import java.math.BigDecimal;
import java.util.*;

import static auxiliary.Functions.*;

public class Main {

    public static void main(String[] args) {

        // Test for task 1

        System.out.println("Enter 2 numbers");

        double a = enterNumber();
        double b = enterNumber();

        System.out.println("AVG = " + Average.getAverage(a, b) + "\n");

        // -----------------------------------------------------------------------

        // Test for task 2

        List<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Start entering numbers");
        System.out.println("Enter \"end\" to calculate average");

        while (true) {
            String str = scanner.next();
            if (str.toLowerCase().equals("end")) {
                break;
            }
            try {
                numbers.add(Double.parseDouble(str));
            } catch (NumberFormatException e) {
                System.err.println("Incorrect input, try again");
            }
        }
        System.out.println("All numbers:");
        System.out.println(numbers.toString());
        System.out.println("AVG = " + Average.getAverage(numbers));
        System.out.println();

        // -----------------------------------------------------------------------

        // Test for task 3

        Money money;
        BigDecimal percent;
        int years;

        System.out.println("Enter amount of money");
        money = new Money(enterPositiveNumber());
        System.out.println("Enter percent");
        percent = BigDecimal.valueOf(enterPositiveNumber());
        System.out.println("Enter number of years");
        years = enterPositiveInteger();

        Deposit.calculate(money, percent, years);
    }
}