import java.util.Scanner;

abstract class Payment {
    double amount;
    String transactionID;

    Payment(double amount, String transactionID) {
        this.amount = amount;
        this.transactionID = transactionID;
    }

    abstract void processPayment();

    void showTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
    }
}

class CreditCardPayment extends Payment {
    String cardNumber;
    String cvv;
    String expiryDate;

    CreditCardPayment(double amount, String transactionID, String cardNumber, String cvv, String expiryDate) {
        super(amount, transactionID);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    void processPayment() {
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("CVV: " + cvv);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Payment Successful via Credit Card.");
    }
}

class PayPalPayment extends Payment {
    String email;
    String password;

    PayPalPayment(double amount, String transactionID, String email, String password) {
        super(amount, transactionID);
        this.email = email;
        this.password = password;
    }

    void processPayment() {
        System.out.println("Processing PayPal Payment...");
        System.out.println("Email: " + email);
        System.out.println("Payment Successful via PayPal.");
    }
}

class UPIPayment extends Payment {
    String upiID;

    UPIPayment(double amount, String transactionID, String upiID) {
        super(amount, transactionID);
        this.upiID = upiID;
    }

    void processPayment() {
        System.out.println("Processing UPI Payment...");
        System.out.println("UPI ID: " + upiID);
        System.out.println("Payment Successful via UPI.");
    }
}

class PaymentGateway {
    void processTransaction(Payment payment) {
        payment.processPayment();
        payment.showTransactionDetails();
    }
}

public class OnlinePaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment payment = null;
        PaymentGateway gateway = new PaymentGateway();

        System.out.println("Enter amount:");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter transaction ID:");
        String transactionID = sc.nextLine();
        System.out.println("Select Payment Method: 1. Credit Card 2. PayPal 3. UPI");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("Enter Card Number:");
            String cardNumber = sc.nextLine();
            System.out.println("Enter CVV:");
            String cvv = sc.nextLine();
            System.out.println("Enter Expiry Date:");
            String expiryDate = sc.nextLine();
            payment = new CreditCardPayment(amount, transactionID, cardNumber, cvv, expiryDate);
        } else if (choice == 2) {
            System.out.println("Enter PayPal Email:");
            String email = sc.nextLine();
            System.out.println("Enter PayPal Password:");
            String password = sc.nextLine();
            payment = new PayPalPayment(amount, transactionID, email, password);
        } else if (choice == 3) {
            System.out.println("Enter UPI ID:");
            String upiID = sc.nextLine();
            payment = new UPIPayment(amount, transactionID, upiID);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        gateway.processTransaction(payment);
    }
}
