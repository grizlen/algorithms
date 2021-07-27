package ru.geekbrains;

public class NoteBook {

    public static int BRAND_COUNT = 5;
    public static String[] BRANDS = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};

    private static int brandId(String name) {
        for (int i = 0; i < BRAND_COUNT; i++) {
            if (BRANDS[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    private final String brand;
    private final int memory;
    private final int price;

    public NoteBook(String brand, int memory, int price) {
        this.brand = brand;
        this.memory = memory;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("NoteBook{brand='%s', memory=%d, price=%d}", brand, memory, price);
    }

    public int compare(NoteBook n) {
        int result = price - n.price;
        if (result == 0) {
            result = memory - n.memory;
        }
        if (result == 0) {
            result = brandId(brand) - brandId(n.brand);
        }
        return result < 0 ? -1 : result > 0? 1 : 0;
    }
}
