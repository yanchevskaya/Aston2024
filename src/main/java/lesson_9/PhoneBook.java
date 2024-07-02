package lesson_9;

import java.util.ArrayList;
import java.util.TreeMap;

public class PhoneBook {
    /*
   Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
   В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать
   номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
   тогда при запросе такой фамилии должны выводиться все телефоны.
    */
    private TreeMap<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new TreeMap<>();
    }

    public void add(String name, String phoneNumber) {

        if (!phoneBook.containsKey(name)) {
            ArrayList<String> list = new ArrayList<>();
            list.add(phoneNumber);
            phoneBook.put(name, list);
        } else phoneBook.get(name).add(phoneNumber);
    }

    public ArrayList<String> get(String name) {
        return phoneBook.get(name);
    }
}
