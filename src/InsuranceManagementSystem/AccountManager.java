package InsuranceManagementSystem;

import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accountSet;

    public AccountManager() {
        super();
        this.accountSet = new TreeSet<>();
    }

    public void addAccount(Account account) {
        accountSet.add(account);
    }

    public Account login(String email, String password) {
        for (Account account : accountSet) {
            try {
                account.login(email, password);
                return account;
            } catch (InvalidAuthenticationException e) {
                System.out.println("Accounted failed " + e.getMessage());
            }
        }
        return null;
    }
}
