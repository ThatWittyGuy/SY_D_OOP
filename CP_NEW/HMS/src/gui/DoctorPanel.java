// package gui;

// import db.DBConnection;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class DoctorPanel extends JFrame {

//     private JTextField nameField, specializationField, contactField;
//     private JCheckBox availableCheckBox;
//     private JTable doctorTable;
//     private DefaultTableModel model;

//     public DoctorPanel() {
//         setTitle("Doctor Management");
//         setSize(700, 500);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//         // Layout
//         JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
//         panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

//         panel.add(new JLabel("Name:"));
//         nameField = new JTextField();
//         panel.add(nameField);

//         panel.add(new JLabel("Specialization:"));
//         specializationField = new JTextField();
//         panel.add(specializationField);

//         panel.add(new JLabel("Contact:"));
//         contactField = new JTextField();
//         panel.add(contactField);

//         panel.add(new JLabel("Available:"));
//         availableCheckBox = new JCheckBox();
//         panel.add(availableCheckBox);

//         JButton addButton = new JButton("Add Doctor");
//         panel.add(addButton);

//         JButton refreshButton = new JButton("Refresh List");
//         panel.add(refreshButton);

//         add(panel, BorderLayout.NORTH);

//         // Table
//         model = new DefaultTableModel(new String[]{"ID", "Name", "Specialization", "Contact", "Available"}, 0);
//         doctorTable = new JTable(model);
//         add(new JScrollPane(doctorTable), BorderLayout.CENTER);

//         // Button actions
//         addButton.addActionListener(e -> addDoctor());
//         refreshButton.addActionListener(e -> loadDoctors());

//         loadDoctors();
//     }

//     private void addDoctor() {
//         String name = nameField.getText();
//         String spec = specializationField.getText();
//         String contact = contactField.getText();
//         boolean available = availableCheckBox.isSelected();

//         if (name.isEmpty() || spec.isEmpty() || contact.isEmpty()) {
//             JOptionPane.showMessageDialog(this, "Please fill all fields.");
//             return;
//         }

//         try (Connection conn = DBConnection.getConnection()) {
//             String sql = "INSERT INTO doctor (name, specialization, contact, available) VALUES (?, ?, ?, ?)";
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             stmt.setString(1, name);
//             stmt.setString(2, spec);
//             stmt.setString(3, contact);
//             stmt.setBoolean(4, available);

//             int rows = stmt.executeUpdate();
//             if (rows > 0) {
//                 JOptionPane.showMessageDialog(this, "Doctor added successfully.");
//                 loadDoctors();
//                 nameField.setText("");
//                 specializationField.setText("");
//                 contactField.setText("");
//                 availableCheckBox.setSelected(false);
//             }
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void loadDoctors() {
//         model.setRowCount(0); // Clear existing rows

//         try (Connection conn = DBConnection.getConnection()) {
//             String sql = "SELECT * FROM doctor";
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql);

//             while (rs.next()) {
//                 model.addRow(new Object[]{
//                         rs.getInt("id"),
//                         rs.getString("name"),
//                         rs.getString("specialization"),
//                         rs.getString("contact"),
//                         rs.getBoolean("available") ? "Yes" : "No"
//                 });
//             }
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }
// }

// NEWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW
// package gui;

// import db.DBConnection;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class DoctorPanel extends JFrame {
//     private JTextField nameField, specializationField, contactField;
//     private JCheckBox availableCheckBox;
//     private JTable doctorTable;
//     private DefaultTableModel model;

//     public DoctorPanel() {
//         setTitle("Doctor Management");
//         setSize(800, 550);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//         JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
//         panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        
//         panel.add(new JLabel("Name:"));
//         nameField = new JTextField();
//         panel.add(nameField);

//         panel.add(new JLabel("Specialization:"));
//         specializationField = new JTextField();
//         panel.add(specializationField);

//         panel.add(new JLabel("Contact:"));
//         contactField = new JTextField();
//         panel.add(contactField);

//         panel.add(new JLabel("Available:"));
//         availableCheckBox = new JCheckBox();
//         panel.add(availableCheckBox);

//         JButton addButton = new JButton("Add Doctor");
//         panel.add(addButton);

//         JButton refreshButton = new JButton("Refresh List");
//         panel.add(refreshButton);

//         add(panel, BorderLayout.NORTH);

//         model = new DefaultTableModel(new String[]{"ID", "Name", "Specialization", "Contact", "Available"}, 0);
//         doctorTable = new JTable(model);
//         doctorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//         JScrollPane scrollPane = new JScrollPane(doctorTable);
//         add(scrollPane, BorderLayout.CENTER);

//         JPanel actionPanel = new JPanel();
//         JButton editButton = new JButton("Edit Selected");
//         JButton deleteButton = new JButton("Delete Selected");
//         actionPanel.add(editButton);
//         actionPanel.add(deleteButton);
//         add(actionPanel, BorderLayout.SOUTH);

//         // Button actions
//         addButton.addActionListener(e -> addDoctor());
//         refreshButton.addActionListener(e -> loadDoctors());
//         editButton.addActionListener(e -> editDoctor());
//         deleteButton.addActionListener(e -> deleteDoctor());

//         loadDoctors();
//     }

//     private void addDoctor() {
//         String name = nameField.getText();
//         String spec = specializationField.getText();
//         String contact = contactField.getText();
//         boolean available = availableCheckBox.isSelected();

//         if (name.isEmpty() || spec.isEmpty() || contact.isEmpty()) {
//             JOptionPane.showMessageDialog(this, "Please fill all fields.");
//             return;
//         }

//         try (Connection conn = DBConnection.getConnection()) {
//             String sql = "INSERT INTO doctor (name, specialization, contact, available) VALUES (?, ?, ?, ?)";
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             stmt.setString(1, name);
//             stmt.setString(2, spec);
//             stmt.setString(3, contact);
//             stmt.setBoolean(4, available);
//             stmt.executeUpdate();

//             JOptionPane.showMessageDialog(this, "Doctor added successfully.");
//             clearFields();
//             loadDoctors();
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void loadDoctors() {
//         model.setRowCount(0);
//         try (Connection conn = DBConnection.getConnection()) {
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM doctor");

//             while (rs.next()) {
//                 model.addRow(new Object[]{
//                         rs.getInt("id"),
//                         rs.getString("name"),
//                         rs.getString("specialization"),
//                         rs.getString("contact"),
//                         rs.getBoolean("available") ? "Yes" : "No"
//                 });
//             }
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void editDoctor() {
//         int selectedRow = doctorTable.getSelectedRow();
//         if (selectedRow == -1) {
//             JOptionPane.showMessageDialog(this, "Please select a row to edit.");
//             return;
//         }

//         int id = (int) model.getValueAt(selectedRow, 0);
//         String name = nameField.getText();
//         String spec = specializationField.getText();
//         String contact = contactField.getText();
//         boolean available = availableCheckBox.isSelected();

//         if (name.isEmpty() || spec.isEmpty() || contact.isEmpty()) {
//             JOptionPane.showMessageDialog(this, "Please fill all fields.");
//             return;
//         }

//         try (Connection conn = DBConnection.getConnection()) {
//             String sql = "UPDATE doctor SET name=?, specialization=?, contact=?, available=? WHERE id=?";
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             stmt.setString(1, name);
//             stmt.setString(2, spec);
//             stmt.setString(3, contact);
//             stmt.setBoolean(4, available);
//             stmt.setInt(5, id);
//             stmt.executeUpdate();

//             JOptionPane.showMessageDialog(this, "Doctor updated successfully.");
//             clearFields();
//             loadDoctors();
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void deleteDoctor() {
//         int selectedRow = doctorTable.getSelectedRow();
//         if (selectedRow == -1) {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//             return;
//         }

//         int id = (int) model.getValueAt(selectedRow, 0);

//         int confirm = JOptionPane.showConfirmDialog(this,
//                 "Are you sure you want to delete this doctor?",
//                 "Confirm Delete", JOptionPane.YES_NO_OPTION);

//         if (confirm != JOptionPane.YES_OPTION) return;

//         try (Connection conn = DBConnection.getConnection()) {
//             String sql = "DELETE FROM doctor WHERE id=?";
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             stmt.setInt(1, id);
//             stmt.executeUpdate();

//             JOptionPane.showMessageDialog(this, "Doctor deleted successfully.");
//             loadDoctors();
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void clearFields() {
//         nameField.setText("");
//         specializationField.setText("");
//         contactField.setText("");
//         availableCheckBox.setSelected(false);
//     }
// }

// BEFORE SEARCHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH

// package gui;

// import db.DBConnection;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class DoctorPanel extends JFrame {
//     private JTextField nameField, specializationField, contactField;
//     private JCheckBox availableCheckBox;
//     private JTable doctorTable;
//     private DefaultTableModel model;

//     public DoctorPanel() {
//         setTitle("Doctor Management");
//         setSize(800, 600);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setLayout(new BorderLayout());

//         // Form Panel
//         JPanel formPanel = new JPanel();
//         formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
//         formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

//         // Name
//         formPanel.add(createFieldRow("Name:", nameField = new JTextField()));
//         formPanel.add(Box.createVerticalStrut(10));

//         // Specialization
//         formPanel.add(createFieldRow("Specialization:", specializationField = new JTextField()));
//         formPanel.add(Box.createVerticalStrut(10));

//         // Contact
//         formPanel.add(createFieldRow("Contact:", contactField = new JTextField()));
//         formPanel.add(Box.createVerticalStrut(10));

//         // Availability
//         JPanel availablePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         availablePanel.add(new JLabel("Available:"));
//         availableCheckBox = new JCheckBox();
//         availablePanel.add(availableCheckBox);
//         formPanel.add(availablePanel);
//         formPanel.add(Box.createVerticalStrut(15));

//         // Buttons
//         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         JButton addButton = new JButton("Add Doctor");
//         JButton refreshButton = new JButton("Refresh List");
//         JButton backButton = new JButton("Back");
//         buttonPanel.add(addButton);
//         buttonPanel.add(refreshButton);
//         buttonPanel.add(backButton);
//         formPanel.add(buttonPanel);

//         add(formPanel, BorderLayout.NORTH);

//         // Table
//         model = new DefaultTableModel(new String[]{"ID", "Name", "Specialization", "Contact", "Available"}, 0);
//         doctorTable = new JTable(model);
//         doctorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//         JScrollPane scrollPane = new JScrollPane(doctorTable);
//         add(scrollPane, BorderLayout.CENTER);

//         // Edit/Delete Panel
//         JPanel actionPanel = new JPanel();
//         JButton editButton = new JButton("Edit Selected");
//         JButton deleteButton = new JButton("Delete Selected");
//         actionPanel.add(editButton);
//         actionPanel.add(deleteButton);
//         add(actionPanel, BorderLayout.SOUTH);

//         // Button Actions
//         addButton.addActionListener(e -> addDoctor());
//         refreshButton.addActionListener(e -> loadDoctors());
//         editButton.addActionListener(e -> editDoctor());
//         deleteButton.addActionListener(e -> deleteDoctor());
//         backButton.addActionListener(e -> {
//             new Dashboard().setVisible(true);
//             dispose(); // Close current window
//         });

//         loadDoctors();
//     }

//     private JPanel createFieldRow(String labelText, JTextField textField) {
//         JPanel panel = new JPanel(new BorderLayout(10, 5));
//         panel.add(new JLabel(labelText), BorderLayout.WEST);
//         panel.add(textField, BorderLayout.CENTER);
//         return panel;
//     }

//     private void addDoctor() {
//         String name = nameField.getText();
//         String spec = specializationField.getText();
//         String contact = contactField.getText();
//         boolean available = availableCheckBox.isSelected();

//         if (name.isEmpty() || spec.isEmpty() || contact.isEmpty()) {
//             JOptionPane.showMessageDialog(this, "Please fill all fields.");
//             return;
//         }

//         try (Connection conn = DBConnection.getConnection()) {
//             String sql = "INSERT INTO doctor (name, specialization, contact, available) VALUES (?, ?, ?, ?)";
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             stmt.setString(1, name);
//             stmt.setString(2, spec);
//             stmt.setString(3, contact);
//             stmt.setBoolean(4, available);
//             stmt.executeUpdate();

//             JOptionPane.showMessageDialog(this, "Doctor added successfully.");
//             clearFields();
//             loadDoctors();
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void loadDoctors() {
//         model.setRowCount(0);
//         try (Connection conn = DBConnection.getConnection()) {
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM doctor");

//             while (rs.next()) {
//                 model.addRow(new Object[]{
//                         rs.getInt("id"),
//                         rs.getString("name"),
//                         rs.getString("specialization"),
//                         rs.getString("contact"),
//                         rs.getBoolean("available") ? "Yes" : "No"
//                 });
//             }
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void editDoctor() {
//         int selectedRow = doctorTable.getSelectedRow();
//         if (selectedRow == -1) {
//             JOptionPane.showMessageDialog(this, "Please select a row to edit.");
//             return;
//         }

//         int id = (int) model.getValueAt(selectedRow, 0);
//         String name = nameField.getText();
//         String spec = specializationField.getText();
//         String contact = contactField.getText();
//         boolean available = availableCheckBox.isSelected();

//         if (name.isEmpty() || spec.isEmpty() || contact.isEmpty()) {
//             JOptionPane.showMessageDialog(this, "Please fill all fields.");
//             return;
//         }

//         try (Connection conn = DBConnection.getConnection()) {
//             String sql = "UPDATE doctor SET name=?, specialization=?, contact=?, available=? WHERE id=?";
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             stmt.setString(1, name);
//             stmt.setString(2, spec);
//             stmt.setString(3, contact);
//             stmt.setBoolean(4, available);
//             stmt.setInt(5, id);
//             stmt.executeUpdate();

//             JOptionPane.showMessageDialog(this, "Doctor updated successfully.");
//             clearFields();
//             loadDoctors();
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void deleteDoctor() {
//         int selectedRow = doctorTable.getSelectedRow();
//         if (selectedRow == -1) {
//             JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//             return;
//         }

//         int id = (int) model.getValueAt(selectedRow, 0);

//         int confirm = JOptionPane.showConfirmDialog(this,
//                 "Are you sure you want to delete this doctor?",
//                 "Confirm Delete", JOptionPane.YES_NO_OPTION);

//         if (confirm != JOptionPane.YES_OPTION) return;

//         try (Connection conn = DBConnection.getConnection()) {
//             String sql = "DELETE FROM doctor WHERE id=?";
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             stmt.setInt(1, id);
//             stmt.executeUpdate();

//             JOptionPane.showMessageDialog(this, "Doctor deleted successfully.");
//             loadDoctors();
//         } catch (SQLException ex) {
//             ex.printStackTrace();
//         }
//     }

//     private void clearFields() {
//         nameField.setText("");
//         specializationField.setText("");
//         contactField.setText("");
//         availableCheckBox.setSelected(false);
//         doctorTable.clearSelection();
//     }
// }

package gui;

import db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DoctorPanel extends JFrame {
    private JTextField nameField, specializationField, contactField;
    private JCheckBox availableCheckBox;

    private JTable doctorTable;
    private DefaultTableModel model;

    private JTextField searchSpecializationField;
    private JCheckBox searchAvailableCheckBox;

    public DoctorPanel() {
        setTitle("Doctor Management");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // ==== Form Panel ====
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        formPanel.add(createFieldRow("Name:", nameField = new JTextField()));
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(createFieldRow("Specialization:", specializationField = new JTextField()));
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(createFieldRow("Contact:", contactField = new JTextField()));
        formPanel.add(Box.createVerticalStrut(10));

        JPanel availablePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        availablePanel.add(new JLabel("Available:"));
        availableCheckBox = new JCheckBox();
        availablePanel.add(availableCheckBox);
        formPanel.add(availablePanel);
        formPanel.add(Box.createVerticalStrut(15));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add Doctor");
        JButton refreshButton = new JButton("Refresh List");
        JButton backButton = new JButton("Back");
        buttonPanel.add(addButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);
        formPanel.add(buttonPanel);

        add(formPanel, BorderLayout.NORTH);

        // ==== Table ====
        model = new DefaultTableModel(new String[]{"ID", "Name", "Specialization", "Contact", "Available"}, 0);
        doctorTable = new JTable(model);
        doctorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(doctorTable), BorderLayout.CENTER);

        // ==== Action Buttons ====
        JPanel actionPanel = new JPanel();
        JButton editButton = new JButton("Edit Selected");
        JButton deleteButton = new JButton("Delete Selected");
        actionPanel.add(editButton);
        actionPanel.add(deleteButton);
        add(actionPanel, BorderLayout.SOUTH);

        // ==== Search Panel ====
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search Doctors"));

        searchPanel.add(new JLabel("Specialization:"));
        searchSpecializationField = new JTextField(15);
        searchPanel.add(searchSpecializationField);

        searchAvailableCheckBox = new JCheckBox("Available Only");
        searchPanel.add(searchAvailableCheckBox);

        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.WEST);

        // ==== Button Actions ====
        addButton.addActionListener(e -> addDoctor());
        refreshButton.addActionListener(e -> loadDoctors());
        editButton.addActionListener(e -> editDoctor());
        deleteButton.addActionListener(e -> deleteDoctor());
        backButton.addActionListener(e -> dispose());
        searchButton.addActionListener(e -> searchDoctors());

        loadDoctors();
    }

    private JPanel createFieldRow(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new BorderLayout(10, 5));
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    private void addDoctor() {
        String name = nameField.getText();
        String spec = specializationField.getText();
        String contact = contactField.getText();
        boolean available = availableCheckBox.isSelected();

        if (name.isEmpty() || spec.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO doctor (name, specialization, contact, available) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, spec);
            stmt.setString(3, contact);
            stmt.setBoolean(4, available);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Doctor added successfully.");
            clearFields();
            loadDoctors();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadDoctors() {
        model.setRowCount(0);
        try (Connection conn = DBConnection.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM doctor");
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getString("contact"),
                        rs.getBoolean("available") ? "Yes" : "No"
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void searchDoctors() {
        String specialization = searchSpecializationField.getText().trim();
        boolean availableOnly = searchAvailableCheckBox.isSelected();

        model.setRowCount(0);

        try (Connection conn = DBConnection.getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT * FROM doctor WHERE 1=1");
            if (!specialization.isEmpty()) {
                sql.append(" AND specialization LIKE ?");
            }
            if (availableOnly) {
                sql.append(" AND available = true");
            }

            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            if (!specialization.isEmpty()) {
                stmt.setString(1, "%" + specialization + "%");
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getString("contact"),
                        rs.getBoolean("available") ? "Yes" : "No"
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void editDoctor() {
        int row = doctorTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.");
            return;
        }

        int id = (int) model.getValueAt(row, 0);
        String name = nameField.getText();
        String spec = specializationField.getText();
        String contact = contactField.getText();
        boolean available = availableCheckBox.isSelected();

        if (name.isEmpty() || spec.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE doctor SET name=?, specialization=?, contact=?, available=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, spec);
            stmt.setString(3, contact);
            stmt.setBoolean(4, available);
            stmt.setInt(5, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Doctor updated successfully.");
            clearFields();
            loadDoctors();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteDoctor() {
        int row = doctorTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        int id = (int) model.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = DBConnection.getConnection()) {
                String sql = "DELETE FROM doctor WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Doctor deleted successfully.");
                loadDoctors();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void clearFields() {
        nameField.setText("");
        specializationField.setText("");
        contactField.setText("");
        availableCheckBox.setSelected(false);
        doctorTable.clearSelection();
    }
}
