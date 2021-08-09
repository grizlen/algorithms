package ru.geekbrains;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Pt3ExtQue<T> {
    public static void main(String[] args) {
        Pt3ExtQue<Integer> que = new Pt3ExtQue<>(Integer.class);
        que.put(10);
        que.put(15);
        que.info("get = " + que.get());
        que.info("get = " + que.get());
        que.put(20);
        que.put(25);
        que.put(30);
        que.info("get = " + que.get());
        que.info("get = " + que.get());
        que.info("get = " + que.get());
        que.info("get = " + que.get());
        que.put(35);
        que.put(40);
    }

    private final int CAP_STEP = 2;
    private final Class<T> itemClass;
    private int count;
    private int capacity;
    private int writePos;
    private int readPos;
    private T[] items;

    public Pt3ExtQue(Class<T> itemClass) {
        this.itemClass = itemClass;
        count = 0;
        capacity = 0;
        items = (T[]) Array.newInstance(itemClass, capacity);
        writePos = 0;
        readPos = 0;
        optimize();
    }

    private void optimize() {
        int newCap = count / CAP_STEP * CAP_STEP + CAP_STEP;
        if (newCap != capacity) {
            T[] tmp = (T[]) Array.newInstance(itemClass, count);
            System.arraycopy(items, readPos, tmp, 0, count);
            items = (T[]) Array.newInstance(itemClass, newCap);
            writePos = count;
            readPos = 0;
            System.arraycopy(tmp, 0, items, 0, count);
            capacity = newCap;
            info("optimize");
        } else if (count == 0) {
            readPos = writePos = 0;
        }
    }

    private void info(String msg) {
        if (!msg.isBlank()) {
            System.out.println(msg + ":");
        }
        System.out.printf("Capacity: %d; Count: %d; Write: %d; Read: %d\n", capacity, count, writePos, readPos);
        System.out.println(Arrays.toString(items));
    }

    public void put(T value) {
        if (writePos > capacity - 1) {
            optimize();
        }
        count++;
        items[writePos++] = value;
        info("put " + value);
    }

    public T get() {
        if (count == 0) {
            return null;
        }
        count--;
        return items[readPos++];
    }
}
