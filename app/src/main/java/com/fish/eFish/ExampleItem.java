package com.fish.eFish;

public class ExampleItem {
    private int quantity;
    private String name;
    private String price;

    public ExampleItem(int stock, String text1, String text2) {
        quantity = stock;
        name = text1;
        price = text2;
    }

    public int getImageResource() {
        return quantity;
    }

    public String getText1() {
        return name;
    }

    public String getText2() {
        return price;
    }
}
