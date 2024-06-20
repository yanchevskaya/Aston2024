public class Main {
    public static void main(String[] args) {
        Cat finch = new Cat("Finch");
        Cat barsik = new Cat("Barsik");
        Cat aristotel = new Cat("Aristotel");
        Cat matilda = new Cat("Matilda");
        Cat afina = new Cat ("Afina");
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

}

