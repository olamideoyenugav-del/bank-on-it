import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    protected double balance;
    protected static final Scanner input = new Scanner(System.in);

    public CheckingAccount() {
        this(0.0);
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String menu() {
        System.out.println("\nAccount menu");
        System.out.println("0) quit");
        System.out.println("1) check balance");
        System.out.println("2) make a deposit");
        System.out.println("3) make a withdrawal");
        System.out.print("Please enter 0-3: ");
        return input.nextLine();
    }

    private double getDouble() {
        try {
            return Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.");
            return 0;
        }
    }

    public void checkBalance() {
        System.out.println("Checking balance...");
        System.out.println("Current balance: " + getBalanceString());
    }

    public void makeDeposit() {
        System.out.println("Making a deposit...");
        System.out.print("How much to deposit? ");
        double amount = getDouble();
        if (Double.isFinite(amount) && amount > 0) {
            balance += amount;
            System.out.println("New balance: " + getBalanceString());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void makeWithdrawal() {
        System.out.println("Making a withdrawal...");
        System.out.print("How much to withdraw? ");
        double amount = getDouble();
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("New balance: " + getBalanceString());
        }
    }

    public void start() {
        String choice;
        do {
            choice = menu();
            switch (choice) {
                case "1": checkBalance(); break;
                case "2": makeDeposit(); break;
                case "3": makeWithdrawal(); break;
                case "0": break;
                default: System.out.println("Invalid choice.");
            }
        } while (!choice.equals("0"));
    }

    public static void main(String[] args) {
        new CheckingAccount().start();
    }
}
