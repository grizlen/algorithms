package ru.geekbrains.bag;

public class Item {

    private final String name;
    private final int price;
    private final int weight;

    public Item(String name, int price, int weight) {

        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{" + name + " price=" + price + " weight=" + weight + "}";
    }
}
