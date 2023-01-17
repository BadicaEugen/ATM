public class AccountFactory extends Account{

    public AccountFactory (String Username, int accNumber, int thePin, double theAvailableBalance, double theTotalBalance, int isAdmin)
    {
        super(Username, accNumber, thePin, theAvailableBalance, theTotalBalance, isAdmin);
        setUsername(Username);
        setAccountNumber(accNumber);
        setPin(thePin);
        setAvailableBalance(theAvailableBalance);
        setTotalBalance(theTotalBalance);
        setAdmin(isAdmin);
    }

}
