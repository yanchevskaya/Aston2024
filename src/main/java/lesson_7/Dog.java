package lesson_7;

public class Dog extends Animal {

    private static int countOfDog;
    private static final int MAX_DISTANCE = 500;
    private static final int MAX_SWIM = 10;

    //в конструкторе считается количество созданных собак
    public Dog(String name) {
        super(name);
        countOfDog++;
    }

    public static int getCountOfDog() {
        return countOfDog;
    }

    //переопределение метода "бег"
    @Override
    public void run(int length) {
        if (length > MAX_DISTANCE) {
            System.out.printf("Пёс %s не способен бежать дистанции большее %d м.\n", getName(), MAX_DISTANCE);
        } else {
            System.out.printf("Пёс %s пробежал %d м\n", getName(), length);
        }
    }

    //переопределение метода "плавание"
    @Override
    public void swim(int length) {
        if (length > MAX_SWIM) {
            System.out.printf("Пёс %s не способен проплыть дистанцию большее %d м.\n", getName(), MAX_SWIM);
        } else {
            System.out.printf("Пёс %s проплыл %d м\n", getName(), length);
        }
    }
}