package ru.netology.losev;

import java.io.Serializable;

public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int counter = 0;

    private int id;
    private double amount;
    private boolean isTransfer;
    private String date;

    public Operation(double amount, boolean isTransfer, String date) {
        this.id = ++counter;
        this.amount = amount;
        this.isTransfer = isTransfer;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isTransfer() {
        return isTransfer;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", amount=" + amount +
                ", isTransfer=" + isTransfer +
                ", date='" + date + '\'' +
                '}';
    }
}