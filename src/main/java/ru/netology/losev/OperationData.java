package ru.netology.losev;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class OperationData implements Serializable {
    private static final long serialVersionUID = 1L;

    private Operation[] operations;
    private Customer[] customers;
    private int[][] statement;
    private int operationCount;

    public OperationData() {
        this.operations = new Operation[Main.MAX_TRANSACTIONS];
        this.customers = new Customer[Main.MAX_CUSTOMERS];
        this.statement = new int[Main.MAX_CUSTOMERS][Main.MAX_TRANSACTIONS];
        this.operationCount = 0;
    }

    public Operation[] getOperations() {
        return operations;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public int[][] getStatement() {
        return statement;
    }

    public void addOperation(Operation operation) {
        if (operationCount < Main.MAX_TRANSACTIONS) {
            operations[operationCount++] = operation;
        }
    }

    public void addCustomer(Customer customer) {
        if (customer.getId() >= 0 && customer.getId() < Main.MAX_CUSTOMERS) {
            customers[customer.getId()] = customer;
        }
    }

    public void addStatement(int customerId, int operationId) {
        if (customerId >= 0 && customerId < Main.MAX_CUSTOMERS && operationId >= 0 && operationId < Main.MAX_TRANSACTIONS) {
            statement[customerId][operationId] = operationId + 1;
        }
    }

    public Operation createOperationFromConsole(Scanner scanner) {
        System.out.print("Введите сумму транзакции: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Транзакция является переводом? (true/false): ");
        boolean isTransfer = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Введите дату транзакции: ");
        String date = scanner.nextLine();

        return new Operation(amount, isTransfer, date);
    }

    public Customer createCustomerFromConsole(Scanner scanner) {
        System.out.print("Введите ID клиента:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        System.out.print("Введите имя клиента:");
        String name = scanner.nextLine();

        System.out.print("Введите сумму клиента:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера

        return new Customer(id, name, amount);
    }

    @Override
    public String toString() {
        return "OperationData{" +
                "operations=" + Arrays.toString(operations) +
                ", customers=" + Arrays.toString(customers) +
                ", statement=" + Arrays.deepToString(statement) +
                ", operationCount=" + operationCount +
                '}';
    }
}