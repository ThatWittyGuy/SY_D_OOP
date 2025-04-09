// package gui;

// import db.DBConnection;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class PatientPanel extends JFrame {
//     private JTextField nameField, ageField, contactField;
//     private JComboBox<String> genderBox;
//     private JTextArea addressArea;
//     private JTable patientTable;
//     private DefaultTableModel model;

//     public PatientPanel() {
//         setTitle("Patient Management");
//         setSize(800, 500);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//         JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
//         inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

//         nameField = new JTextField();
//         ageField = new JTextField();
//         contactField = new JTextField();
//         genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
//         addressArea = new JTextArea(2, 20);

//         inputPanel.add(new JLabel("Name:"));
//         inputPanel.add(nameField);
//         inputPanel.add(new JLabel("Age:"));
//         inputPanel.add(ageField);
//         inputPanel.add(new JLabel("Gender:"));
//         inputPanel.add(genderBox);
//         inputPanel.add(new JLabel("Contact:"));
//         inputPanel.add(contactField);
//         inputPanel.add(new JLabel("Address:"));
//         inputPanel.add(new JScrollPane(addressArea));

//         JButton addButton = new JButton("Add");
//         JButton updateButton = new JButton("Update");
//         JButton deleteButton = new JButton("Delete");
//         JButton clearButton = new JButton("Clear");

//         inputPanel.add(addButton);
//         inputPanel.add(updateButton);
//         inputPanel.add(deleteButton);
//         inputPanel.add(clearButton);

//         add(inputPanel, BorderLayout.NORTH);

//         model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Gender", "Contact", "Address"}, 0);
//         patientTable = new JTable(model);
//         JScrollPane scrollPane = new JScrollPane(patientTable);
//         add(scrollPane, BorderLayout.CENTER);

//         loadPatients();

//         // Row click -> populate fields
//         patientTable.addMouseListener(new MouseAdapter() {
//             public void mouseClicked(MouseEvent e) {
//                 int row = patientTable.getSelectedRow();
//                 nameField.setText(model.getValueAt(row, 1).toString());
//                 ageField.setText(model.getValueAt(row, 2).toString());
//                 genderBox.setSelectedItem(model.getValueAt(row, 3).toString());
//                 contactField.setText(model.getValueAt(row, 4).toString());
//                 addressArea.setText(model.getValueAt(row, 5).toString());
//             }
//         });

//         // Add patient
//         addButton.addActionListener(e -> {
//             try (Connection con = DBConnection.getConnection()) {
//                 String sql = "INSERT INTO patient (name, age, gender, contact, address) VALUES (?, ?, ?, ?, ?)";
//                 PreparedStatement stmt = con.prepareStatement(sql);
//                 stmt.setString(1, nameField.getText());
//                 stmt.setInt(2, Integer.parseInt(ageField.getText()));
//                 stmt.setString(3, genderBox.getSelectedItem().toString());
//                 stmt.setString(4, contactField.getText());
//                 stmt.setString(5, addressArea.getText());
//                 stmt.executeUpdate();
//                 JOptionPane.showMessageDialog(this, "Patient added!");
//                 loadPatients();
//                 clearFields();
//             } catch (Exception ex) {
//                 ex.printStackTrace();
//             }
//         });

//         // Update patient
//         updateButton.addActionListener(e -> {
//             int row = patientTable.getSelectedRow();
//             if (row == -1) {
//                 JOptionPane.showMessageDialog(this, "Select a patient to update.");
//                 return;
//             }
//             int id = Integer.parseInt(model.getValueAt(row, 0).toString());
//             try (Connection con = DBConnection.getConnection()) {
//                 String sql = "UPDATE patient SET name=?, age=?, gender=?, contact=?, address=? WHERE id=?";
//                 PreparedStatement stmt = con.prepareStatement(sql);
//                 stmt.setString(1, nameField.getText());
//                 stmt.setInt(2, Integer.parseInt(ageField.getText()));
//                 stmt.setString(3, genderBox.getSelectedItem().toString());
//                 stmt.setString(4, contactField.getText());
//                 stmt.setString(5, addressArea.getText());
//                 stmt.setInt(6, id);
//                 stmt.executeUpdate();
//                 JOptionPane.showMessageDialog(this, "Patient updated!");
//                 loadPatients();
//                 clearFields();
//             } catch (Exception ex) {
//                 ex.printStackTrace();
//             }
//         });

//         // Delete patient
//         deleteButton.addActionListener(e -> {
//             int row = patientTable.getSelectedRow();
//             if (row == -1) {
//                 JOptionPane.showMessageDialog(this, "Select a patient to delete.");
//                 return;
//             }
//             int id = Integer.parseInt(model.getValueAt(row, 0).toString());
//             int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Delete Patient", JOptionPane.YES_NO_OPTION);
//             if (confirm == JOptionPane.YES_OPTION) {
//                 try (Connection con = DBConnection.getConnection()) {
//                     String sql = "DELETE FROM patient WHERE id=?";
//                     PreparedStatement stmt = con.prepareStatement(sql);
//                     stmt.setInt(1, id);
//                     stmt.executeUpdate();
//                     JOptionPane.showMessageDialog(this, "Patient deleted!");
//                     loadPatients();
//                     clearFields();
//                 } catch (Exception ex) {
//                     ex.printStackTrace();
//                 }
//             }
//         });

//         clearButton.addActionListener(e -> clearFields());
//     }

//     private void loadPatients() {
//         model.setRowCount(0);
//         try (Connection con = DBConnection.getConnection()) {
//             String sql = "SELECT * FROM patient";
//             Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(sql);
//             while (rs.next()) {
//                 model.addRow(new Object[]{
//                     rs.getInt("id"),
//                     rs.getString("name"),
//                     rs.getInt("age"),
//                     rs.getString("gender"),
//                     rs.getString("contact"),
//                     rs.getString("address")
//                 });
//             }
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void clearFields() {
//         nameField.setText("");
//         ageField.setText("");
//         contactField.setText("");
//         addressArea.setText("");
//         genderBox.setSelectedIndex(0);
//         patientTable.clearSelection();
//     }
// }


// BEFORE SEARCHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH

// package gui;

// import db.DBConnection;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class PatientPanel extends JFrame {
//     private JTextField nameField, ageField, contactField;
//     private JComboBox<String> genderBox;
//     private JTextArea addressArea;
//     private JTable patientTable;
//     private DefaultTableModel model;

//     public PatientPanel() {
//         setTitle("Patient Management");
//         setSize(800, 600);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//         // Main panel layout
//         JPanel inputPanel = new JPanel(new GridLayout(8, 1, 5, 5));
//         inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

//         // Back button (optional)
//         JPanel backRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         JButton backButton = new JButton("Back");
//         backButton.addActionListener(e -> dispose()); // Close current window
//         backRow.add(backButton);
//         inputPanel.add(backRow);

//         // Name
//         JPanel nameRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         nameRow.add(new JLabel("Name:"));
//         nameField = new JTextField(20);
//         nameRow.add(nameField);
//         inputPanel.add(nameRow);

//         // Age
//         JPanel ageRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         ageRow.add(new JLabel("Age:"));
//         ageField = new JTextField(20);
//         ageRow.add(ageField);
//         inputPanel.add(ageRow);

//         // Gender
//         JPanel genderRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         genderRow.add(new JLabel("Gender:"));
//         genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
//         genderRow.add(genderBox);
//         inputPanel.add(genderRow);

//         // Contact
//         JPanel contactRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         contactRow.add(new JLabel("Contact:"));
//         contactField = new JTextField(20);
//         contactRow.add(contactField);
//         inputPanel.add(contactRow);

//         // Address
//         JPanel addressRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         addressRow.add(new JLabel("Address:"));
//         addressArea = new JTextArea(2, 20);
//         addressRow.add(new JScrollPane(addressArea));
//         inputPanel.add(addressRow);

//         // Buttons row
//         JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         JButton addButton = new JButton("Add");
//         JButton updateButton = new JButton("Update");
//         JButton deleteButton = new JButton("Delete");
//         JButton clearButton = new JButton("Clear");

//         buttonRow.add(addButton);
//         buttonRow.add(updateButton);
//         buttonRow.add(deleteButton);
//         buttonRow.add(clearButton);

//         inputPanel.add(buttonRow);

//         // Add input section to main layout
//         add(inputPanel, BorderLayout.NORTH);

//         // Table section
//         model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Gender", "Contact", "Address"}, 0);
//         patientTable = new JTable(model);
//         JScrollPane scrollPane = new JScrollPane(patientTable);
//         add(scrollPane, BorderLayout.CENTER);

//         loadPatients();

//         // Populate form fields on row click
//         patientTable.addMouseListener(new MouseAdapter() {
//             public void mouseClicked(MouseEvent e) {
//                 int row = patientTable.getSelectedRow();
//                 nameField.setText(model.getValueAt(row, 1).toString());
//                 ageField.setText(model.getValueAt(row, 2).toString());
//                 genderBox.setSelectedItem(model.getValueAt(row, 3).toString());
//                 contactField.setText(model.getValueAt(row, 4).toString());
//                 addressArea.setText(model.getValueAt(row, 5).toString());
//             }
//         });

//         // Add patient
//         addButton.addActionListener(e -> {
//             try (Connection con = DBConnection.getConnection()) {
//                 String sql = "INSERT INTO patient (name, age, gender, contact, address) VALUES (?, ?, ?, ?, ?)";
//                 PreparedStatement stmt = con.prepareStatement(sql);
//                 stmt.setString(1, nameField.getText());
//                 stmt.setInt(2, Integer.parseInt(ageField.getText()));
//                 stmt.setString(3, genderBox.getSelectedItem().toString());
//                 stmt.setString(4, contactField.getText());
//                 stmt.setString(5, addressArea.getText());
//                 stmt.executeUpdate();
//                 JOptionPane.showMessageDialog(this, "Patient added!");
//                 loadPatients();
//                 clearFields();
//             } catch (Exception ex) {
//                 ex.printStackTrace();
//                 JOptionPane.showMessageDialog(this, "Error adding patient.");
//             }
//         });

//         // Update patient
//         updateButton.addActionListener(e -> {
//             int row = patientTable.getSelectedRow();
//             if (row == -1) {
//                 JOptionPane.showMessageDialog(this, "Select a patient to update.");
//                 return;
//             }
//             int id = Integer.parseInt(model.getValueAt(row, 0).toString());
//             try (Connection con = DBConnection.getConnection()) {
//                 String sql = "UPDATE patient SET name=?, age=?, gender=?, contact=?, address=? WHERE id=?";
//                 PreparedStatement stmt = con.prepareStatement(sql);
//                 stmt.setString(1, nameField.getText());
//                 stmt.setInt(2, Integer.parseInt(ageField.getText()));
//                 stmt.setString(3, genderBox.getSelectedItem().toString());
//                 stmt.setString(4, contactField.getText());
//                 stmt.setString(5, addressArea.getText());
//                 stmt.setInt(6, id);
//                 stmt.executeUpdate();
//                 JOptionPane.showMessageDialog(this, "Patient updated!");
//                 loadPatients();
//                 clearFields();
//             } catch (Exception ex) {
//                 ex.printStackTrace();
//                 JOptionPane.showMessageDialog(this, "Error updating patient.");
//             }
//         });

//         // Delete patient
//         deleteButton.addActionListener(e -> {
//             int row = patientTable.getSelectedRow();
//             if (row == -1) {
//                 JOptionPane.showMessageDialog(this, "Select a patient to delete.");
//                 return;
//             }
//             int id = Integer.parseInt(model.getValueAt(row, 0).toString());
//             int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Delete Patient", JOptionPane.YES_NO_OPTION);
//             if (confirm == JOptionPane.YES_OPTION) {
//                 try (Connection con = DBConnection.getConnection()) {
//                     String sql = "DELETE FROM patient WHERE id=?";
//                     PreparedStatement stmt = con.prepareStatement(sql);
//                     stmt.setInt(1, id);
//                     stmt.executeUpdate();
//                     JOptionPane.showMessageDialog(this, "Patient deleted!");
//                     loadPatients();
//                     clearFields();
//                 } catch (Exception ex) {
//                     ex.printStackTrace();
//                     JOptionPane.showMessageDialog(this, "Error deleting patient.");
//                 }
//             }
//         });

//         clearButton.addActionListener(e -> clearFields());
//     }

//     private void loadPatients() {
//         model.setRowCount(0);
//         try (Connection con = DBConnection.getConnection()) {
//             String sql = "SELECT * FROM patient";
//             Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(sql);
//             while (rs.next()) {
//                 model.addRow(new Object[]{
//                         rs.getInt("id"),
//                         rs.getString("name"),
//                         rs.getInt("age"),
//                         rs.getString("gender"),
//                         rs.getString("contact"),
//                         rs.getString("address")
//                 });
//             }
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void clearFields() {
//         nameField.setText("");
//         ageField.setText("");
//         contactField.setText("");
//         addressArea.setText("");
//         genderBox.setSelectedIndex(0);
//         patientTable.clearSelection();
//     }
// }

package gui;

import db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PatientPanel extends JFrame {
    private JTextField nameField, ageField, contactField, searchField;
    private JComboBox<String> genderBox;
    private JTextArea addressArea;
    private JTable patientTable;
    private DefaultTableModel model;

    public PatientPanel() {
        setTitle("Patient Management");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel topPanel = new JPanel(new BorderLayout());

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> dispose());
        topPanel.add(backButton, BorderLayout.WEST);

        // Search Bar
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton resetButton = new JButton("Reset");

        searchPanel.add(new JLabel("Search by ID or Name:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(resetButton);
        topPanel.add(searchPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Input Form Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Patient Details"));

        nameField = new JTextField();
        ageField = new JTextField();
        contactField = new JTextField();
        addressArea = new JTextArea(2, 20);
        genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});

        inputPanel.add(new JLabel("Name:")); inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:")); inputPanel.add(ageField);
        inputPanel.add(new JLabel("Gender:")); inputPanel.add(genderBox);
        inputPanel.add(new JLabel("Contact:")); inputPanel.add(contactField);
        inputPanel.add(new JLabel("Address:")); inputPanel.add(new JScrollPane(addressArea));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        JPanel formWrapper = new JPanel(new BorderLayout());
        formWrapper.add(inputPanel, BorderLayout.CENTER);
        formWrapper.add(buttonPanel, BorderLayout.SOUTH);
        add(formWrapper, BorderLayout.WEST);

        // Table setup
        model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Gender", "Contact", "Address"}, 0);
        patientTable = new JTable(model);
        add(new JScrollPane(patientTable), BorderLayout.CENTER);

        loadPatients();

        // On row click - populate form
        patientTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = patientTable.getSelectedRow();
                nameField.setText(model.getValueAt(row, 1).toString());
                ageField.setText(model.getValueAt(row, 2).toString());
                genderBox.setSelectedItem(model.getValueAt(row, 3).toString());
                contactField.setText(model.getValueAt(row, 4).toString());
                addressArea.setText(model.getValueAt(row, 5).toString());
            }
        });

        // Add
        addButton.addActionListener(e -> {
            try (Connection con = DBConnection.getConnection()) {
                String sql = "INSERT INTO patient (name, age, gender, contact, address) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nameField.getText());
                stmt.setInt(2, Integer.parseInt(ageField.getText()));
                stmt.setString(3, genderBox.getSelectedItem().toString());
                stmt.setString(4, contactField.getText());
                stmt.setString(5, addressArea.getText());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Patient added!");
                loadPatients();
                clearFields();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding patient.");
            }
        });

        // Update
        updateButton.addActionListener(e -> {
            int row = patientTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a patient to update.");
                return;
            }
            int id = Integer.parseInt(model.getValueAt(row, 0).toString());
            try (Connection con = DBConnection.getConnection()) {
                String sql = "UPDATE patient SET name=?, age=?, gender=?, contact=?, address=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nameField.getText());
                stmt.setInt(2, Integer.parseInt(ageField.getText()));
                stmt.setString(3, genderBox.getSelectedItem().toString());
                stmt.setString(4, contactField.getText());
                stmt.setString(5, addressArea.getText());
                stmt.setInt(6, id);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Patient updated!");
                loadPatients();
                clearFields();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating patient.");
            }
        });

        // Delete
        deleteButton.addActionListener(e -> {
            int row = patientTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a patient to delete.");
                return;
            }
            int id = Integer.parseInt(model.getValueAt(row, 0).toString());
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Delete Patient", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection con = DBConnection.getConnection()) {
                    String sql = "DELETE FROM patient WHERE id=?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setInt(1, id);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Patient deleted!");
                    loadPatients();
                    clearFields();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error deleting patient.");
                }
            }
        });

        // Clear fields
        clearButton.addActionListener(e -> clearFields());

        // Search
        searchButton.addActionListener(e -> searchPatients());
        resetButton.addActionListener(e -> {
            searchField.setText("");
            loadPatients();
        });
    }

    private void loadPatients() {
        model.setRowCount(0);
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM patient";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("contact"),
                        rs.getString("address")
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void searchPatients() {
        String query = searchField.getText().trim();
        if (query.isEmpty()) {
            loadPatients();
            return;
        }

        model.setRowCount(0);
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM patient WHERE id = ? OR name LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            try {
                stmt.setInt(1, Integer.parseInt(query));
            } catch (NumberFormatException e) {
                stmt.setInt(1, -1); // Invalid ID
            }
            stmt.setString(2, "%" + query + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("contact"),
                        rs.getString("address")
                });
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No matching patients found.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        contactField.setText("");
        addressArea.setText("");
        genderBox.setSelectedIndex(0);
        patientTable.clearSelection();
    }
}
