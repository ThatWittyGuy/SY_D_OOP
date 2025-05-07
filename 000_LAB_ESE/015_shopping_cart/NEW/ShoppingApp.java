import java.util.Scanner;

class InvalidCouponException extends Exception {
    public InvalidCouponException(String message) {
        super(message);
    }
}

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String message) {
        super(message);
    }
}

class Item {
    String name;
    int price;
    int stock;

    public Item(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class ShoppingCart {
    private int total = 0;
    private int discount = 0;

    public void addItem(Item item, int quantity) throws NegativeQuantityException, OutOfStockException {
        if (quantity < 0) throw new NegativeQuantityException("Quantity cannot be negative.");
        if (quantity > item.stock) throw new OutOfStockException("Not enough stock for " + item.name);

        total += item.price * quantity;
        item.stock -= quantity;
        System.out.println(quantity + " x " + item.name + " added to cart.");
    }

    public void applyCoupon(String code) throws InvalidCouponException {
        if (code.equals("SAVE10")) {
            discount = 10;
            System.out.println("Coupon applied: 10% off");
        } else {
            throw new InvalidCouponException("Invalid coupon code.");
        }
    }

    public void checkout() {
        int discountedTotal = total - (total * discount / 100);
        System.out.println("Final total after discount: $" + discountedTotal);
    }
}

public class ShoppingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Item laptop = new Item("Laptop", 50000, 5);
        Item phone = new Item("Phone", 20000, 2);

        ShoppingCart cart = new ShoppingCart();

        try {
            System.out.print("Enter quantity of Laptop to add: ");
            int laptopQuantity = scanner.nextInt();
            cart.addItem(laptop, laptopQuantity);

            System.out.print("Enter quantity of Phone to add: ");
            int phoneQuantity = scanner.nextInt();
            cart.addItem(phone, phoneQuantity);

            System.out.print("Enter coupon code: ");
            String couponCode = scanner.next();
            cart.applyCoupon(couponCode);

            cart.checkout();
        } catch (InvalidCouponException | OutOfStockException | NegativeQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer for quantity.");
        } finally {
            scanner.close();
        }
    }
}
