// package gui;
// import javax.swing.*;
// import java.awt.*;
// import java.sql.*;
// import db.DBConnection;

// public class LoginFrame extends JFrame {
//     private JTextField usernameField;
//     private JPasswordField passwordField;

//     public LoginFrame() {
//         setTitle("Admin Login");
//         setSize(350, 200);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
//         panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

//         panel.add(new JLabel("Username:"));
//         usernameField = new JTextField();
//         panel.add(usernameField);

//         panel.add(new JLabel("Password:"));
//         passwordField = new JPasswordField();
//         panel.add(passwordField);

//         JButton loginBtn = new JButton("Login");
//         panel.add(new JLabel());
//         panel.add(loginBtn);

//         loginBtn.addActionListener(e -> login());

//         add(panel);
//         setVisible(true);
//     }

//     private void login() {
//         String user = usernameField.getText();
//         String pass = String.valueOf(passwordField.getPassword());

//         try (Connection con = DBConnection.getConnection()) {
//             PreparedStatement stmt = con.prepareStatement("SELECT * FROM admin WHERE username=? AND password=?");
//             stmt.setString(1, user);
//             stmt.setString(2, pass);
//             ResultSet rs = stmt.executeQuery();
//             if (rs.next()) {
//                 JOptionPane.showMessageDialog(this, "Login Successful");
//                 new Dashboard();
//                 dispose();
//             } else {
//                 JOptionPane.showMessageDialog(this, "Invalid Credentials");
//             }
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }
// }

package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import db.DBConnection;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Hospital Management System - Admin Login");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Split into left (login) and right (info) panels
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // --------- LEFT: LOGIN PANEL ----------
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel loginTitle = new JLabel("Admin Login");
        loginTitle.setFont(new Font("Arial", Font.BOLD, 20));
        loginTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginPanel.add(loginTitle);
        loginPanel.add(Box.createVerticalStrut(20));

        loginPanel.add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        loginPanel.add(usernameField);
        loginPanel.add(Box.createVerticalStrut(10));

        loginPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        loginPanel.add(passwordField);
        loginPanel.add(Box.createVerticalStrut(20));

        JButton loginBtn = new JButton("Login");
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(loginBtn);

        loginBtn.addActionListener(e -> login());

        // --------- RIGHT: INFO PANEL ----------
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        infoPanel.setBackground(new Color(240, 248, 255)); // Light blue background

        JLabel welcomeLabel = new JLabel("<html><h2>Welcome to HMS</h2></html>");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea aboutText = new JTextArea(
            "This Hospital Management System allows you to manage:\n" +
            "• Patients\n" +
            "• Doctors\n" +
            "• Appointments\n\n" +
            "Login using your admin credentials to continue.\n\n" +
            "Developed using Java + MySQL + Swing."
        );
        aboutText.setWrapStyleWord(true);
        aboutText.setLineWrap(true);
        aboutText.setEditable(false);
        aboutText.setBackground(new Color(240, 248, 255));
        aboutText.setFont(new Font("Arial", Font.PLAIN, 14));

        infoPanel.add(welcomeLabel);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(aboutText);

        // Add both panels to main panel
        mainPanel.add(loginPanel);
        mainPanel.add(infoPanel);

        add(mainPanel);
        setVisible(true);
    }

    private void login() {
        String user = usernameField.getText().trim();
        String pass = String.valueOf(passwordField.getPassword()).trim();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM admin WHERE username=? AND password=?"
            );
            stmt.setString(1, user);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Welcome, " + user + "!\nLogin Successful 🎉");
                new Dashboard(); // Load dashboard
                dispose(); // Close login
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials. Please try again.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection error!");
        }
    }
}
