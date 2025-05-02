import java.util.Scanner;

class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        if (amount > balance) {
            throw new ArithmeticException();
        }
        balance -= amount;
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number:");
        String accNo = sc.next();
        System.out.println("Enter initial balance:");
        double initBalance = sc.nextDouble();
        BankAccount account = new BankAccount(accNo, initBalance);

        while (true) {
            System.out.println("Enter withdrawal amount (or -1 to exit):");
            double amt = sc.nextDouble();
            if (amt == -1) break;
            try {
                account.withdraw(amt);
                System.out.println("Withdrawal successful.");
            } catch (ArithmeticException e) {
                System.out.println("Insufficient funds for withdrawal.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid withdrawal amount.");
            }
            System.out.println("Current balance: " + account.balance);
        }
    }
}
