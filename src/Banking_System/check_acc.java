package Banking_System;

import java.io.*;
import java.util.Scanner;

public class check_acc {
    private static final String FILENAME = "accounts.txt";
    private int accountNumber;
    private double balance;

    public int check() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Account Number:");
        int enteredAccNo = sc.nextInt();
        System.out.println("Enter your PIN:");
        int enteredPin = sc.nextInt();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int accNo = Integer.parseInt(parts[0]);
                int pin = Integer.parseInt(parts[2]);
                if (accNo == enteredAccNo && pin == enteredPin) {
                    this.accountNumber = accNo;
                    this.balance = Double.parseDouble(parts[3]);
                    return 1;
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
        return 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
