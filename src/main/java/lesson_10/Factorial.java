package lesson_10;

public class Factorial {

    /*
    Напишите программу, позволяющую вычислить факториал числа
     */
    public long factorial(int number) {
        if (number < 0)
            throw new IllegalArgumentException("Number must be positive");

        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}

