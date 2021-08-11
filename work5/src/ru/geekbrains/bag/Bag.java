package ru.geekbrains.bag;

import java.util.Arrays;

public class Bag {
    public static void main(String[] args) {
        Item[] allItems = new Item[]{
                new Item("Золотая гиря", 2000000, 5),
                new Item("ноутбук", 30000, 3),
                new Item("телевизор", 50000, 4),
                new Item("укулеле", 2000, 1)
        };
//        variant 1
        Bag bag = new Bag(5);
        System.out.println("предметы:");
        Arrays.stream(allItems).forEach(System.out::println);
        System.out.println("варианты:");
        for (int i = 0; i < allItems.length; i++) {
            ItemList set = new ItemList(allItems[i]);
            for (int o = i + 1; o < allItems.length; o++) {
                if (set.weight() + allItems[o].getWeight() <= bag.maxWeight) {
                    set.add(allItems[o]);
                }
            }
            System.out.println(set);
            bag.bestSet(set);
        }
        System.out.println(bag);

//        variant 2
        System.out.println("variant 2");
        bag = new Bag(5);
        bag.select(0, allItems);
        System.out.println(bag);
    }

    private final int maxWeight;

    private ItemList items;

    public Bag(int maxWeight) {
        this.maxWeight = maxWeight;
        items = new ItemList();
    }

    private void bestSet(ItemList list) {
        if (list.price() > items.price()) {
            items = list;
        }
    }

    @Override
    public String toString() {
        return String.format("вес: %d\nстоимость: %d\nпредметы:\n%s", items.weight(), items.price(), items);
    }

    public void select(int index, Item[] array) {
        if (index > array.length - 1) {
            return;
        }
        ItemList list = new ItemList(array[index]);
        for (int i = index + 1; i < array.length; i++) {
            if (list.weight() + array[i].getWeight() <= maxWeight) {
                list.add(array[i]);
            }
        }
        System.out.println(list);
        bestSet(list);
        select(index + 1, array);
    }
}
