public class SavingsAccount extends CheckingAccount {
    private double interestRate;

    public SavingsAccount() {
        super();
        interestRate = 0.02;
    }

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void calcInterest() {
        balance += balance * interestRate;
    }

    public static void main(String[] args) {
        System.out.println("Savings Account");
        new SavingsAccount().start();
    }
}
