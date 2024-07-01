package lesson_9;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson_9 {

    public static void main(String[] args) {

        /*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
          Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)
         */

        ArrayList<String> list = new ArrayList<>(Arrays.asList("небо", "ворона", "радуга", "день", "земля",
                "вода", "небо", "ананас", "апельсин", "виноград", "изумруд", "виноград", "радуга", "чайка",
                "чайка", "книга", "машина", "самолёт", "танец", "самолёт"));

        HashSet<String> set = new HashSet<>(list);
        System.out.println(set);

        for (String one : set){
            System.out.println(one + ": " + Collections.frequency(list, one));
        }

        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Ianchevskaia", "+79111411913");
        myPhoneBook.add("Ianchevskaia", "+79111416787");
        myPhoneBook.add("Morozova", "+79139871913");
        myPhoneBook.add("Morozova", "+79139871813");

        HashMap<String, String> phoneBook = new HashMap<>();

        phoneBook.put("+79111", "She");
        System.out.println(phoneBook.get("She"));
        System.out.println(phoneBook.get("+79111"));


        System.out.println(myPhoneBook.get("Morozova"));
        System.out.println(myPhoneBook.get("Ianchevskaia"));


    }


}
