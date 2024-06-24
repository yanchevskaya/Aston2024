package lesson_6;

import java.math.BigDecimal;

/*
Создать класс Park с внутренним классом, с помощью объектов которого можно хранить
информацию об аттракционах, времени их работы и стоимости
 */
public class Park {
    private String name;
    private Attraction[] attractions = {new Attraction("Ромашка", new BigDecimal(500), "10.00-21.00")};

    private class Attraction {
        private String name;
        private BigDecimal price;
        private String time;

        public Attraction(String name, BigDecimal price, String time) {
            this.name = name;
            this.price = price;
            this.time = time;
        }

    }
}
