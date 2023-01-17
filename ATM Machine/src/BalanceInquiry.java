public class BalanceInquiry extends Transaction
{


    public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }

    public void execute()
    {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        double totalBallance = bankDatabase.getTotalBallance(getAccountNumber());

        double availableBallance = bankDatabase.getAvailableBallance(getAccountNumber());

        screen.creatBalanceGUI();
        screen.messageJLabel2.setText("Available ballance: " + availableBallance);
        screen.messageJLabel3.setText("Total ballance: " + totalBallance);
        screen.MainFrame.revalidate();
    }

}
