// Main.java
package ru.netology.losev;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static final int MAX_TRANSACTIONS = 5;
    public static final int MAX_CUSTOMERS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int transactionCount = 0;

        OperationData operationData = null;

        // Десериализация данных
        try {
            FileInputStream fileIn = new FileInputStream("test.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            operationData = (OperationData) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (operationData == null) {
            operationData = new OperationData();
        }

        while (transactionCount < MAX_TRANSACTIONS) {
            Operation operation = operationData.createOperationFromConsole(scanner);
            operationData.addOperation(operation);

            System.out.println("Выберите клиента или создайте нового:");
            System.out.println("1. Выбрать существующего клиента");
            System.out.println("2. Создать нового клиента");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Введите ID клиента:");
                int customerId = scanner.nextInt();
                scanner.nextLine();

                if (customerId >= 0 && customerId < operationData.getCustomers().length && operationData.getCustomers()[customerId] != null) {
                    operationData.addStatement(customerId, operation.getId());
                } else {
                    System.out.println("Клиент с указанным ID не найден.");
                }
            } else if (choice == 2) {
                Customer newCustomer = operationData.createCustomerFromConsole(scanner);
                operationData.addCustomer(newCustomer);
                operationData.addStatement(newCustomer.getId(), operation.getId());
            }

            transactionCount++;
        }

        // Сериализация данных
        try {
            FileOutputStream fileOut = new FileOutputStream("test.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(operationData);
            out.close();
            fileOut.close();
            System.out.println("Данные успешно сохранены.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Введите ID клиента, чтобы вывести его операции:");
        int clientId = scanner.nextInt();
        scanner.nextLine();
        Operation[] clientOperations = operationData.getOperations();

        scanner.close();
    }
}
