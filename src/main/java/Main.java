import lesson_8.MyArrayDataException;
import lesson_8.MyArraySizeException;

import static lesson_8.Lesson_8.sumArray;

public class Main {

    public static void main(String[] args) {

        /*
        В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
        и MyArrayDataException и вывести результат расчета
         */

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
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println(sumArray(secondArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println(sumArray(thirdArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println(sumArray(forthArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

    }

    //Lesson 6
    // Создать массив из 5 сотрудников
    /*
    Employee[] empArray = new Employee[5];

    empArray[0]=new

    Employee("Mark Avrelii","Manager","markavrelii@gmail.com",
                     "+79118749383",100000,40);

    empArray[1]=new

    Employee("Petr Ivanov","Engineer","petrivanov@gmail.com",
                     "+79217894567",300000,45);

    empArray[2]=new

    Employee("Fiodor Petrov","Engineer","fiodorpetrov@gmail.com",
                     "+79997864098",350000,47);

    empArray[3]=new

    Employee("Anna Shtein","Business analyst","annashtein@gmail.com",
                     "+79217897765",370000,35);

    empArray[4]=new

    Employee("Maria Vebber","Engineer","mariavebber@gmail.com",
                     "+79117869877",250000,30);


}

     */

// Lesson 5
        /*
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
         */
}

