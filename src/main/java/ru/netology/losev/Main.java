package ru.netology.losev;

import java.util.Scanner;

public class Main {
    public static final int MAX_TRANSACTIONS = 5;
    public static final int MAX_CUSTOMERS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int transactionCount = 0;

        Operation[] operations = new Operation[MAX_TRANSACTIONS];
        Customer[] customers = new Customer[MAX_CUSTOMERS];
        int[][] statement = new int[MAX_CUSTOMERS][MAX_TRANSACTIONS];

        while (transactionCount < MAX_TRANSACTIONS) {
            operations[transactionCount] = createOperationFromConsole(scanner);

            System.out.println("Выберите клиента или создайте нового:");
            System.out.println("1. Выбрать существующего клиента");
            System.out.println("2. Создать нового клиента");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Введите ID клиента:");
                int customerId = scanner.nextInt();
                scanner.nextLine();

                if (customerId >= 0 && customerId < customers.length && customers[customerId] != null) {
                    statement[customerId][transactionCount] = operations[transactionCount].getId();
                } else {
                    System.out.println("Клиент с указанным ID не найден.");
                }
            } else if (choice == 2) {
                Customer newCustomer = createCustomerFromConsole(scanner);
                customers[newCustomer.getId()] = newCustomer;
                statement[newCustomer.getId()][transactionCount] = operations[transactionCount].getId();
            }

            transactionCount++;
        }

        // Вывод операций клиента
        System.out.println("Введите ID клиента, чтобы вывести его операции:");
        int clientId = scanner.nextInt();
        scanner.nextLine();
        Customer.getOperations(clientId, operations, statement);

        scanner.close();
    }

    public static Operation createOperationFromConsole(Scanner scanner) {
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

    public static Customer createCustomerFromConsole(Scanner scanner) {
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
}
