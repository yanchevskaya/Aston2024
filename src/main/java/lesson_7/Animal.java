package lesson_7;

public abstract class Animal {
    private String name;

    //Абстрактный класс животное с абстрактными методами "бег" и "плавание"
    private static int countOfAnimal;

    // подсчёт количества созданных животных
    public Animal(String name) {
        this.name = name;
        countOfAnimal++;
    }

    public String getName() {
        return name;
    }

    public static int getCountOfAnimal() {
        return countOfAnimal;
    }

    public abstract void run(int length);

    public abstract void swim(int length);
}