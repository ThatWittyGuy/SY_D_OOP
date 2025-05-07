import java.util.*;

// BankAccount class with synchronized methods
class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited $" + amount + " to Account " + accountNumber
                + ". New balance: $" + balance);
    }

    public synchronized boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw $" + amount + " from Account "
                    + accountNumber + " but insufficient funds.");
            return false;
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew $" + amount + " from Account " + accountNumber
                + ". New balance: $" + balance);
        return true;
    }

    public synchronized double getBalance() {
        return balance;
    }

    // Transfer must lock both accounts to prevent inconsistency
    public static void transfer(BankAccount from, BankAccount to, double amount) {
        BankAccount firstLock = from.accountNumber < to.accountNumber ? from : to;
        BankAccount secondLock = from.accountNumber < to.accountNumber ? to : from;

        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.withdraw(amount)) {
                    to.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + " transferred $" + amount + " from Account " +
                            from.getAccountNumber() + " to Account " + to.getAccountNumber());
                } else {
                    System.out.println("Transfer failed due to insufficient funds.");
                }
            }
        }
    }
}

// Runnable class for user simulation
class UserTransaction implements Runnable {
    private BankAccount acc1;
    private BankAccount acc2;

    public UserTransaction(BankAccount acc1, BankAccount acc2) {
        this.acc1 = acc1;
        this.acc2 = acc2;
    }

    @Override
    public void run() {
        acc1.deposit(100);
        acc1.withdraw(50);
        BankAccount.transfer(acc1, acc2, 30);
    }
}

// Main class
public class MultiThreadedBankingSystem {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1001, 500);
        BankAccount account2 = new BankAccount(1002, 1000);

        Thread user1 = new Thread(new UserTransaction(account1, account2), "User-1");
        Thread user2 = new Thread(new UserTransaction(account2, account1), "User-2");
        Thread user3 = new Thread(new UserTransaction(account1, account2), "User-3");

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance of Account 1001: $" + account1.getBalance());
        System.out.println("Final Balance of Account 1002: $" + account2.getBalance());
    }
}
