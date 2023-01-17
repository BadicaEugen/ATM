public class CashDispenser
{
    private final static int INITIAL_COUNT = 500;
    private int count;


    public CashDispenser()
    {
        count = INITIAL_COUNT;
    }


    public void dispenseCash(int amount)
    {
        int billsRequired = amount / 20;
        count -= billsRequired;
    }


    public boolean isSufficientCashAvailable(int amount)
    {
        int billsRequired = amount / 20; // number of $20 bills required

        // not enough bills available
        return count >= billsRequired; // enough bills available
    }
}


