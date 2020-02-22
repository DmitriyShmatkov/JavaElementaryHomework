package classwork;

import java.util.ArrayList;
import java.util.List;

import static auxiliary.Functions.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nEnter array size");
        MyArrayClass myArray = new MyArrayClass(enterPositiveInteger());

        System.out.println(myArray);
        System.out.println("Min: " + myArray.min());
        System.out.println("Max: " + myArray.max());
        System.out.println("Average: " + myArray.average());

//        todo: find prime numbers from 1 to 100

    }
}
