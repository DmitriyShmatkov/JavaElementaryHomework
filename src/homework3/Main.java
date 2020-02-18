package homework3;

import java.util.Arrays;

import static auxiliary.Functions.*;

public class Main {

    public static void main(String[] args) {

//        ---------------------------------------------------------
//        1.
//        ---------------------------------------------------------

        System.out.println("\nTask 1");
        System.out.println("Display all odd numbers from 1 to 99");
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0) {
                System.out.print(i + "  ");
            }
        }

//        ---------------------------------------------------------
//        2.
//        ---------------------------------------------------------

        int number;
        long result = 1;
        System.out.println("\n\nTask 2");
        System.out.println("Calculate number's factorial");
        System.out.println("Enter a number");
        number = enterPositiveInteger();
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        System.out.println(number + "! = " + result);

//        ---------------------------------------------------------
//        3.
//        ---------------------------------------------------------

        /*System.out.println("\nTask 1");
        System.out.println("Display all odd numbers from 1 to 99");
        int i = 1;
        while (i <= 99) {
            if (i % 2 != 0) {
                System.out.print(i + "  ");
            }
            i++;
        }

        int number;
        int result = 1;
        System.out.println("\n\nTask 2");
        System.out.println("Calculate number's factorial");
        System.out.println("Enter a number");
        number = enterPositiveInteger();
        i = 2;
        while (i <= number) {
            result *= i;
            i++;
        }
        System.out.println(number + "! = " + result);*/

//        ---------------------------------------------------------
//        4.
//        ---------------------------------------------------------

        /*System.out.println("\nTask 1");
        System.out.println("Display all odd numbers from 1 to 99");
        int i = 1;
        do {
            if (i % 2 != 0) {
                System.out.print(i + "  ");
            }
            i++;
        } while (i <= 99);

        int number;
        int result = 1;
        System.out.println("\n\nTask 2");
        System.out.println("Calculate number's factorial");
        System.out.println("Enter a number");
        number = enterPositiveInteger();
        i = 1;
        do {
            result *= i;
            i++;
        } while (i <= number);
        System.out.println(number + "! = " + result);*/

//        ---------------------------------------------------------
//        5.
//        ---------------------------------------------------------

        int power;
        System.out.println("\nTask 5");
        System.out.println("Raise a number to the certain power");
        System.out.println("Enter a number");
        number = enterPositiveInteger();
        System.out.println("Enter a power");
        power = enterInteger();
        result = 1;
        for (int i = 0; i < Math.abs(power); i++) {
            result *= number;
        }
        if (power >= 0) {
            System.out.println(number + " ^ " + power + " = " + result);
        } else {
            System.out.println(number + " ^ " + "(" + power + ")" + " = 1 / " + result);
        }

//        ---------------------------------------------------------
//        6.
//        ---------------------------------------------------------

        int element = 0;
        System.out.println("\nTask 6");
        System.out.println("Display arithmetic sequence");
        for (int i = 0; i < 10; i++) {
            System.out.print(element + "  ");
            element -= 5;
        }
        System.out.println("...");

//        ---------------------------------------------------------
//        7.
//        ---------------------------------------------------------

        System.out.println("\nTask 7");
        System.out.println("\"Multiplication table\"");
        System.out.println("Enter a number");
        number = enterInteger();
        for (int i = 1; i < 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }

//        ---------------------------------------------------------
//        8.
//        ---------------------------------------------------------

        System.out.println("\nTask 8");
        System.out.println("Create and display an array");
        int[] array = new int[10];
        for (int i = 0, j = 1; i < array.length; i++, j += 2) {
            array[i] = j;
        }
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i]);
            }
        }
//        This is a better and much easier way :D
//        System.out.println(Arrays.toString(array));

//        ---------------------------------------------------------
//        9-12.
//        ---------------------------------------------------------

        System.out.println("\nTask 9-12");
        System.out.println("Min and max element search in array. Swapping elements. Calculating average");
        System.out.println("Enter array capacity");
        array = new int[enterPositiveInteger()];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Generated array:");
        System.out.println(Arrays.toString(array));
        int min = array[0];
        int max = array[0];
        int minIndex = 0;
        int maxIndex = 0;
        int sum = array[0];
//        Searching for min and max elements
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        System.out.println("Min element: " + min);
        System.out.println("Max element: " + max);
//        Swapping min and max elements
        int tmp = array[minIndex];
        array[minIndex] = array[maxIndex];
        array[maxIndex] = tmp;
        System.out.println("Swapped min and max:");
        System.out.println(Arrays.toString(array));
        System.out.println("Average: " + (double) sum / array.length);

//        ---------------------------------------------------------
//        13.
//        ---------------------------------------------------------

        System.out.println("\nTask 13");
        System.out.println("Display a chessboard");
        String[][] chessboard = new String[8][8];
        String color = "⬛";
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                chessboard[i][j] = color;
                color = color.equals("⬛") ? "⬜" : "⬛";
                System.out.print(chessboard[i][j] + "  ");
            }
            color = color.equals("⬛") ? "⬜" : "⬛";
            System.out.println();
        }
    }
}
