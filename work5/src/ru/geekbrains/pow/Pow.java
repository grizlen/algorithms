package ru.geekbrains.pow;

public class Pow {

    public static void main(String[] args) {
        System.out.println(recPow(2, 32));
    }

    private static long recPow(long n, int p) {
        if (p < 1) {
            throw new RuntimeException("value of power must be 1 or greater.");
        }
        return p == 1 ? n : n * recPow(n, p - 1);
    }
}
