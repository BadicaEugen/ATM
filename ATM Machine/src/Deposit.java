public class Deposit extends Transaction
{

    private double amount; // amount to deposit
    private final static int CANCELED = 0; // constant for cancel option

    // Deposit constructor
    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot)
    {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        // reference to keypad
        // reference to deposit slot
    } // end Deposit constructor


}
