package lesson_6;

/*
Создать класс Park с внутренним классом, с помощью объектов которого можно хранить
информацию об аттракционах, времени их работы и стоимости
 */
public class Park {

    class Attraction {
        private String name;
        private double price;
        private String time;

        public Attraction(String name, double price, String time) {
            this.name = name;
            this.price = price;
            this.time = time;
        }
    }
}

