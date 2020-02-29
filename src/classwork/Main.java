package classwork;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static auxiliary.Functions.enterPositiveInteger;
import static auxiliary.Functions.setPrecision;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nEnter array size");
        MyArrayClass myArray = new MyArrayClass(enterPositiveInteger());

        System.out.println(myArray);
        System.out.println("Min: " + myArray.min());
        System.out.println("Max: " + myArray.max());
        System.out.println("Average: " + setPrecision(myArray.average(), 2));


        Set<Integer> primeNumbers = new LinkedHashSet<>();
        for (int i = 1; i <= 100; i++) {
            if (i != 1) {
                boolean isPrime = true;
                for (Integer prime : primeNumbers) {
                    if (i % prime == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primeNumbers.add(i);
                }
            }
        }
        System.out.println("\nPrime numbers:");
        System.out.println(primeNumbers);
    }

}
