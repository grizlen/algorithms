package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        LinkHashMap<Product, Integer> map = new LinkHashMap(10);
        map.put(new Product(1, "Хлеб"), 30);
        map.put(new Product(2, "Макароны"), 130);
        map.put(new Product(3, "Сыр"), 230);
        map.put(new Product(4, "Масло"), 100);
        map.put(new Product(5, "Колбаса"), 150);
        map.put(new Product(6, "Сахар"), 50);
        map.put(new Product(7, "Чай"), 100);
        map.put(new Product(8, "Кофе"), 200);
        map.put(new Product(9, "Молоко"), 50);
        map.display();

        System.out.println(map.get(new Product(8, "Кофе")));

        map.remove(new Product(2, "Макароны"));
        map.remove(new Product(8, "Кофе"));
        map.remove(new Product(3, "Сыр"));
        map.display();
    }
}
