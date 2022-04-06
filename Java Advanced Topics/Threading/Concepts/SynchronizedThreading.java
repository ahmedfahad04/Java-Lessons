package Concepts;

class BankAccount {
    private int balance = 0;

    private final int deposit;

    public BankAccount(int overdraft) {
        this.deposit = overdraft;
    }

    void topUp(int amount) {
        balance += amount;
    }

    void debit(int amount) {
        balance -= amount;
    }

    int getBalance() {
        return balance;
    }

    int getDeposit() {
        return deposit;
    }

}


class ATM {

    // this synchronized keyword is used to avoid mismatching in threading while multiple threading is running.

    static synchronized void withdraw(BankAccount bankAc, int amount, String Name) {

        int balance = bankAc.getBalance();

        if ((balance - amount) < -bankAc.getDeposit()) {

            System.out.println("Name: " + Name + ", Transaction Denied");

        } else {

            bankAc.debit(amount);
            System.out.println("Name: " + Name + ", $" + amount + " successfully withdrawn.");

        }

        System.out.println("Current Balance of " + Name + " is: " + bankAc.getBalance());

    }

}


class SynchronizedThreading {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(50);
        account.topUp(100);

        Thread t1 = new Thread(() -> {
            ATM.withdraw(account, 100, "Istiaq");
        });

        Thread t2 = new Thread(() -> {
            ATM.withdraw(account, 100, "Fahad");
        });


        t1.start();
        t2.start();


    }
}












