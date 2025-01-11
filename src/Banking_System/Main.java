package Banking_System;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileUtility.clearFile("accounts.txt");
        System.out.println("Welcome to Banking System");
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    create_acc account = new create_acc();
                    account.create_acc();
                    break;
                case 2:
                    check_acc acc = new check_acc();
                    int result = acc.check();
                    if (result == 1) {
                        Account acc1 = new Account();
                        acc1.setAccountDetails(acc.getAccountNumber(), acc.getBalance());
                        int choice2;
                        do {
                            System.out.println("1. Show Balance");
                            System.out.println("2. Deposit");
                            System.out.println("3. Withdraw");
                            System.out.println("4. Transfer");
                            System.out.println("5. Logout");
                            choice2 = sc.nextInt();
                            switch (choice2) {
                                case 1:
                                    acc1.display();
                                    break;
                                case 2:
                                    acc1.deposit();
                                    break;
                                case 3:
                                    acc1.withdraw();
                                    break;
                                case 4:
                                    acc1.transfer();
                                    break;
                                case 5:
                                    System.out.println("Logged out.");
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                            }
                        } while (choice2 != 5);
                    } else {
                        System.out.println("Invalid Account Number or PIN.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Banking System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }
}
