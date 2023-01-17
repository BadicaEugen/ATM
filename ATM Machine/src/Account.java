public class Account {
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;
    private int admin;
    private String username;

    public Account(String Username, int accNumber, int thePin, double theAvailableBalance, double theTotalBalance, int isAdmin) {

    }

    public boolean validatePin(int userPin)
    {
        return userPin == getPin();
    }

    public double getAvailableBalance()
    {
        return availableBalance;
    }

    public double getTotalBalance(){
        return totalBalance;
    }

    public void credit(double amount)
    {
        setTotalBalance(getTotalBalance() + amount);
    }

    public void debit(double amoundt)
    {
        setAvailableBalance(getAvailableBalance() - amoundt);
        setTotalBalance(getTotalBalance() - amoundt);
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public int getIsAdmin()
    {
        return getAdmin();
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public int getPin()
    {
        return  pin;
    }

    public void setPin(int pin)
    {
        this.pin = pin;
    }

    public void setAvailableBalance(double availableBalance)
    {
        this.availableBalance = availableBalance;
    }

    public void setTotalBalance(double totalBalance)
    {
        this.totalBalance = totalBalance;
    }

    public int getAdmin()
    {
        return admin;
    }

    public void setAdmin(int admin)
    {
        this.admin = admin;
    }

}
