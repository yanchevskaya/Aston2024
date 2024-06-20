public class Cat extends Animal {
    private String name;
    private boolean fullness;
    private static int countOfCat;

    //в конструкторе считается количество созданных котов
    public Cat(String name) {
        this.name = name;
        countOfCat++;
    }

    public String getName() {
        return name;
    }
    //вовзарещение количества созданных котов
    public static int getCountOfCat(){
        return countOfCat;
    }

    public void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    public boolean isFullness() {
        return fullness;
    }
    //переопределение абстрактного метода "бег"
    @Override
    public void run(int length) {
        if (length > 200) {
            System.out.printf("Кот %s не способен бежать дистанции большее 200 м.\n", getName());
        } else {
            System.out.printf("Кот %s пробежал %d м\n", getName(), length);
        }
    }
    //переопределение абстрактного метода "плавание"
    @Override
    public void swim(int length) {
        System.out.printf("Кот %s отказывается плыть\n", getName());
    }
    //метод, позволяющий котам кушать из миски. Если еды в миске недостаточно, кот поесть не может
    public void eat(Bowl bowl, int amountOfFood){
        if (bowl.getAmountOfFood()>=amountOfFood){
            setFullness(true);
            bowl.setAmountOfFood(bowl.getAmountOfFood()-amountOfFood);
            System.out.printf("%s покушал и доволен\n", getName());
        } else {
            System.out.println("В миске недостаточно еды");
        }
    }
}
