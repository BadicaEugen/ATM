public abstract class Transaction
{

    private final int accountNumber;
    protected Screen screen;
    private final BankDatabase bankDatabase;

    public Transaction(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase)
    {
        accountNumber = userAccountNumber;
        screen = atmScreen;
        bankDatabase = atmBankDatabase;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public Screen getScreen()
    {
        return screen;
    }

    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    public void execute(){}

}
