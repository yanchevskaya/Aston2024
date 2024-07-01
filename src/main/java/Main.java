import lesson_6.*;
import lesson_7.*;


import java.math.BigDecimal;
import java.util.Arrays;

import static lesson_5.Lesson_5.*;

public class Main {

    public static void main(String[] args) {

        //Lesson 7

        Cat finch = new Cat("Finch");
        Cat barsik = new Cat("Barsik");
        Cat aristotel = new Cat("Aristotel");
        Cat matilda = new Cat("Matilda");
        Cat afina = new Cat("Afina");
        Cat leo = new Cat("Leo");

        Cat[] cats = {finch, barsik, aristotel, afina, matilda, leo};

        Animal polkan = new Dog("Polkan");

        finch.run(200);
        polkan.swim(10);
        finch.run(300);
        finch.swim(20);
        polkan.run(600);

        System.out.println(Animal.getCountOfAnimal());
        System.out.println(Cat.getCountOfCat());
        System.out.println(Dog.getCountOfDog());

        Bowl bowlOne = new Bowl(10);

        finch.eat(bowlOne, 15);
        System.out.println(finch.isFullness());

        bowlOne.addFood(20);
        finch.eat(bowlOne, 15);
        System.out.println(finch.isFullness());
        System.out.println(bowlOne.getAmountOfFood());

        bowlOne.addFood(40);
        for (Cat any : cats) {
            any.eat(bowlOne, 10);
        }

        for (Cat cat : cats) {
            System.out.println(cat.isFullness());
        }

        System.out.println(bowlOne.getAmountOfFood());

        Circle circle = new Circle(10, "green", "indigo");
        Triangle triangle = new Triangle(10, 10, 10, "red", "orange");
        Rectangle rectangle = new Rectangle(19, 40, "blue", "darkblue");

        rectangle.print();
        triangle.print();
        circle.print();
    }


//Lesson 6
        /*
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

