// import java.util.Scanner;

// class Fruit {
//     String name;
//     String taste;
//     String size;

//     Fruit(String name, String taste, String size) {
//         this.name = name;
//         this.taste = taste;
//         this.size = size;
//     }

//     void eat() {
//         System.out.println("Fruit: " + name + ", Taste: " + taste);
//     }
// }

// class Apple extends Fruit {
//     Apple(String name, String taste, String size) {
//         super(name, taste, size);
//     }

//     @Override
//     void eat() {
//         System.out.println("Fruit: " + name + ", Taste: Sweet and Size" + size);
//     }
// }

// class Orange extends Fruit {
//     Orange(String name, String taste, String size) {
//         super(name, taste, size);
//     }

//     @Override
//     void eat() {
//         System.out.println("Fruit: " + name + ", Taste: Citrus and Size:" + size);
//     }
// }

// public class FruitDemo {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter Apple details (name, taste, size):");
//         String aName = sc.next();
//         String aTaste = sc.next();
//         String aSize = sc.next();
//         Fruit apple = new Apple(aName, aTaste, aSize);

//         System.out.println("Enter Orange details (name, taste, size):");
//         String oName = sc.next();
//         String oTaste = sc.next();
//         String oSize = sc.next();
//         Fruit orange = new Orange(oName, oTaste, oSize);

//         apple.eat();
//         orange.eat();
//     }
// }

class Fruit {
    String name;
    String taste;
    String size;

    Fruit(String name, String taste, String size) {
        this.name = name;
        this.taste = taste;
        this.size = size;
    }

    void eat() {
        System.out.println("Fruit: " + name + ", Taste: " + taste);
    }
}

class Apple extends Fruit {
    Apple(String taste, String size) {
        super("Apple", taste, size);  // Hardcode name as "Apple"
    }

    @Override
    void eat() {
        System.out.println("Fruit: Apple, Taste: Sweet, Size: " + size);
    }
}

class Orange extends Fruit {
    Orange(String taste, String size) {
        super("Orange", taste, size);  // Hardcode name as "Orange"
    }

    @Override
    void eat() {
        System.out.println("Fruit: Orange, Taste: Citrus, Size: " + size);
    }
}

public class FruitDemo {
    public static void main(String[] args) {
        Fruit apple = new Apple("sweet", "medium");
        Fruit orange = new Orange("citrus", "small");

        apple.eat();   // Fruit: Apple, Taste: Sweet, Size: medium
        orange.eat();  // Fruit: Orange, Taste: Citrus, Size: small
    }
}
