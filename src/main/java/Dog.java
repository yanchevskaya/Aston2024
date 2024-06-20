public class Dog extends Animal {

    private String name;
    private static int countOfDog;
    //в конструкторе считается количество созданных собак
    public Dog(String name) {
        this.name = name;
        countOfDog++;
    }

    public String getName() {
        return name;
    }
    //возвращение количества созданных собак
    public static int getCountOfDog(){
        return countOfDog;
    }
    //переопределение метода "бег"
    @Override
    public void run(int length) {
        if (length > 500) {
            System.out.printf("Пёс %s не способен бежать дистанции большее 500 м.\n", getName());
        } else {
            System.out.printf("Пёс %s пробежал %d м\n", getName(), length);
        }
    }
    //переопределение метода "плавание"
    @Override
    public void swim(int length) {
        if (length > 10) {
            System.out.printf("Пёс %s не способен проплыть дистанцию большее 10 м.\n", getName());
        } else {
            System.out.printf("Пёс %s проплыл %d м\n", getName(), length);
        }
    }
}

