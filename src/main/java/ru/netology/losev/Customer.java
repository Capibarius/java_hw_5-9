package ru.netology.losev;
class Customer {
    private int id;
    private String name;
    private double amount;

    public Customer() {}

    public Customer(int id, String name, double amount) {
        this.id = id;
        this.name = name;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static void getOperations(int clientId, Operation[] operations, int[][] statement) {
        System.out.println("Операции клиента с ID " + clientId + ":");
        int[] clientTransactions = statement[clientId];
        for (int i = 0; i < clientTransactions.length; i++) {
            int operationId = clientTransactions[i];
            operations[operationId - 1].print();
        }
    }
}