package lesson_6;

public class Main {

    public static void main(String[] args) {

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
}
