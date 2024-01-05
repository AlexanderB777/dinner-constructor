package ru.practicum.dinner;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu; //Hashmap с существующими в меню блюдами
    ArrayList<String> dinnerRequest; // Массив с типами блюда для запроса

    Random random = new Random();

    DinnerConstructor() {
        menu = new HashMap<>();
        dinnerRequest = new ArrayList<>();
    }

    void writeNewDish(String dishType, String dishName) { // Метод для заполнения меню
        if (menu.containsKey(dishType)) {
            menu.get(dishType).add(dishName);
        } else {
            menu.put(dishType, new ArrayList<>());
            menu.get(dishType).add(dishName);
        }
    }

    void makeRequest(String typeOfDish) { // Метод для заполнения массива с запросом
        dinnerRequest.add(typeOfDish);
    }

    String[] makeNewCombo() {
        String[] combo = new String[dinnerRequest.size()];
        for (int i = 0; i < combo.length; i++) {
            ArrayList<String> possibleDishes = menu.get(dinnerRequest.get(i));
            combo[i] = possibleDishes.get(random.nextInt(dinnerRequest.size()));
        }
        return combo;
    }
}
