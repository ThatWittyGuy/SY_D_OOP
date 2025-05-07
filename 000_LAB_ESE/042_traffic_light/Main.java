// public class TrafficLight {
//     private String color;
//     private int duration; // in seconds

//     public TrafficLight(String color, int duration) {
//         this.color = color;
//         this.duration = duration;
//     }

//     public void changeColor(String newColor, int newDuration) {
//         this.color = newColor;
//         this.duration = newDuration;
//         System.out.println("Traffic light changed to " + color + " for " + duration + " seconds.");
//     }

//     public boolean isRed() {
//         return color.equalsIgnoreCase("red");
//     }

//     public boolean isGreen() {
//         return color.equalsIgnoreCase("green");
//     }

//     public void displayStatus() {
//         System.out.println("Current Color: " + color);
//         System.out.println("Duration: " + duration + " seconds");
//         if (isRed()) {
//             System.out.println("Stop! The light is RED.");
//         } else if (isGreen()) {
//             System.out.println("Go! The light is GREEN.");
//         } else {
//             System.out.println("Caution! The light is " + color.toUpperCase() + ".");
//         }
//     }

//     public static void main(String[] args) {
//         TrafficLight light = new TrafficLight("red", 30);
//         light.displayStatus();

//         System.out.println();

//         light.changeColor("green", 40);
//         light.displayStatus();

//         System.out.println();

//         light.changeColor("yellow", 5);
//         light.displayStatus();
//     }
// }

class TrafficLight {
    private String color;
    private int duration;

    TrafficLight(String color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    public void changeColor(String newColor, int newDuration) {
        color = newColor;
        duration = newDuration;
    }

    public boolean isRed() {
        return color.equalsIgnoreCase("red");
    }

    public boolean isGreen() {
        return color.equalsIgnoreCase("green");
    }

    public void start() throws InterruptedException {
        for(int i =0;i<3;i++) {
            System.out.println("Light is " + color + " for " + duration + " seconds");
            Thread.sleep(duration * 1000);
            if (color.equalsIgnoreCase("red")) changeColor("green", 5);
            else if (color.equalsIgnoreCase("green")) changeColor("yellow", 2);
            else if (color.equalsIgnoreCase("yellow")) changeColor("red", 7);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight("red", 7);
        light.start();
    }
}
