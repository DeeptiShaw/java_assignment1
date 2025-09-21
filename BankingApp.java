import java.util.Scanner;

class Account {
    private int accountNumber;
    private String accountHolderName;
    private String phoneNumber;
    private String email;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double balance, String phoneNumber, String email) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully. Current Balance: " + balance);
        } else {
            System.out.println("Invalid amount. Deposit must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal successful. Current Balance: " + balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid amount. Withdrawal must be positive.");
        }
    }

    public void updateContactDetails(String phoneNumber,String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        System.out.println("Contact details updated successfully.");
    }
}

class UserInterface {
    private Account[] accounts;
    private int accountCount;
    private Scanner sc;

    public UserInterface(int size) {
        accounts = new Account[size];
        accountCount = 0;
        sc = new Scanner(System.in);
    }

    private Account findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public void createAccount() {
        if (accountCount >= accounts.length) {
            System.out.println("Account limit reached. Cannot create more accounts.");
            return;
        }

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double balance = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        System.out.print("Enter email address: ");
        String email = sc.nextLine();


        int accNumber = 12345678 + accountCount + 1;
        accounts[accountCount++] = new Account(accNumber, name, balance, phone, email);

        System.out.println("Account created successfully with Account Number: " + accNumber);
    }

    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void updateContact() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter new email: ");
            String email = sc.nextLine();
            System.out.print("Enter new phone number: ");
            String phone = sc.nextLine();
            acc.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void performDeposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\n--- Banking App Menu ---");
            System.out.println("1. Create a new account");
            System.out.println("2. View account details");
            System.out.println("3. Update contact details");
            System.out.println("4. Deposit money");
            System.out.println("5. Withdraw money");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: showAccountDetails(); break;
                case 3: updateContact(); break;
                case 4: performDeposit(); break;
                case 5: performWithdrawal(); break;
                case 6: System.out.println("Exiting application. Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }
}

public class BankingApp {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface(100); // can store up to 100 accounts
        ui.mainMenu();
    }
}
