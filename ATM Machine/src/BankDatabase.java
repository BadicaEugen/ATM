import java.util.ArrayList;
import java.util.Objects;

public class BankDatabase
{
    static ArrayList<Account> Accounts = new ArrayList<>();


    public BankDatabase()
    {
        Account accounts1 = new Account("Customer1", 12345, 1111, 1000.0, 1200.0, 0);
        Account accounts2 = new Account("Customer2", 98765, 2222, 200.0, 200.0, 0);
        Account accounts3 = new Account("Eugen", 11111, 3333, 9999999.0, 9999999.0, 0);
        Account accounts4 = new Account("Manager1", 99999, 4444, 0, 0, 1);
        Accounts.add(accounts1);
        Accounts.add(accounts2);
        Accounts.add(accounts3);
        Accounts.add(accounts4);
    }//MINI BAZA :D

    public Account getAccount(int accountNumber)
    {
        for(Account currentAccount : Accounts) {
            if (currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        }
        return null;//daca nu exista contul returnam null
    }

    private Account getAccountpin(int PIN) {

        for (Account currentAccount : Accounts) {
            if (currentAccount.getPin() == PIN)
                return currentAccount;
        }
        return null;
    }

    public boolean authenticateUser(int userPin)
    {
        Account userAccount = getAccountpin(userPin);
        if(userAccount!=null)
            return userAccount.validatePin(userPin);
        else
            return false;

    }
    //balanta disponibila
    public double getAvailableBallance(int userAccountNumber)
    {
        return getAccount(userAccountNumber).getAvailableBalance();
    }

    //balanta totala
    public double getTotalBallance(int userAccountNumber)
    {
        return getAccount(userAccountNumber).getTotalBalance();
    }
    //creditare cont specificat
    public void credit(int userAccountNumber, double amount)
    {
        getAccount(userAccountNumber).credit(amount);
    }
    //debitare cont specificat
    public void debit(int userAccountNumber, double amount)
    {
        getAccount(userAccountNumber).debit(amount);
    }

    public int getAdmin(int userAccountNumber)
    {
        return Objects.requireNonNull(getAccountpin(userAccountNumber)).getAdmin();
    }

    public static Iterator createIterator()
    {
        return new Account_Iterator(Accounts);
    }

    public int getAccPIN(int PIN)
    {
        for(Account currentAccount : Accounts)
        {
            if(currentAccount.getPin() == PIN)
                return currentAccount.getAccountNumber();
            else return 1;
        }
        return PIN;
    }

    public static void addUser()
    {
        String name = Screen.Inputfield1.getText();
        int accountNumber = Integer.parseInt(Screen.Inputfield2.getText());
        int balance = Integer.parseInt(Screen.Inputfield3.getText());
        int pin = Integer.parseInt(Screen.Inputfield4.getText());

        Account newAccount = new Account(name, accountNumber,pin,balance,balance,0);
        Accounts.add(newAccount);

        Screen.Inputfield1.setText("");
        Screen.Inputfield2.setText("");
        Screen.Inputfield3.setText("");
        Screen.Inputfield4.setText("");


    }

    public static void deleteUser(int position)
    {
        Accounts.remove(position);
    }


}
