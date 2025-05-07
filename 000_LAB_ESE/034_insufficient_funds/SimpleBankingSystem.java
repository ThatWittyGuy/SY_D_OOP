// InsufficientFundsException
import java.util.Scanner;

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Withdrawal denied.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter initial balance:");
        double initialBalance = sc.nextDouble();
        BankAccount account = new BankAccount(initialBalance);

        while (true) {
            System.out.println("Enter withdrawal amount (or -1 to exit):");
            double amount = sc.nextDouble();
            if (amount == -1) break;
            try {
                account.withdraw(amount);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
