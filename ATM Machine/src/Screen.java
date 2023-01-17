import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public JFrame MainFrame;
    public static JTextField Inputfield1;
    public static JTextField Inputfield2;
    public static JTextField Inputfield3;
    public static JTextField Inputfield4;
    public JLabel messageJLabel1;
    public JLabel messageJLabel2;
    public JLabel messageJLabel3;
    public JLabel messageJLabel4;
    public JLabel messageJLabel5;
    public JLabel messageJLabel8;
    public JLabel messageJLabel9;
    public JLabel messageJLabel10;
    public JButton loginbutton;
    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton Exit;
    public int accnum = 0;
    public int PIN = 0;
    public JLabel messageJLabel6;
    public JLabel messageJLabel7;

    //Afisare mesaj
    public void Message(String message) {
        System.out.println(message);
    }

    public void displayDollarAmount(double amount) {
        System.out.println("$%,.2f" + amount);
    }

    //login GUI
    public void createLogin() {
        MainFrame = new JFrame("ATM");
        messageJLabel4 = new JLabel("Insert your credit/debit card                       ");
        messageJLabel1 = new JLabel("Enter PIN:     ");

        Inputfield1 = new JTextField(10);

        messageJLabel2 = new JLabel("                                                               ");
        Inputfield2 = new JTextField(10);
        loginbutton = new JButton("Login");
        messageJLabel3 = new JLabel("");
        MainFrame.setLayout(new FlowLayout()); // set layout
        MainFrame.add(messageJLabel4);
        MainFrame.add(messageJLabel1); // add first prompt

        MainFrame.add(Inputfield2);
        MainFrame.add(messageJLabel2);
        MainFrame.add(messageJLabel3);
        Inputfield2.setEditable(false);
        MainFrame.repaint();

    }

    //main GUI menu
    public void createMenu() {
        MainFrame.getContentPane().removeAll();
        messageJLabel1 = new JLabel("Welcome");
        messageJLabel2 = new JLabel("1 - Balance");
        messageJLabel3 = new JLabel("2 - Withdrawal");
        messageJLabel4 = new JLabel("3 - Deposit");
        messageJLabel5 = new JLabel("4 - Exit");

        MainFrame.setLayout(new FlowLayout());
        MainFrame.add(messageJLabel1);
        MainFrame.add(messageJLabel2); // add first prompt
        MainFrame.add(messageJLabel3); // add second prompt
        MainFrame.add(messageJLabel4); // add message label
        MainFrame.add(messageJLabel5);
        MainFrame.repaint();

    }

    //Balance GUI
    public void creatBalanceGUI() {
        MainFrame.getContentPane().removeAll();
        messageJLabel1 = new JLabel("Balance Information:        ");
        messageJLabel2 = new JLabel("Avaliable Balance:");
        messageJLabel3 = new JLabel("Total Balance:");
        Exit = new JButton("Back");
        MainFrame.setLayout(new FlowLayout());
        MainFrame.add(messageJLabel1);
        MainFrame.add(messageJLabel2);
        MainFrame.add(messageJLabel3);
        MainFrame.add(Exit);
        MainFrame.repaint();
    }

    public void createWithdrawGUI() {
        MainFrame.getContentPane().removeAll();
        MainFrame.revalidate();
        messageJLabel1 = new JLabel("Withdraw Menu:                       ");
        messageJLabel2 = new JLabel("1 - $20 ");
        messageJLabel3 = new JLabel("2 - $40 ");
        messageJLabel4 = new JLabel("3 - $60 ");
        messageJLabel5 = new JLabel("4 - $100 ");
        messageJLabel6 = new JLabel("5 - $200 ");
        messageJLabel7 = new JLabel("            Choose an amount to withdraw");
        Exit = new JButton("Cancel");
        MainFrame.setLayout(new FlowLayout());
        MainFrame.add(messageJLabel1);
        MainFrame.add(messageJLabel2);
        MainFrame.add(messageJLabel3);
        MainFrame.add(messageJLabel4);
        MainFrame.add(messageJLabel5);
        MainFrame.add(messageJLabel6);
        MainFrame.add(Exit);
        MainFrame.add(messageJLabel7);
        MainFrame.repaint();
    }

    public void CreatDepozitGUI() {
        MainFrame.getContentPane().removeAll();
        messageJLabel2 = new JLabel("Please enter a deposit amount in CENTS");
        messageJLabel3 = new JLabel("");
        Inputfield2 = new JTextField(10);
        Inputfield2.setEditable(false);
        button1 = new JButton("Deposit");
        Exit = new JButton("Cancel");
        MainFrame.add(messageJLabel2);
        MainFrame.add(messageJLabel3);
        MainFrame.add(Inputfield2);
        MainFrame.add(Exit);
        MainFrame.repaint();
    }

    public void setGUI() {
        repaint();
    }

    public void CreateAdminPage()
    {
        messageJLabel1 = new JLabel("View Users:");
        messageJLabel2 = new JLabel("Account number:");
        messageJLabel3 = new JLabel("Avaliable Balance:");
        messageJLabel4 = new JLabel("Total Balance:");
        messageJLabel5 = new JLabel("________________________________________________");
        button1 = new JButton("Next");
        button4 = new JButton("Previous");
        Exit = new JButton("Back");
        Inputfield1 = new JTextField(10);
        Inputfield2 = new JTextField(10);
        Inputfield3 = new JTextField(10);
        Inputfield4 = new JTextField(10);
        MainFrame.setLayout( new FlowLayout() );
        messageJLabel6 = new JLabel("Add Account: ");
        messageJLabel7 = new JLabel("User name: ");
        MainFrame.add(messageJLabel1);
        messageJLabel8 = new JLabel("          Account number: ");
        MainFrame.add(messageJLabel2);
        messageJLabel10 = new JLabel("                                       PIN: ");

        messageJLabel9 = new JLabel("              Balance number: ");
        button2 = new JButton("Add");
        button3 = new JButton("Delete");


        MainFrame.add(messageJLabel3);
        MainFrame.add(messageJLabel4);
        MainFrame.add(button4);
        MainFrame.add(button1);
        MainFrame.add(button3);
        MainFrame.add(messageJLabel5);
        MainFrame.add(messageJLabel6);
        MainFrame.add(messageJLabel7);
        MainFrame.add(Inputfield1);
        MainFrame.add(messageJLabel8);
        MainFrame.add(Inputfield2);
        MainFrame.add(messageJLabel10);
        MainFrame.add(Inputfield4);
        MainFrame.add(messageJLabel9);
        MainFrame.add(Inputfield3);

        MainFrame.add(button2);

        MainFrame.add(Exit);
        MainFrame.repaint();
    }
}


