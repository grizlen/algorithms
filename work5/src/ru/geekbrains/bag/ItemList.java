package ru.geekbrains.bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ItemList {
    private ArrayList<Item> items;

    public ItemList() {
        items = new ArrayList<>();
    }

    public ItemList(Item... array) {
        items = new ArrayList<>(Arrays.asList(array));
    }


    public void add(Item item) {
        items.add(item);
    }

    public int weight() {
        return items.stream().collect(Collectors.summingInt(Item::getWeight));
    }

    public int price() {
        return items.stream().collect(Collectors.summingInt(Item::getPrice));
    }

    @Override
    public String toString() {
        return items.stream().map(Item::toString).collect(Collectors.joining(", ", "[", "]"));
    }
}
