import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListManager {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void insert(int index, int value) {
        if (index >= 0 && index <= list.size()) {
            list.add(index, value);
        } else {
            System.out.println("Invalid insert index.");
        }
        System.out.println(list);
    }

    public static void delete(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        } else {
            System.out.println("Invalid delete index.");
        }
        System.out.println(list);
    }

    public static void update(int index, int value) {
        if (index >= 0 && index < list.size()) {
            list.set(index, value);
        } else {
            System.out.println("Invalid update index.");
        }
        System.out.println(list);
    }

    public static void sum(int start, int end) {
        if (start >= 0 && end < list.size() && start <= end) {
            int total = 0;
            for (int i = start; i <= end; i++) {
                total += list.get(i);
            }
            System.out.println(total);
        } else {
            System.out.println("Invalid sum range.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] command = scanner.nextLine().split(" ");
            if (command.length == 0)
                continue;

            switch (command[0]) {
                case "insert":
                    insert(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "delete":
                    delete(Integer.parseInt(command[1]));
                    break;
                case "update":
                    update(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "sum":
                    sum(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
        scanner.close();
    }
}
