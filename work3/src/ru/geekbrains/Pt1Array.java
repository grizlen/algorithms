package ru.geekbrains;

import java.util.Random;

public class Pt1Array {

    private final int[] items;

    public static void main(String[] args) {
        new Pt1Array(5).print();
}

    public Pt1Array(int count) {
        if (count < 1) {
            count = 1;
        }
        items = new int[count - 1];
        int missing = new Random().nextInt(count);
        for (int i = 0; i < items.length; i++){
            items[i] = i < missing ? i + 1 : i + 2;
        }
    }

    private int findMissing() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != i + 1) return i + 1;
        }
        return items.length + 1;
    }

    private void print() {
        if (items.length == 0) {
            System.out.println("[] => 1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            sb.append(items[i]);
            if (i < items.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" => " + findMissing());
        System.out.println(sb);
    }
}
