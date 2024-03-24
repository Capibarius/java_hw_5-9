package ru.netology.losev;

import java.io.Serializable;

public class Customer implements Serializable, ConsolePrintable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double amount;

    public Customer(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
