import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withrawal extends Transaction
{
    private int amount;
    private final Keypad keypad;
    private final CashDispenser cashDispenser;

    private final static int CANCELED = 6;

    public Withrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser)
    {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        keypad = atmKeypad;
        cashDispenser = atmCashDispenser;

    }


    public void execute()
    {
        displayMenuOfAmounts();
    }

    public void transaction(int amount)
    {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();
        boolean cashDispensed = false;
        double availableBalance;

        availableBalance = bankDatabase.getAvailableBallance(getAccountNumber());

        if(amount <= availableBalance)
        {
            if(cashDispenser.isSufficientCashAvailable(amount)) {
                bankDatabase.debit(getAccountNumber(), amount);
               cashDispenser.dispenseCash(amount);

            }
            else //cash insuficient
                screen.messageJLabel7.setText("Not enough cash in the ATM, please try a smaller amount");
        }
        else
        {
            screen.messageJLabel7.setText("Insufficient funds in your account");
        }


    }

    private void displayMenuOfAmounts()
    {



        Screen screen = getScreen(); // get screen reference
        screen.createWithdrawGUI();
        screen.MainFrame.add( keypad.addkeypad(), BorderLayout.CENTER);
        withdraw1 check1 = new withdraw1();
        withdraw2 check2 = new withdraw2();
        withdraw3 check3 = new withdraw3();
        withdraw4 check4 = new withdraw4();
        withdraw5 check5 = new withdraw5();
        Keypad.B1.addActionListener(check1);
        Keypad.B2.addActionListener(check2);
        Keypad.B3.addActionListener(check3);
        Keypad.B4.addActionListener(check4);
        Keypad.B5.addActionListener(check5);


        screen.MainFrame.revalidate();
    }

    public class withdraw1 implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            transaction(20);
        }
    }
    public class withdraw2 implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            transaction(40);
        }
    }
    public class withdraw3 implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            transaction(60);
        }
    }
    public class withdraw4 implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            transaction(100);
        }
    }
    public class withdraw5 implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            transaction(200);
        }
    }

}

