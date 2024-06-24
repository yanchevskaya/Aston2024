import lesson_6.Employee;
import lesson_6.Park;

import java.math.BigDecimal;
import java.util.Arrays;
import static lesson_5.Lesson_5.*;

public class Main {

    public static void main(String[] args) {

        //Lesson 6
        // Создать массив из 5 сотрудников

        Employee[] empArray = new Employee[5];

        empArray[0] = new Employee("Mark Avrelii", "Manager", "markavrelii@gmail.com",
                "+79118749383", 100000, 40);
        empArray[1] = new Employee("Petr Ivanov", "Engineer", "petrivanov@gmail.com",
                "+79217894567", 300000, 45);
        empArray[2] = new Employee("Fiodor Petrov", "Engineer", "fiodorpetrov@gmail.com",
                "+79997864098", 350000, 47);
        empArray[3] = new Employee("Anna Shtein", "Business analyst", "annashtein@gmail.com",
                "+79217897765", 370000, 35);
        empArray[4] = new Employee("Maria Vebber", "Engineer", "mariavebber@gmail.com",
                "+79117869877", 250000, 30);


    }

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

