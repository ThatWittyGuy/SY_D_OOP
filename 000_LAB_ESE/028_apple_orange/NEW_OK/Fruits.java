class Fruit {
    String name;
    String taste;
    String size;

    public Fruit(String name, String taste, String size) {
        this.name = name;
        this.taste = taste;
        this.size = size;
    }

    void eat() {
        System.out.println("Name of fruit is: " + name);
        System.out.println("Taste is: " + taste);
    }
}

class Apple extends Fruit {
    public Apple(String name, String taste, String size) {
        super(name, taste, size);
    }

    @Override
    void eat() {
        System.out.println("Apples are sweet.");
    }
}

class Orange extends Fruit {
    public Orange(String name, String taste, String size) {
        super(name, taste, size);
    }

    @Override
    void eat() {
        System.out.println("Oranges are tangy and sweet.");
    }
}

public class Fruits {
    public static void main(String[] args) {
        Fruit apple = new Apple("Apple", "Sweet", "Medium");
        Fruit orange = new Orange("Orange", "Tangy and Sweet", "Medium");

        apple.eat();
        orange.eat();
    }
}
