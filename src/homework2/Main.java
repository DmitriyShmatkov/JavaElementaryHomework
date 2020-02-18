package homework2;

import java.util.List;

import static auxiliary.Functions.*;

public class Main {

    public static void main(String[] args) {

        // Test for task 1

        while (true) {

            System.out.println("Enter 2 numbers");

            double a = enterNumber();
            double b = enterNumber();

            System.out.println("AVG = " + Average.getAverage(a, b) + "\n");
        }

        // -----------------------------------------------------------------------

        // Test for task 2

        /*while (true) {

            List<Double> numbers = enterListOfNumbers();

            System.out.println("AVG = " + Average.getAverage(numbers));
            System.out.println();
        }*/

        // -----------------------------------------------------------------------

        // Test for task 3

        /*double money;
        double percent;
        double years;

        System.out.println("Enter amount of money");
        money = enterPositiveNumber();
        System.out.println("Enter percent");
        percent = enterPositiveNumber();
        System.out.println("Enter number of years");
        years = enterPositiveNumber();
        while (years <= 0 || Math.floor(years) != years) {
            System.out.println("Incorrect input, try again");
            years = enterPositiveNumber();
        }

        Deposit.calculate(money, percent, (int) years);*/
    }
}