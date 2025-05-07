// import java.util.*;

// class InvalidCouponException extends Exception {
//     InvalidCouponException(String message) {
//         super(message);
//     }
// }

// class OutOfStockException extends Exception {
//     OutOfStockException(String message) {
//         super(message);
//     }
// }

// class NegativeQuantityException extends Exception {
//     NegativeQuantityException(String message) {
//         super(message);
//     }
// }

// class Item {
//     String name;
//     double price;
//     int stock;

//     Item(String name, double price, int stock) {
//         this.name = name;
//         this.price = price;
//         this.stock = stock;
//     }
// }

// class CartItem {
//     Item item;
//     int quantity;

//     CartItem(Item item, int quantity) {
//         this.item = item;
//         this.quantity = quantity;
//     }
// }

// class ShoppingCart {
//     List<CartItem> cartItems = new ArrayList<>();
//     Map<String, Double> coupons = new HashMap<>();
//     double discount = 0.0;

//     ShoppingCart() {
//         coupons.put("SAVE10", 0.10);
//         coupons.put("SAVE20", 0.20);
//     }

//     void addItem(Item item, int quantity) throws OutOfStockException, NegativeQuantityException {
//         if (quantity <= 0)
//             throw new NegativeQuantityException("Quantity must be positive.");
//         if (quantity > item.stock)
//             throw new OutOfStockException("Not enough stock for " + item.name + ".");
//         cartItems.add(new CartItem(item, quantity));
//         item.stock -= quantity;
//     }

//     void applyCoupon(String code) throws InvalidCouponException {
//         if (!coupons.containsKey(code))
//             throw new InvalidCouponException("Invalid coupon code.");
//         discount = coupons.get(code);
//         System.out.println("Coupon applied: " + (int)(discount*100) + "% off");
//     }

//     double checkout() {
//         double total = 0.0;
//         for (CartItem ci : cartItems) {
//             total += ci.item.price * ci.quantity;
//         }
//         if (discount > 0) {
//             total = total - (total * discount);
//         }
//         return total;
//     }

//     void showCart() {
//         System.out.println("Cart Contents:");
//         for (CartItem ci : cartItems) {
//             System.out.println(ci.item.name + " x " + ci.quantity + " = " + (ci.item.price * ci.quantity));
//         }
//     }
// }

// public class ShoppingCartDemo {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         List<Item> store = new ArrayList<>();
//         store.add(new Item("Apple", 10.0, 10));
//         store.add(new Item("Banana", 5.0, 20));
//         store.add(new Item("Milk", 30.0, 5));

//         ShoppingCart cart = new ShoppingCart();

//         while (true) {
//             System.out.println("\n1. Add Item\n2. Apply Coupon\n3. Show Cart\n4. Checkout\n5. Exit");
//             int choice = sc.nextInt();
//             if (choice == 1) {
//                 System.out.println("Available items:");
//                 for (int i = 0; i < store.size(); i++) {
//                     Item it = store.get(i);
//                     System.out.println((i + 1) + ". " + it.name + " (Rs." + it.price + ", Stock: " + it.stock + ")");
//                 }
//                 System.out.println("Enter item number:");
//                 int itemNum = sc.nextInt() - 1;
//                 System.out.println("Enter quantity:");
//                 int qty = sc.nextInt();
//                 try {
//                     cart.addItem(store.get(itemNum), qty);
//                     System.out.println("Item added to cart.");
//                 } catch (OutOfStockException | NegativeQuantityException e) {
//                     System.out.println("Error: " + e.getMessage());
//                 }
//             } else if (choice == 2) {
//                 System.out.println("Enter coupon code:");
//                 sc.nextLine();
//                 String code = sc.nextLine().trim();
//                 try {
//                     cart.applyCoupon(code);
//                 } catch (InvalidCouponException e) {
//                     System.out.println("Error: " + e.getMessage());
//                 }
//             } else if (choice == 3) {
//                 cart.showCart();
//             } else if (choice == 4) {
//                 cart.showCart();
//                 double total = cart.checkout();
//                 System.out.println("Total after discount: Rs." + total);
//                 System.out.println("Thank you for shopping!");
//                 break;
//             } else if (choice == 5) {
//                 break;
//             }
//         }
//     }
// }


// NEW SIMPLE

import java.util.*;

class ShoppingCart {
    private Map<String, Integer> stock = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();
    private Map<String, Integer> cart = new HashMap<>();
    private double discount = 0;

    public ShoppingCart() {
        stock.put("apple", 10);
        stock.put("banana", 5);
        stock.put("orange", 8);
        prices.put("apple", 2.0);
        prices.put("banana", 1.5);
        prices.put("orange", 1.8);
    }

    public void addItem(String item, int quantity) throws NegativeQuantityException, OutOfStockException {
        if (quantity <= 0) throw new NegativeQuantityException("Quantity must be positive");
        if (!stock.containsKey(item) || stock.get(item) < quantity) throw new OutOfStockException(item + " is out of stock or insufficient quantity");
        cart.put(item, cart.getOrDefault(item, 0) + quantity);
        stock.put(item, stock.get(item) - quantity);
    }

    public void applyDiscountCode(String code) throws InvalidCouponException {
        switch (code) {
            case "SAVE10": discount = 0.10; break;
            case "SAVE20": discount = 0.20; break;
            default: throw new InvalidCouponException("Invalid coupon code");
        }
    }

    public double checkout() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += prices.get(entry.getKey()) * entry.getValue();
        }
        total = total - total * discount;
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        while (true) {
            System.out.println("1. Add item 2. Apply discount 3. Checkout 4. Exit");
            int choice = sc.nextInt();
            if (choice == 4) break;
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String item = sc.next();
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        cart.addItem(item, qty);
                        System.out.println("Added " + qty + " " + item + "(s)");
                        break;
                    case 2:
                        System.out.print("Enter discount code: ");
                        String code = sc.next();
                        cart.applyDiscountCode(code);
                        System.out.println("Discount applied");
                        break;
                    case 3:
                        System.out.println("Total amount: " + cart.checkout());
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (NegativeQuantityException | OutOfStockException | InvalidCouponException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}

class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String message) {
        super(message);
    }
}

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class InvalidCouponException extends Exception {
    public InvalidCouponException(String message) {
        super(message);
    }
}
