package lesson_5;

import java.util.Arrays;

public class Lesson_5 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(isTrue(1, 1));
        isPositive(5);
        System.out.println(isNegative(-9));
        printWord("Wonderland", 17);
        System.out.println(ifLeapYear(1200));
        System.out.println(Arrays.toString(changeArray()));
        System.out.println(Arrays.toString(fillArray()));
        System.out.println(Arrays.toString(multiplyArray()));
        doubleArray();
        System.out.println(Arrays.toString(arrayInit(5, 10)));
    }

    /*
    Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова:
    Orange, Banana, Apple
    */

    public static void printThreeWords() {

        System.out.println("Orange\nBanana\nApple\n");

    }

    /*
    Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
    и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать
    эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение
    “Сумма положительная”, в противном случае - “Сумма отрицательная”
    */

    public static void checkSumSign() {
        int a = -56;
        int b = 73;

        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    /*
    Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте
    ее любым значением. Если value меньше 0 (0 включительно), то в консоль метод должен вывести
    сообщение “Красный”, если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно),
    то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”
     */

    public static void printColor() {
        int value;

        value = -1;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    /*
    Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
    и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
    то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”
    */

    public static void compareNumbers() {
        int a, b;

        a = 197;
        b = 339;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /*
    Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
    от 10 до 20 (включительно), если да – вернуть true, в противном случае – false
     */

    public static boolean isTrue(int a, int b) {

        return ((a + b) >= 10 && (a + b) <= 20);
    }

    /*
    Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом
     */

    public static void isPositive(int a) {

        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    /*
     Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
     если число отрицательное, и вернуть false если положительное. Замечание: ноль считаем положительным числом
     */

    public static boolean isNegative(int a) {

        return a < 0;
    }

    /*
    Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль
    указанную строку, указанное количество раз
     */

    public static void printWord(String word, int count) {

        for (int i = 0; i < count; i++) {
            System.out.println(word);
        }
    }

    /*
    Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
    не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый
    400-й – високосный
     */

    public static boolean ifLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else return year % 4 == 0 && year % 100 != 0;
    }

    /*
    Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0
     */

    public static int[] changeArray() {
        int[] array = {1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else array[i] = 0;
        }
        return array;
    }

    /*
     Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100
     */

    public static int[] fillArray() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    /*
    Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2
     */

    public static int[] multiplyArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    /*
    Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов
    равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
     */

    public static void doubleArray() {
        int[][] array = new int[10][10];
        int c = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || j == c) {
                    array[i][j] = 1;
                } else array[i][j] = 0;
            }
            c--;
        }
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /*
    Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
    типа int длиной len, каждая ячейка которого равна initialValue
     */

    public static int[] arrayInit(int len, int initialValue) {

        int[] array = new int[len];

        Arrays.fill(array, initialValue);
        return array;
    }
}



