public abstract class Animal {

    //Абстрактный класс животное с абстрактными методами "бег" и "плавание"
    private static int countOfAnimal;
    // подсчёт количества созданных животных
    public Animal(){
        countOfAnimal++;
    }
    //возвращение значения количества созданных животных
    public static int getCountOfAnimal(){
        return countOfAnimal;
    }
    public abstract void run(int length);

    public abstract void swim (int length);
}
