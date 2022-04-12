package SOLID;

public class WithdrawalService {
        /*
        ** OPEN CLOSE PRINCIPAL **
        Consequently, the BankingAppWithdrawalService is open for the extension with new account types,
        but closed for modification, in that the new types don't require it to change in order to integrate.
         */
//        Account myaccount = new StudentAccount();
//        myaccount.deposit(25);
//        myaccount.withdraw(14);

    private BankingAccounts account;
    public WithdrawalService(BankingAccounts account) {
        this.account = account;
    }

    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    public static void main(String[] args) {

        /*
        for the Open/Closed Principle to work well, all subtypes must be substitutable for their supertype without
        ever having to modify the client code. Adhering to the Liskov Substitution Principle ensures this substitutability.

        DUE to maintain Liskov principal we create two types of abstract class based on the IMPLEMENTATION.
         */
        WithdrawalService brac = new WithdrawalService(new CurrentAccount());
        brac.withdraw(50000);
    }


}
