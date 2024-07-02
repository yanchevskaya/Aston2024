package lesson_8;

public class Lesson_8 {

    /*
    Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение
    Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные
    */
    public static int sumArray(String[][] doubleArray) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;

        if (doubleArray.length != 4) throw new MyArraySizeException("Incorrect size of array (columns)");

        for (int i = 0; i < doubleArray.length; i++) {
            if (doubleArray[i].length != 4) throw new MyArraySizeException("Incorrect size of array (rows)");
            for (int j = 0; j < doubleArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(doubleArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Failed format in " + i + " array " + j + " position");
                }
            }
        }
        return sum;
    }
}
