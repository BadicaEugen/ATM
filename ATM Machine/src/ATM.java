import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM {

    private int currentAccountNumber;
    private boolean userAuthenticated;
    private final Screen screen;
    private final Keypad keypad;
    private final CashDispenser cashDispenser;
    private final DepositSlot depositSlot;
    private final BankDatabase bankDatabase;
    private String userinput = "";
    private int position = 0;
    private static ATM uniqueinstance;
    Iterator Users = BankDatabase.createIterator();

    //optiuni din meniul principal
    private static final int BALANCE_INQUIRE = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    public ATM()
    {
        userAuthenticated = false;
        currentAccountNumber = 0;
        screen = new Screen();
        keypad = new Keypad();
        cashDispenser = new CashDispenser();
        depositSlot = new DepositSlot();
        bankDatabase = new BankDatabase();
    }

    public void run()
    {
        startlogin();
    }

    void startlogin ()
    {
        position = 0;
        screen.createLogin();
        userinput = "";

        authenticate check = new authenticate();
        screen.MainFrame.revalidate();
        Screen.Inputfield2.setText("");
        keypad.setbuttons();
        addkeypadlisteners();

        screen.MainFrame.add( keypad.addkeypad(), BorderLayout.CENTER);

        screen.MainFrame.revalidate();
        keypad.BEnter.addActionListener( check );
        screen.MainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        screen.MainFrame.setSize( 400, 300 ); // set frame size
        screen.MainFrame.setResizable(false);
        screen.MainFrame.setVisible( true );
        screen.MainFrame.revalidate();

    }

    public void authenticateuser(int pin){
        userAuthenticated = bankDatabase.authenticateUser(pin);

        // check whether authentication succeeded
        if (userAuthenticated)
        {
            int accountNumber = bankDatabase.getAccPIN(pin);
            int adminCheck = bankDatabase.getAdmin(pin);
            if (adminCheck == 0){
                currentAccountNumber = accountNumber;
                screen.MainFrame.getContentPane().removeAll();
                screen.MainFrame.revalidate();
                createmenu();
                screen.MainFrame.add( keypad.addkeypad(), BorderLayout.CENTER);
                screen.MainFrame.revalidate();
            }

            else

                createAdminGUI();
            Addcheck check = new Addcheck();
            Deletecheck check2 = new Deletecheck();
            screen.button2.addActionListener(check);
            screen.button3.addActionListener(check2);

            //currentAccountNumber = accountNumber; // save user's account #

        } // end if
        else
            screen.messageJLabel3.setText("Invalid account number or PIN. Please try again.");
    }


    private class authenticate implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {

            //int accnum = Integer.parseInt( screen.Inputfield1.getText() );
            int PIN = Integer.parseInt( Screen.Inputfield2.getText() );
            //Get the PIN from the GUI text field.
            authenticateuser(PIN);
        }
    }

    private static class Addcheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            //Action Listener for adding user.
            BankDatabase.addUser();

        }
    }
    private class Deletecheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            //Action Listener for deleting a user.
            BankDatabase.deleteUser(position);
            position = position - 1;

        }
    }

    public void createmenu(){
        screen.setSize( 300, 150 );
        balancecheck check1 = new balancecheck();
        Depositcheck check2 = new Depositcheck();
        Withdrawcheck check3 = new Withdrawcheck();
        Exitcheck check4 = new Exitcheck();
        screen.MainFrame.getContentPane().removeAll();
        screen.MainFrame.revalidate();
        //Add the keypad panel to the GUI
        screen.MainFrame.add( keypad.addkeypad(), BorderLayout.CENTER);
        screen.createMenu();
        Account Account1 = bankDatabase.getAccount(currentAccountNumber);
        screen.messageJLabel1.setText("Welcome " +"                                                                                   ");

        Keypad.B1.addActionListener( check1 );
        Keypad.B2.addActionListener(check3);
        Keypad.B3.addActionListener(check2);
        Keypad.B4.addActionListener(check4);
        screen.MainFrame.revalidate();
    }


    private class balancecheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            userinput = "";
            performTransactions(1);
        }
    }

    private class Depositcheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            userinput = "";
            performTransactions(3);
        }
    }

    private class Withdrawcheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            userinput = "";
            performTransactions(2);
        }
    }

    private class Exitcheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            startlogin();
        }
    }


    private void performTransactions(int a)
    {

        // local variable to store transaction currently being processed
        Transaction currentTransaction;


        currentTransaction = createTransaction(a);
        keypad.setbuttons();
        addkeypadlisteners();


        userinput = "";
        Screen.Inputfield2.setText(userinput);
        currentTransaction.execute();




        Backcheck Back = new Backcheck();
        screen.Exit.addActionListener(Back);
        screen.MainFrame.revalidate();

    }

    public class Backcheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            //This takes the user back to the main menu.


            createmenu();
            screen.MainFrame.add( keypad.addkeypad(), BorderLayout.CENTER);
            screen.MainFrame.revalidate();
            userinput="";
            Screen.Inputfield2.setText(userinput);
        }
    }

    private Transaction createTransaction(int type)
    {
        Transaction temp = null; // temporary Transaction variable
        screen.getContentPane().removeAll();
        screen.revalidate();

        // determine which type of Transaction to create

        if(type == 1) // create new BalanceInquiry transaction
            temp = new BalanceInquiry(
                    currentAccountNumber, screen, bankDatabase);
        else if(type == 2)// create new Withdrawal transaction
            temp = new Withrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
        else if(type == 3)
        { // create new Deposit transaction
            screen.setSize( 400, 250 );
            temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);}
        // end switch

        return temp;
    }

    public void createAdminGUI(){

        screen.MainFrame.getContentPane().removeAll();
        Nextcheck Ncheck = new Nextcheck();
        Prevcheck Pcheck = new Prevcheck();
        Exitcheck check4 = new Exitcheck();
        screen.MainFrame.revalidate();
        screen.CreateAdminPage();
        screen.button1.addActionListener(Ncheck);
        screen.button4.addActionListener(Pcheck);
        screen.Exit.addActionListener(check4);
        screen.MainFrame.revalidate();

    }


    public void addkeypadlisteners(){
        BCheck BC = new BCheck();
        BClear BC1 = new BClear();
        Keypad.B1.addActionListener(BC);
        Keypad.B2.addActionListener(BC);
        Keypad.B3.addActionListener(BC);
        Keypad.B4.addActionListener(BC);
        Keypad.B5.addActionListener(BC);
        keypad.B6.addActionListener(BC);
        keypad.B7.addActionListener(BC);
        keypad.B8.addActionListener(BC);
        keypad.B9.addActionListener(BC);
        keypad.B0.addActionListener(BC);
        keypad.BClear.addActionListener(BC1);
    }

    public class BCheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            JButton b = (JButton)e.getSource();
            String label = b.getText();
            userinput = userinput + label;
            //update the text field using the user's input.
            Screen.Inputfield2.setText(userinput);

        }
    }
    public class BClear implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            userinput = "";
            Screen.Inputfield2.setText(userinput);
        }
    }

    public class Nextcheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {

            IterateUser(BankDatabase.createIterator());
        }
    }
    //Action listener used for the literator pattern
    public class Prevcheck implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {

            prevIterateUser(BankDatabase.createIterator());
        }
    }

    public void IterateUser(Iterator Iterator){
        if(Iterator.hasNext(position)) {
            position = position + 1;
            //Display the current user in the GUI message labels.
            Account AccountItem = (Account)Iterator.next(position);
            screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
            screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
            screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());
        }


    }
    //Action listener used for the literator pattern
    public void prevIterateUser(Iterator Iterator){
        if(Iterator.hasPrev(position)) {
            position = position - 1;
            Account AccountItem = (Account)Iterator.next(position);
            screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
            screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
            screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());


        }

    }

    public static ATM getinstance() {
        if (uniqueinstance == null) {
            uniqueinstance = new ATM();
        }
        return uniqueinstance;
    }

}
