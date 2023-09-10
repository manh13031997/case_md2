package model;

import java.io.Serializable;

public class Book implements Serializable {
    public int id;
    public String name;
    public String author;
    public String category;
    public int amount;
    public double price;

    public Book() {
    }

    public Book(int id, String name, String author, String category, int amount, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.amount = amount;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                ", tên: " + name +
                ", tác giả: " + author +
                ", thể loại: " + category +
                        ", số lượng: " + amount +
                ", giá: " + price ;
    }
}
