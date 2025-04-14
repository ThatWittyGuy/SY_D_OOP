// package gui;

// import db.DBConnection;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.sql.*;

// public class DiagnosePanel extends JFrame {
//     private JTable table;
//     private DefaultTableModel model;

//     private JTextField appointmentIdField;
//     private JTextField doctorIdField;
//     private JTextField diagnosisField;
//     private JTextField prescriptionField;
//     private JTextField searchField;

//     public DiagnosePanel() {
//         setTitle("Diagnosis Management");
//         setSize(900, 500);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         // Table setup
//         model = new DefaultTableModel();
//         table = new JTable(model);
//         model.setColumnIdentifiers(new Object[]{"Appointment ID", "Doctor ID", "Diagnosis", "Prescription"});
//         JScrollPane scrollPane = new JScrollPane(table);

//         // Form panel
//         JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
//         appointmentIdField = new JTextField();
//         doctorIdField = new JTextField();
//         diagnosisField = new JTextField();
//         prescriptionField = new JTextField();
//         searchField = new JTextField();

//         JButton addButton = new JButton("Add");
//         JButton updateButton = new JButton("Update");
//         JButton deleteButton = new JButton("Delete");
//         JButton searchButton = new JButton("Search");
//         JButton backButton = new JButton("Back");

//         inputPanel.add(new JLabel("Appointment ID:"));
//         inputPanel.add(appointmentIdField);
//         inputPanel.add(new JLabel("Doctor ID:"));
//         inputPanel.add(doctorIdField);
//         inputPanel.add(new JLabel("Diagnosis:"));
//         inputPanel.add(diagnosisField);
//         inputPanel.add(new JLabel("Prescription:"));
//         inputPanel.add(prescriptionField);
//         inputPanel.add(new JLabel("Search by Appointment ID:"));
//         inputPanel.add(searchField);
//         inputPanel.add(searchButton);
//         inputPanel.add(backButton);

//         // Button Panel
//         JPanel buttonPanel = new JPanel(new FlowLayout());
//         buttonPanel.add(addButton);
//         buttonPanel.add(updateButton);
//         buttonPanel.add(deleteButton);

//         // Add functionality
//         // addButton.addActionListener(e -> {
//         //     try (Connection conn = DBConnection.getConnection()) {
//         //         String sql = "INSERT INTO diagnose (appointment_id, doctor_id, diagnosis, prescription) VALUES (?, ?, ?, ?)";
//         //         PreparedStatement stmt = conn.prepareStatement(sql);
//         //         stmt.setInt(1, Integer.parseInt(appointmentIdField.getText()));
//         //         stmt.setInt(2, Integer.parseInt(doctorIdField.getText()));
//         //         stmt.setString(3, diagnosisField.getText());
//         //         stmt.setString(4, prescriptionField.getText());
//         //         stmt.executeUpdate();
//         //         JOptionPane.showMessageDialog(this, "Diagnosis added successfully.");
//         //         refreshTable();
//         //     } catch (SQLException ex) {
//         //         JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//         //         ex.printStackTrace();
//         //     }
//         // });
//         addButton.addActionListener(e -> {
//             try (Connection conn = DBConnection.getConnection()) {
//                 int appointmentId = Integer.parseInt(appointmentIdField.getText());
//                 int doctorId = Integer.parseInt(doctorIdField.getText());
        
//                 // Check if appointment exists with given appointment_id and doctor_id
//                 String checkSql = "SELECT * FROM appointment WHERE id = ? AND doctor_id = ?";
//                 PreparedStatement checkStmt = conn.prepareStatement(checkSql);
//                 checkStmt.setInt(1, appointmentId);
//                 checkStmt.setInt(2, doctorId);
//                 ResultSet rs = checkStmt.executeQuery();
        
//                 if (rs.next()) {
//                     String sql = "INSERT INTO diagnose (appointment_id, doctor_id, diagnosis, prescription) VALUES (?, ?, ?, ?)";
//                     PreparedStatement stmt = conn.prepareStatement(sql);
//                     stmt.setInt(1, appointmentId);
//                     stmt.setInt(2, doctorId);
//                     stmt.setString(3, diagnosisField.getText());
//                     stmt.setString(4, prescriptionField.getText());
//                     stmt.executeUpdate();
//                     JOptionPane.showMessageDialog(this, "Diagnosis added successfully.");
//                     refreshTable();
//                 } else {
//                     JOptionPane.showMessageDialog(this, "Invalid: No appointment found for the given doctor and appointment ID.");
//                 }
//             } catch (SQLException ex) {
//                 JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//                 ex.printStackTrace();
//             }
//         });
        

//         // Update functionality
//         // updateButton.addActionListener(e -> {
//         //     try (Connection conn = DBConnection.getConnection()) {
//         //         String sql = "UPDATE diagnose SET diagnosis = ?, prescription = ? WHERE appointment_id = ? AND doctor_id = ?";
//         //         PreparedStatement stmt = conn.prepareStatement(sql);
//         //         stmt.setString(1, diagnosisField.getText());
//         //         stmt.setString(2, prescriptionField.getText());
//         //         stmt.setInt(3, Integer.parseInt(appointmentIdField.getText()));
//         //         stmt.setInt(4, Integer.parseInt(doctorIdField.getText()));
//         //         int rows = stmt.executeUpdate();
//         //         if (rows > 0) {
//         //             JOptionPane.showMessageDialog(this, "Diagnosis updated successfully.");
//         //             refreshTable();
//         //         } else {
//         //             JOptionPane.showMessageDialog(this, "Diagnosis not found.");
//         //         }
//         //     } catch (SQLException ex) {
//         //         JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//         //         ex.printStackTrace();
//         //     }
//         // });

//         updateButton.addActionListener(e -> {
//             try (Connection conn = DBConnection.getConnection()) {
//                 int appointmentId = Integer.parseInt(appointmentIdField.getText());
//                 int doctorId = Integer.parseInt(doctorIdField.getText());
        
//                 // Check if appointment exists
//                 String checkSql = "SELECT * FROM appointment WHERE id = ? AND doctor_id = ?";
//                 PreparedStatement checkStmt = conn.prepareStatement(checkSql);
//                 checkStmt.setInt(1, appointmentId);
//                 checkStmt.setInt(2, doctorId);
//                 ResultSet rs = checkStmt.executeQuery();
        
//                 if (rs.next()) {
//                     String sql = "UPDATE diagnose SET diagnosis = ?, prescription = ? WHERE appointment_id = ? AND doctor_id = ?";
//                     PreparedStatement stmt = conn.prepareStatement(sql);
//                     stmt.setString(1, diagnosisField.getText());
//                     stmt.setString(2, prescriptionField.getText());
//                     stmt.setInt(3, appointmentId);
//                     stmt.setInt(4, doctorId);
//                     int rows = stmt.executeUpdate();
//                     if (rows > 0) {
//                         JOptionPane.showMessageDialog(this, "Diagnosis updated successfully.");
//                         refreshTable();
//                     } else {
//                         JOptionPane.showMessageDialog(this, "Diagnosis record not found to update.");
//                     }
//                 } else {
//                     JOptionPane.showMessageDialog(this, "Invalid: No appointment found for the given doctor and appointment ID.");
//                 }
//             } catch (SQLException ex) {
//                 JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//                 ex.printStackTrace();
//             }
//         });
        

//         // Delete functionality
//         deleteButton.addActionListener(e -> {
//             try (Connection conn = DBConnection.getConnection()) {
//                 String sql = "DELETE FROM diagnose WHERE appointment_id = ? AND doctor_id = ?";
//                 PreparedStatement stmt = conn.prepareStatement(sql);
//                 stmt.setInt(1, Integer.parseInt(appointmentIdField.getText()));
//                 stmt.setInt(2, Integer.parseInt(doctorIdField.getText()));
//                 int rows = stmt.executeUpdate();
//                 if (rows > 0) {
//                     JOptionPane.showMessageDialog(this, "Diagnosis deleted successfully.");
//                     refreshTable();
//                 } else {
//                     JOptionPane.showMessageDialog(this, "Diagnosis not found.");
//                 }
//             } catch (SQLException ex) {
//                 JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//                 ex.printStackTrace();
//             }
//         });

//         // Search functionality
//         searchButton.addActionListener(e -> {
//             String searchValue = searchField.getText().trim();
//             if (!searchValue.isEmpty()) {
//                 try (Connection conn = DBConnection.getConnection()) {
//                     String sql = "SELECT * FROM diagnose WHERE appointment_id = ?";
//                     PreparedStatement stmt = conn.prepareStatement(sql);
//                     stmt.setInt(1, Integer.parseInt(searchValue));
//                     ResultSet rs = stmt.executeQuery();
//                     model.setRowCount(0);
//                     while (rs.next()) {
//                         model.addRow(new Object[]{
//                                 rs.getInt("appointment_id"),
//                                 rs.getInt("doctor_id"),
//                                 rs.getString("diagnosis"),
//                                 rs.getString("prescription")
//                         });
//                     }
//                 } catch (SQLException ex) {
//                     JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//                     ex.printStackTrace();
//                 }
//             } else {
//                 refreshTable();
//             }
//         });

//         // Back functionality
//         backButton.addActionListener(e -> dispose());

//         // Table row selection fill
//         table.getSelectionModel().addListSelectionListener(e -> {
//             int selectedRow = table.getSelectedRow();
//             if (selectedRow != -1) {
//                 appointmentIdField.setText(model.getValueAt(selectedRow, 0).toString());
//                 doctorIdField.setText(model.getValueAt(selectedRow, 1).toString());
//                 diagnosisField.setText(model.getValueAt(selectedRow, 2).toString());
//                 prescriptionField.setText(model.getValueAt(selectedRow, 3).toString());
//             }
//         });

//         add(scrollPane, BorderLayout.CENTER);
//         add(inputPanel, BorderLayout.NORTH);
//         add(buttonPanel, BorderLayout.SOUTH);

//         refreshTable();
//     }

//     private void refreshTable() {
//         model.setRowCount(0);
//         try (Connection conn = DBConnection.getConnection()) {
//             String sql = "SELECT * FROM diagnose";
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql);
//             while (rs.next()) {
//                 model.addRow(new Object[]{
//                         rs.getInt("appointment_id"),
//                         rs.getInt("doctor_id"),
//                         rs.getString("diagnosis"),
//                         rs.getString("prescription")
//                 });
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }

package gui;

import db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiagnosePanel extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    private JComboBox<String> appointmentIdComboBox;
    private JComboBox<String> doctorIdComboBox;
    private JTextField diagnosisField;
    private JTextField prescriptionField;
    private JTextField searchField;

    public DiagnosePanel() {
        setTitle("Diagnosis Management");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Table setup
        model = new DefaultTableModel();
        table = new JTable(model);
        model.setColumnIdentifiers(new Object[]{"Appointment ID", "Doctor ID", "Diagnosis", "Prescription"});
        JScrollPane scrollPane = new JScrollPane(table);

        // Form panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        appointmentIdComboBox = new JComboBox<>();
        doctorIdComboBox = new JComboBox<>();
        diagnosisField = new JTextField();
        prescriptionField = new JTextField();
        searchField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton searchButton = new JButton("Search");
        JButton backButton = new JButton("Back");

        inputPanel.add(new JLabel("Appointment ID:"));
        inputPanel.add(appointmentIdComboBox);
        inputPanel.add(new JLabel("Doctor ID:"));
        inputPanel.add(doctorIdComboBox);
        inputPanel.add(new JLabel("Diagnosis:"));
        inputPanel.add(diagnosisField);
        inputPanel.add(new JLabel("Prescription:"));
        inputPanel.add(prescriptionField);
        inputPanel.add(new JLabel("Search by Appointment ID:"));
        inputPanel.add(searchField);
        inputPanel.add(searchButton);
        inputPanel.add(backButton);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Add functionality
        addButton.addActionListener(e -> {
            try (Connection conn = DBConnection.getConnection()) {
                int appointmentId = Integer.parseInt(appointmentIdComboBox.getSelectedItem().toString());
                int doctorId = Integer.parseInt(doctorIdComboBox.getSelectedItem().toString());

                // Check if appointment exists with given appointment_id and doctor_id
                String checkSql = "SELECT * FROM appointment WHERE id = ? AND doctor_id = ?";
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                checkStmt.setInt(1, appointmentId);
                checkStmt.setInt(2, doctorId);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    String sql = "INSERT INTO diagnose (appointment_id, doctor_id, diagnosis, prescription) VALUES (?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, appointmentId);
                    stmt.setInt(2, doctorId);
                    stmt.setString(3, diagnosisField.getText());
                    stmt.setString(4, prescriptionField.getText());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Diagnosis added successfully.");
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid: No appointment found for the given doctor and appointment ID.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Update functionality
        updateButton.addActionListener(e -> {
            try (Connection conn = DBConnection.getConnection()) {
                int appointmentId = Integer.parseInt(appointmentIdComboBox.getSelectedItem().toString());
                int doctorId = Integer.parseInt(doctorIdComboBox.getSelectedItem().toString());

                // Check if appointment exists
                String checkSql = "SELECT * FROM appointment WHERE id = ? AND doctor_id = ?";
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                checkStmt.setInt(1, appointmentId);
                checkStmt.setInt(2, doctorId);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    String sql = "UPDATE diagnose SET diagnosis = ?, prescription = ? WHERE appointment_id = ? AND doctor_id = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, diagnosisField.getText());
                    stmt.setString(2, prescriptionField.getText());
                    stmt.setInt(3, appointmentId);
                    stmt.setInt(4, doctorId);
                    int rows = stmt.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Diagnosis updated successfully.");
                        refreshTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Diagnosis record not found to update.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid: No appointment found for the given doctor and appointment ID.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Delete functionality
        deleteButton.addActionListener(e -> {
            try (Connection conn = DBConnection.getConnection()) {
                int appointmentId = Integer.parseInt(appointmentIdComboBox.getSelectedItem().toString());
                int doctorId = Integer.parseInt(doctorIdComboBox.getSelectedItem().toString());

                String sql = "DELETE FROM diagnose WHERE appointment_id = ? AND doctor_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, appointmentId);
                stmt.setInt(2, doctorId);
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Diagnosis deleted successfully.");
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Diagnosis not found.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Search functionality
        searchButton.addActionListener(e -> {
            String searchValue = searchField.getText().trim();
            if (!searchValue.isEmpty()) {
                try (Connection conn = DBConnection.getConnection()) {
                    String sql = "SELECT * FROM diagnose WHERE appointment_id = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, Integer.parseInt(searchValue));
                    ResultSet rs = stmt.executeQuery();
                    model.setRowCount(0);
                    while (rs.next()) {
                        model.addRow(new Object[]{
                                rs.getInt("appointment_id"),
                                rs.getInt("doctor_id"),
                                rs.getString("diagnosis"),
                                rs.getString("prescription")
                        });
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                refreshTable();
            }
        });

        // Back functionality
        backButton.addActionListener(e -> dispose());

        // Table row selection fill
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                appointmentIdComboBox.setSelectedItem(model.getValueAt(selectedRow, 0).toString());
                doctorIdComboBox.setSelectedItem(model.getValueAt(selectedRow, 1).toString());
                diagnosisField.setText(model.getValueAt(selectedRow, 2).toString());
                prescriptionField.setText(model.getValueAt(selectedRow, 3).toString());
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        populateComboBoxes();
        refreshTable();
    }

    private void populateComboBoxes() {
        try (Connection conn = DBConnection.getConnection()) {
            // Populate Appointment ID combo box
            String appointmentSql = "SELECT id FROM appointment";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(appointmentSql);
            while (rs.next()) {
                appointmentIdComboBox.addItem(String.valueOf(rs.getInt("id")));
            }

            // Populate Doctor ID combo box
            String doctorSql = "SELECT id FROM doctor";
            rs = stmt.executeQuery(doctorSql);
            while (rs.next()) {
                doctorIdComboBox.addItem(String.valueOf(rs.getInt("id")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void refreshTable() {
        model.setRowCount(0);
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM diagnose";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("appointment_id"),
                        rs.getInt("doctor_id"),
                        rs.getString("diagnosis"),
                        rs.getString("prescription")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
