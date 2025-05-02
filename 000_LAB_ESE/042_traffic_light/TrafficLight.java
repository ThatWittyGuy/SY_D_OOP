public class TrafficLight {
    private String color;
    private int duration; // in seconds

    public TrafficLight(String color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    public void changeColor(String newColor, int newDuration) {
        this.color = newColor;
        this.duration = newDuration;
        System.out.println("Traffic light changed to " + color + " for " + duration + " seconds.");
    }

    public boolean isRed() {
        return color.equalsIgnoreCase("red");
    }

    public boolean isGreen() {
        return color.equalsIgnoreCase("green");
    }

    public void displayStatus() {
        System.out.println("Current Color: " + color);
        System.out.println("Duration: " + duration + " seconds");
        if (isRed()) {
            System.out.println("Stop! The light is RED.");
        } else if (isGreen()) {
            System.out.println("Go! The light is GREEN.");
        } else {
            System.out.println("Caution! The light is " + color.toUpperCase() + ".");
        }
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("red", 30);
        light.displayStatus();

        System.out.println();

        light.changeColor("green", 40);
        light.displayStatus();

        System.out.println();

        light.changeColor("yellow", 5);
        light.displayStatus();
    }
}
