import java.sql.*;
import javax.swing.*;
import java.util.Scanner;

public class JDBCExample {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ooplab6";
        String username = "root";
        String password = "mysql@password123";
        return DriverManager.getConnection(url, username, password);
    }

    public static void addRecord(String name, int age) {
        String query = "INSERT INTO employees (name, age) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Adding Record");
        }
    }

    public static void updateRecord(int id, String name, int age) {
        String query = "UPDATE employees SET name = ?, age = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Updating Record");
        }
    }

    public static void deleteRecord(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Deleting Record");
        }
    }

    public static void displayRecords() {
        String query = "SELECT * FROM employees";
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            StringBuilder output = new StringBuilder("ID\tName\tAge\n");
            while (rs.next()) {
                output.append(rs.getInt("id")).append("\t")
                      .append(rs.getString("name")).append("\t")
                      .append(rs.getInt("age")).append("\n");
            }
            JOptionPane.showMessageDialog(null, output.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Displaying Records");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Record");
            System.out.println("2. Update Record");
            System.out.println("3. Delete Record");
            System.out.println("4. Display Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    addRecord(name, age);
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    updateRecord(idToUpdate, newName, newAge);
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    deleteRecord(idToDelete);
                    break;
                case 4:
                    displayRecords();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}
