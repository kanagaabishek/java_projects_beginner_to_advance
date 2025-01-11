package Banking_System;

import java.io.*;
import java.util.Scanner;

public class create_acc {
    private static final String FILENAME = "accounts.txt";
    Scanner sc = new Scanner(System.in);

    public void create_acc() throws IOException {
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Set your PIN:");
        int pin = sc.nextInt();
        int accountNumber = generateUniqueAccountNumber();

        try (BufferedWriter br = new BufferedWriter(new FileWriter(FILENAME, true))) {
            br.write(accountNumber + "," + name + "," + pin + ",0.0\n");
            System.out.println("Account created successfully!");
            System.out.println("Your Account Number: " + accountNumber);
        } catch (IOException e) {
            System.out.println("Error while creating account: " + e.getMessage());
        }
    }

    private static int generateUniqueAccountNumber() throws IOException {
        int accountNumber = 100000;
        File file = new File(FILENAME);
        if (!file.exists()) return accountNumber;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                accountNumber = Math.max(accountNumber, Integer.parseInt(parts[0]) + 1);
            }
        }
        return accountNumber;
    }
}
