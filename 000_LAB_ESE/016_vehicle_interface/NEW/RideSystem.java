import java.util.Scanner;

interface Vehicle {
    void startRide();
    void endRide();
    int calculateFare(int distance);
}

interface PricingStrategy {
    int adjustFare(int baseFare);
}

class PeakHourStrategy implements PricingStrategy {
    public int adjustFare(int baseFare) {
        return baseFare + (baseFare * 20 / 100);
    }
}

class HolidayStrategy implements PricingStrategy {
    public int adjustFare(int baseFare) {
        return baseFare + 50;
    }
}

class NormalStrategy implements PricingStrategy {
    public int adjustFare(int baseFare) {
        return baseFare;
    }
}

class Bike implements Vehicle {
    PricingStrategy strategy;
    public Bike(PricingStrategy strategy) {
        this.strategy = strategy;
    }
    public void startRide() {
        System.out.println("Bike ride started.");
    }
    public void endRide() {
        System.out.println("Bike ride ended.");
    }
    public int calculateFare(int distance) {
        int baseFare = distance * 5;
        return strategy.adjustFare(baseFare);
    }
}

class Auto implements Vehicle {
    PricingStrategy strategy;
    public Auto(PricingStrategy strategy) {
        this.strategy = strategy;
    }
    public void startRide() {
        System.out.println("Auto ride started.");
    }
    public void endRide() {
        System.out.println("Auto ride ended.");
    }
    public int calculateFare(int distance) {
        int baseFare = distance * 8;
        return strategy.adjustFare(baseFare);
    }
}

class Cab implements Vehicle {
    PricingStrategy strategy;
    public Cab(PricingStrategy strategy) {
        this.strategy = strategy;
    }
    public void startRide() {
        System.out.println("Cab ride started.");
    }
    public void endRide() {
        System.out.println("Cab ride ended.");
    }
    public int calculateFare(int distance) {
        int baseFare = distance * 12;
        return strategy.adjustFare(baseFare);
    }
}

public class RideSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vehicle type (bike/auto/cab): ");
        String vehicleType = sc.next().toLowerCase();
        System.out.print("Enter distance to travel (km): ");
        int distance = sc.nextInt();
        System.out.print("Enter pricing strategy (peak/holiday/normal): ");
        String strategyType = sc.next().toLowerCase();

        PricingStrategy strategy;
        if (strategyType.equals("peak")) strategy = new PeakHourStrategy();
        else if (strategyType.equals("holiday")) strategy = new HolidayStrategy();
        else strategy = new NormalStrategy();

        Vehicle vehicle;
        if (vehicleType.equals("bike")) vehicle = new Bike(strategy);
        else if (vehicleType.equals("auto")) vehicle = new Auto(strategy);
        else vehicle = new Cab(strategy);

        vehicle.startRide();
        System.out.println("Fare: " + vehicle.calculateFare(distance));
        vehicle.endRide();

        sc.close();
    }
}
