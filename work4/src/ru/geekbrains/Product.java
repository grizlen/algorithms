package ru.geekbrains;

public class Product {

    private String title;
    private float price;

    public Product(String title, float price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("title: %s, price: %.2f", title, price);
    }
}
