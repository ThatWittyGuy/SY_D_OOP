// package gui;

// import db.DBConnection;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class MedicalHistoryPanel extends JFrame {
//     private JTable table;
//     private DefaultTableModel model;

//     public MedicalHistoryPanel() {
//         setTitle("Medical History");
//         setSize(800, 400);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setLayout(new BorderLayout());

//         model = new DefaultTableModel(new String[]{"ID", "Date", "Condition", "Surgeries", "Medication"}, 0);
//         table = new JTable(model);
//         JScrollPane scrollPane = new JScrollPane(table);
//         add(scrollPane, BorderLayout.CENTER);

//         JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
//         JTextField idField = new JTextField();
//         JTextField dateField = new JTextField("YYYY-MM-DD");
//         JTextField conditionField = new JTextField();
//         JTextField surgeriesField = new JTextField();
//         JTextField medicationField = new JTextField();

//         formPanel.add(new JLabel("ID:"));
//         formPanel.add(idField);
//         formPanel.add(new JLabel("Date:"));
//         formPanel.add(dateField);
//         formPanel.add(new JLabel("Condition:"));
//         formPanel.add(conditionField);
//         formPanel.add(new JLabel("Surgeries:"));
//         formPanel.add(surgeriesField);
//         formPanel.add(new JLabel("Medication:"));
//         formPanel.add(medicationField);
//         add(formPanel, BorderLayout.NORTH);

//         JButton addBtn = new JButton("Add Record");
//         JButton refreshBtn = new JButton("Refresh");

//         JPanel btnPanel = new JPanel();
//         btnPanel.add(addBtn);
//         btnPanel.add(refreshBtn);
//         add(btnPanel, BorderLayout.SOUTH);

//         addBtn.addActionListener(e -> {
//             try (Connection con = DBConnection.getConnection();
//                  PreparedStatement stmt = con.prepareStatement("INSERT INTO medical_history VALUES (?, ?, ?, ?, ?)")) {
//                 stmt.setInt(1, Integer.parseInt(idField.getText()));
//                 stmt.setDate(2, Date.valueOf(dateField.getText()));
//                 stmt.setString(3, conditionField.getText());
//                 stmt.setString(4, surgeriesField.getText());
//                 stmt.setString(5, medicationField.getText());
//                 stmt.executeUpdate();
//                 JOptionPane.showMessageDialog(this, "Record added successfully.");
//                 refreshTable();
//             } catch (Exception ex) {
//                 ex.printStackTrace();
//                 JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//             }
//         });

//         refreshBtn.addActionListener(e -> refreshTable());

//         refreshTable();
//     }

//     private void refreshTable() {
//         model.setRowCount(0);
//         try (Connection con = DBConnection.getConnection();
//              Statement stmt = con.createStatement();
//              ResultSet rs = stmt.executeQuery("SELECT * FROM medical_history")) {
//             while (rs.next()) {
//                 model.addRow(new Object[]{
//                         rs.getInt("id"),
//                         rs.getDate("date"),
//                         rs.getString("conditions"),
//                         rs.getString("surgeries"),
//                         rs.getString("medication")
//                 });
//             }
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }
//     }
// }

package gui;

import db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MedicalHistoryPanel extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField searchField;

    public MedicalHistoryPanel() {
        setTitle("Medical History");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        model = new DefaultTableModel(new String[]{"ID", "Date", "Condition", "Surgeries", "Medication"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Form panel for CRUD operations
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        JTextField idField = new JTextField();
        JTextField dateField = new JTextField("YYYY-MM-DD");
        JTextField conditionField = new JTextField();
        JTextField surgeriesField = new JTextField();
        JTextField medicationField = new JTextField();

        formPanel.add(new JLabel("Patient ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Date:"));
        formPanel.add(dateField);
        formPanel.add(new JLabel("Condition:"));
        formPanel.add(conditionField);
        formPanel.add(new JLabel("Surgeries:"));
        formPanel.add(surgeriesField);
        formPanel.add(new JLabel("Medication:"));
        formPanel.add(medicationField);
        add(formPanel, BorderLayout.NORTH);

        // Button panel for CRUD actions
        JButton addBtn = new JButton("Add Record");
        JButton updateBtn = new JButton("Update Record");
        JButton deleteBtn = new JButton("Delete Record");
        JButton refreshBtn = new JButton("Refresh");
        JButton backBtn = new JButton("Back");

        JPanel btnPanel = new JPanel();
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(refreshBtn);
        btnPanel.add(backBtn);
        add(btnPanel, BorderLayout.SOUTH);

        // Search panel
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search by Condition:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        JButton searchBtn = new JButton("Search");
        searchPanel.add(searchBtn);
        add(searchPanel, BorderLayout.WEST);

        // Add action listeners
        addBtn.addActionListener(e -> addRecord(idField, dateField, conditionField, surgeriesField, medicationField));
        updateBtn.addActionListener(e -> updateRecord(idField, dateField, conditionField, surgeriesField, medicationField));
        deleteBtn.addActionListener(e -> deleteRecord(idField));
        refreshBtn.addActionListener(e -> refreshTable());
        searchBtn.addActionListener(e -> searchRecord());

        backBtn.addActionListener(e -> goBack());

        // Load data into table
        refreshTable();
    }

    private void addRecord(JTextField idField, JTextField dateField, JTextField conditionField, JTextField surgeriesField, JTextField medicationField) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement("INSERT INTO medical_history (id, date, conditions, surgeries, medication) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.setDate(2, Date.valueOf(dateField.getText()));
            stmt.setString(3, conditionField.getText());
            stmt.setString(4, surgeriesField.getText());
            stmt.setString(5, medicationField.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record added successfully.");
            refreshTable();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void updateRecord(JTextField idField, JTextField dateField, JTextField conditionField, JTextField surgeriesField, JTextField medicationField) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement("UPDATE medical_history SET date = ?, conditions = ?, surgeries = ?, medication = ? WHERE id = ?")) {
            stmt.setDate(1, Date.valueOf(dateField.getText()));
            stmt.setString(2, conditionField.getText());
            stmt.setString(3, surgeriesField.getText());
            stmt.setString(4, medicationField.getText());
            stmt.setInt(5, Integer.parseInt(idField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record updated successfully.");
            refreshTable();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void deleteRecord(JTextField idField) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement("DELETE FROM medical_history WHERE id = ?")) {
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record deleted successfully.");
            refreshTable();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void refreshTable() {
        model.setRowCount(0);
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM medical_history")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getDate("date"),
                        rs.getString("conditions"),
                        rs.getString("surgeries"),
                        rs.getString("medication")
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void searchRecord() {
        String searchTerm = searchField.getText();
        model.setRowCount(0); // Clear current table

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM medical_history WHERE conditions LIKE ?")) {
            stmt.setString(1, "%" + searchTerm + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getDate("date"),
                        rs.getString("conditions"),
                        rs.getString("surgeries"),
                        rs.getString("medication")
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void goBack() {
        this.dispose();  // Close current window
    }
}
