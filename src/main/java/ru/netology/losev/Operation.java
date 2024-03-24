package ru.netology.losev;
class Operation implements ConsolePrintable {
    private static int counter = 0;

    private int id;
    private double amount;
    private boolean isTransfer;
    private String date;

    public Operation() {
        this.id = ++counter;
    }

    public Operation(double amount, boolean isTransfer, String date) {
        this.id = ++counter;
        this.amount = amount;
        this.isTransfer = isTransfer;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isTransfer() {
        return isTransfer;
    }

    public void setTransfer(boolean transfer) {
        isTransfer = transfer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void print() {
        System.out.println("Operation ID: " + id);
        System.out.println("Amount: " + amount);
        System.out.println("Is transfer: " + isTransfer);
        System.out.println("Date: " + date);
    }
}