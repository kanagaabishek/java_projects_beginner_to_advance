package Banking_System;

import java.io.*;
import java.util.Scanner;

public class Account {
    private static final String FILENAME = "accounts.txt";
    private int accountNumber;
    private double balance;
    Scanner sc = new Scanner(System.in);

    public void setAccountDetails(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void display() {
        System.out.println("Current Balance: " + balance);
    }

    public void deposit() throws IOException {
        System.out.println("Enter amount to deposit:");
        double amount = sc.nextDouble();
        balance += amount;
        updateAccount();
        System.out.println("Deposited successfully. New Balance: " + balance);
    }

    public void withdraw() throws IOException {
        System.out.println("Enter amount to withdraw:");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            updateAccount();
            System.out.println("Withdrawn successfully. New Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    public void transfer() throws IOException {
        System.out.println("Enter destination account number:");
        int destinationAccNo = sc.nextInt();
        System.out.println("Enter amount to transfer:");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            updateAccount();

            // Update recipient's balance
            updateRecipientBalance(destinationAccNo, amount);
            System.out.println("Transferred successfully. New Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    private void updateAccount() throws IOException {
        File temp = new File("temp.txt");
        File file = new File(FILENAME);

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int accNo = Integer.parseInt(parts[0]);
                if (accNo == accountNumber) {
                    bw.write(accNo + "," + parts[1] + "," + parts[2] + "," + balance + "\n");
                } else {
                    bw.write(line + "\n");
                }
            }
        }

        file.delete();
        temp.renameTo(file);
    }

    private void updateRecipientBalance(int destinationAccNo, double amount) throws IOException {
        File temp = new File("temp.txt");
        File file = new File(FILENAME);

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int accNo = Integer.parseInt(parts[0]);
                if (accNo == destinationAccNo) {
                    double newBalance = Double.parseDouble(parts[3]) + amount;
                    bw.write(accNo + "," + parts[1] + "," + parts[2] + "," + newBalance + "\n");
                } else {
                    bw.write(line + "\n");
                }
            }
        }

        file.delete();
        temp.renameTo(file);
    }
}
