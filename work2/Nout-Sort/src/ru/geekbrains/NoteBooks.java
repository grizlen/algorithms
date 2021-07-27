package ru.geekbrains;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class NoteBooks {

    public static void main(String[] args) {
        NoteBooks noteBooks = new NoteBooks(5000);
        noteBooks.printAll();
        System.out.println("Sort:");
        long time = System.currentTimeMillis();
        noteBooks.sort3();
        time = System.currentTimeMillis() - time;
        noteBooks.printAll();
        System.out.println("Time = " + time + " swap: " + noteBooks.numSwap);
    }


    private static int
        MIN_PRICE = 500,
        MAX_PRICE = 1000,
        STEP_PRICE = 100,
        MIN_MEM = 4,
        MAX_MEM = 12,
        STEP_MEM = 4;

    private NoteBook[] items;
    private int numSwap;

    public NoteBooks(int count) {
        init(count);
    }

    private void init(int count) {
        items = new NoteBook[count];
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            items[i] = new NoteBook(
                    NoteBook.BRANDS[rnd.nextInt(NoteBook.BRAND_COUNT)],
                    rnd.nextInt(((MAX_MEM - MIN_MEM) / STEP_MEM) + 1) * STEP_MEM + MIN_MEM,
                    rnd.nextInt(((MAX_PRICE - MIN_PRICE) / STEP_PRICE) + 1) * STEP_PRICE + MIN_PRICE
                    );
        }
    }

    private void printAll() {
        Arrays.stream(items).forEach(System.out::println);
    }

    private void sort1() {
        numSwap = 0;
        Arrays.sort(items, (o1, o2) -> {
            numSwap++;
            return o1.compare(o2);
        });
    }

    private void sort2() {
        numSwap = 0;
        for (int i = items.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (items[j - 1].compare(items[j]) == 1) {
                    numSwap++;
                    swap(j - 1, j);
                }
            }
        }
    }

    private void sort3() {
        numSwap = 0;
        int minI, maxI;
        int l = 0, r = items.length - 1;
        while (l < r) {
            minI = l;
            maxI = r;
            for (int i = l + 1; i < r; i++) {
                if (items[i].compare(items[minI]) == -1) {
                    minI = i;
                }
                if (items[i].compare(items[maxI]) == 1) {
                    maxI = i;
                }
            }
            if (minI != l) {
                numSwap++;
                swap(minI, l);
            }
            if (maxI != r) {
                numSwap++;
                swap(maxI, r);
            }
            l++;
            r--;
        }
    }

    private void swap(int i1, int i2) {
        NoteBook t = items[i1];
        items[i1] = items[i2];
        items[i2] = t;
    }
}
