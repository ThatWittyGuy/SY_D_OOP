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


// import java.util.Scanner;

// public class BankAccount {
//     private double balance;

//     public void deposit(double amount) {
//         if (amount > 0) balance += amount;
//     }

//     public void withdraw(double amount) throws Exception {
//         if (amount > balance) throw new Exception("Insufficient funds");
//         balance -= amount;
//     }

//     public double checkBalance() {
//         return balance;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         BankAccount account = new BankAccount();
//         while (true) {
//             System.out.println("1. Deposit 2. Withdraw 3. Check Balance 4. Exit");
//             int choice = sc.nextInt();
//             if (choice == 4) break;
//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter deposit amount: ");
//                     double depositAmount = sc.nextDouble();
//                     account.deposit(depositAmount);
//                     break;
//                 case 2:
//                     System.out.print("Enter withdrawal amount: ");
//                     double withdrawAmount = sc.nextDouble();
//                     try {
//                         account.withdraw(withdrawAmount);
//                     } catch (Exception e) {
//                         System.out.println(e.getMessage());
//                     }
//                     break;
//                 case 3:
//                     System.out.println("Balance: " + account.checkBalance());
//                     break;
//                 default:
//                     System.out.println("Invalid option");
//             }
//         }
//         sc.close();
//     }
// }
