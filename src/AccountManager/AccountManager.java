package AccountManager;

import Account.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    AccountManager accountManager;
    private List<Account> accounts;
    private AccountManager() {
        accounts = new ArrayList<>();
    }
    public AccountManager getInstance(){
        if(accountManager == null)
            accountManager = new AccountManager();
        return  accountManager;
    }
    public boolean checkAccount(String username){
        for (Account account : accounts){
            if(account.getUsername().equals(username))
                return  true;
        }
        return  false;
    }
    public void createAccount(String username,String password){
            if( checkAccount(username))
                System.out.println("This username is used");
            else
                accounts.add(new Account(username,password));
    }
}
