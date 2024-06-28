package lesson_8;

public class Lesson_8 {

    public static void main(String[] args) {

        String[][] firstArray = {{"4", "73", "76", "55"}, {"Winter", "Spring", "Summer", "Autumn"},
                {"December", "January", "February", "13"}, {"March", "April", "May", "75"}};

        String[][] secondArray = {{"34", "87", "90", "67"}, {"987", "108", "-678", "167"},
                {"304", "837", "900", "627"}, {"555", "777", "999", "666"}};

        String[][] thirdArray = {{"34", "87", "90", "67"}, {"987", "108", "-678", "167"},
                {"304", "837", "627"}, {"555", "777", "999", "666"}};

        String[][] forthArray = {{"987", "108", "-678", "167"},
                {"304", "837", "900", "627"}, {"555", "777", "999", "666"}};

        try {
            System.out.println(sumArray(firstArray));
        } catch (MyArraySizeException | MyArrayDataExeption e) {
            System.out.println(e);
        }

        try {
            System.out.println(sumArray(secondArray));
        } catch (MyArraySizeException | MyArrayDataExeption e) {
            System.out.println(e);
        }

        try {
            System.out.println(sumArray(thirdArray));
        } catch (MyArraySizeException | MyArrayDataExeption e) {
            System.out.println(e);
        }

        try {
            System.out.println(sumArray(forthArray));
        } catch (MyArraySizeException | MyArrayDataExeption e) {
            System.out.println(e);
        }


    }

    public static int sumArray(String[][] doubleArray) {
        int sum = 0;

        if (doubleArray.length != 4) throw new MyArraySizeException("Incorrect size of array (columns)");
        for (int i = 0; i < doubleArray.length; i++) {
            if (doubleArray[i].length != 4) throw new MyArraySizeException("Incorrect size of array (rows)");
            for (int j = 0; j < doubleArray[i].length; j++) {
                 // 1 вариант
            //    if (!doubleArray[i][j].matches("-?\\d+")) throw new MyArrayDataExeption(i + 1, j + 1);

                // 2 вариант
                try {
                    sum += Integer.parseInt(doubleArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataExeption(i + 1, j + 1);
                }
            }
        }
        return sum;
    }
}
