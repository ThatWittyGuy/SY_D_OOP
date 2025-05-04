class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. Available: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}


public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        account.checkBalance();

        account.deposit(500);
        account.checkBalance();

        try {
            account.withdraw(200); // success
            System.out.println("Withdrawing $1500.");
            account.withdraw(1500); // should throw exception
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        account.checkBalance();
    }
}
