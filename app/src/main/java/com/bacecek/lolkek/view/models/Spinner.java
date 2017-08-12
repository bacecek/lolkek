package com.bacecek.lolkek.view.models;

public class Spinner {

    private int price;
    private int coeff;
    private int count;

    public Spinner(int price, int coeff, int count) {
        this.price = price;
        this.coeff = coeff;
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
