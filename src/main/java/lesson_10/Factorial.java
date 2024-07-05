package lesson_10;

import java.math.BigInteger;

public class Factorial {

    /*
    Напишите программу, позволяющую вычислить факториал числа
     */
    public static BigInteger factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("Number must be positive");

        else if (number <= 1) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(number).multiply(factorial(number - 1));
        }

    }
}

