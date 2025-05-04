import java.util.*;

interface Vehicle {
    double calculateFare(int distance);
}

interface PricingStrategy {
    double adjustFare(double baseFare);
}

class NormalPricing implements PricingStrategy {
    public double adjustFare(double baseFare) {
        return baseFare;
    }
}

class PeakHourPricing implements PricingStrategy {
    public double adjustFare(double baseFare) {
        return baseFare * 1.5;
    }
}

class HolidayPricing implements PricingStrategy {
    public double adjustFare(double baseFare) {
        return baseFare * 2.0;
    }
}

class Bike implements Vehicle {
    PricingStrategy pricingStrategy;

    Bike(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateFare(int distance) {
        double baseFare = 10 + distance * 5;
        return pricingStrategy.adjustFare(baseFare);
    }
}

class Auto implements Vehicle {
    PricingStrategy pricingStrategy;

    Auto(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateFare(int distance) {
        double baseFare = 20 + distance * 8;
        return pricingStrategy.adjustFare(baseFare);
    }
}

class Cab implements Vehicle {
    PricingStrategy pricingStrategy;

    Cab(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateFare(int distance) {
        double baseFare = 50 + distance * 15;
        return pricingStrategy.adjustFare(baseFare);
    }
}

public class RideDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select vehicle: 1. Bike 2. Auto 3. Cab");
        int vehicleType = sc.nextInt();

        System.out.println("Enter distance (in km):");
        int distance = sc.nextInt();

        System.out.println("Select pricing strategy: 1. Normal 2. Peak Hour 3. Holiday");
        int strategyType = sc.nextInt();

        PricingStrategy strategy;
        if (strategyType == 2) {
            strategy = new PeakHourPricing();
        } else if (strategyType == 3) {
            strategy = new HolidayPricing();
        } else {
            strategy = new NormalPricing();
        }

        Vehicle vehicle;
        if (vehicleType == 1) {
            vehicle = new Bike(strategy);
        } else if (vehicleType == 2) {
            vehicle = new Auto(strategy);
        } else {
            vehicle = new Cab(strategy);
        }

        double fare = vehicle.calculateFare(distance);

        System.out.println("Total Fare: " + fare);
    }
}
