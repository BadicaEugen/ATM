import java.util.ArrayList;

public class Account_Iterator implements Iterator
{

    ArrayList<Account> Accounts;

    public Account_Iterator(ArrayList<Account> accounts)
    {
        Accounts = accounts;
    }//cream un array peatru a o folosi in interiorul clasei

    @Override
    public boolean hasNext(int position) {
        return position < Accounts.size();
    }

    public Object next(int position)
    {
        return Accounts.get(position);
    }

    public boolean hasPrev(int position)
    {
        return position != 0;
    }
}
