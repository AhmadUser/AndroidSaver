package com.example.saver;

public class Item {
    private double price;
    private double initialPrice;
    private double sellingPrice;
    private int quantity;
    private String barcode;
    private String companyName;
    private String privateName;

    public Item(double price, double initialPrice, double sellingPrice, int quantity, String barcode, String companyName, String privateName) {
        this.price = price;
        this.initialPrice = initialPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.barcode = barcode;
        this.companyName = companyName;
        this.privateName = privateName;
    }

    // Getters and Setters

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }
}

