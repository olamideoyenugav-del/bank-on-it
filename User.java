import java.io.Serializable;

public abstract class User implements HasMenu, Serializable {
    private static final long serialVersionUID = 1L;
    protected String userName;
    protected String PIN;

    public User() {
        this("", "");
    }

    public User(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getPIN() {
        return PIN;
    }

    public boolean login(String userName, String PIN) {
        return this.userName.equals(userName) && this.PIN.equals(PIN);
    }

    public boolean login() {
        System.out.print("User name: ");
        String enteredName = CheckingAccount.input.nextLine();
        System.out.print("PIN: ");
        String enteredPIN = CheckingAccount.input.nextLine();
        boolean success = login(enteredName, enteredPIN);
        System.out.println(success ? "Login Successful" : "Login Failed");
        return success;
    }

    public abstract String getReport();
}
