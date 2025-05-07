// class CarAssembly implements Runnable {
//     private String componentName;
//     private int timeToPrepare;
 

//     public CarAssembly(String componentName, int timeToPrepare) {
//         this.componentName = componentName;
//         this.timeToPrepare = timeToPrepare;
//     }
 
//     @Override
//     public void run() {
//         try {
//             System.out.println(componentName + " is preparing...");
//             Thread.sleep(timeToPrepare); // Simulate time to prepare
//             System.out.println(componentName + " is ready.");
//         } catch (InterruptedException e) {
//             System.out.println(componentName + " preparation was interrupted.");
//         }
//     }
 
//     public static void main(String[] args) {
//         // Create Runnable instances
//         CarAssembly engine = new CarAssembly("Engine", 3000);
//         CarAssembly body = new CarAssembly("Body", 4000);
//         CarAssembly wheels = new CarAssembly("Wheels", 5000);
 
 
//         // Create threads
//         Thread engineThread = new Thread(engine);
//         Thread bodyThread = new Thread(body);
//         Thread wheelThread = new Thread(wheels);
 
//         engineThread.start();
//         bodyThread.start();
//         wheelThread.start();
 
//         try {
//             engineThread.join();
//             bodyThread.join();
//             wheelThread.join();
//         } catch (InterruptedException e) {
//             System.out.println("Assembly process interrupted.");
//         }
 
 
//         System.out.println("Car assembly completed.");
//     }
//  }
 
public class CarAssembly implements Runnable {
    private String componentName;
    private int timeToPrepare;

    public CarAssembly(String componentName, int timeToPrepare) {
        this.componentName = componentName;
        this.timeToPrepare = timeToPrepare;
    }

    @Override
    public void run() {
        try {
            System.out.println(componentName + " is preparing");
            Thread.sleep(timeToPrepare);
            System.out.println(componentName + " is ready");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CarAssembly engine = new CarAssembly("Engine", 3000);
        CarAssembly body = new CarAssembly("Body", 4000);
        CarAssembly wheels = new CarAssembly("Wheels", 5000);

        Thread engineThread = new Thread(engine);
        Thread bodyThread = new Thread(body);
        Thread wheelThread = new Thread(wheels);

        engineThread.start();
        bodyThread.start();
        wheelThread.start();

        try {
            engineThread.join();
            bodyThread.join();
            wheelThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Car assembly completed!");
    }
}
