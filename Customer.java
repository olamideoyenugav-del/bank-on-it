public class Customer extends User {
    private static final long serialVersionUID = 1L;
    private CheckingAccount checking;
    private SavingsAccount savings;

    public Customer() {
        this("Alice", "0000");
    }

    public Customer(String userName, String PIN) {
        super(userName, PIN);
        checking = new CheckingAccount();
        savings = new SavingsAccount();
    }

    public String menu() {
        System.out.println("\nCustomer Menu");
        System.out.println("0) Exit");
        System.out.println("1) Manage Checking Account");
        System.out.println("2) Manage Savings Account");
        System.out.println("3) change PIN");
        System.out.print("Action (0-3): ");
        return CheckingAccount.input.nextLine();
    }

    public void changePin() {
        System.out.print("Enter current PIN: ");
        String oldPIN = CheckingAccount.input.nextLine();
        if (!oldPIN.equals(getPIN())) {
            System.out.println("Incorrect PIN.");
            return;
        }
        System.out.print("Enter new PIN: ");
        String newPIN = CheckingAccount.input.nextLine();
        if (newPIN.isEmpty()) {
            System.out.println("PIN cannot be empty.");
        } else {
            setPIN(newPIN);
            System.out.println("PIN changed successfully.");
        }
    }

    public String getReport() {
        return "Customer: " + getUserName()
            + "\nChecking: " + checking.getBalanceString()
            + "\nSavings: " + savings.getBalanceString();
    }

    public void start() {
        if (!login()) return;
        String choice;
        do {
            choice = menu();
            switch (choice) {
                case "1":
                    System.out.println("\nChecking Account");
                    checking.start();
                    break;
                case "2":
                    System.out.println("\nSavings Account");
                    savings.start();
                    break;
                case "3": changePin(); break;
                case "0": System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (!choice.equals("0"));
    }

    public static void main(String[] args) {
        new Customer().start();
    }
}
