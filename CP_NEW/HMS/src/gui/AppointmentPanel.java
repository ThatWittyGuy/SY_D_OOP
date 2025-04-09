// package gui;

// import db.DBConnection;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.sql.*;
// import java.util.Vector;

// public class AppointmentPanel extends JFrame {

//     private JComboBox<String> patientComboBox, doctorComboBox;
//     private JTextField dateField, timeField, reasonField;
//     private DefaultTableModel tableModel;
//     private JTable appointmentTable;

//     public AppointmentPanel() {
//         setTitle("Appointment Scheduler");
//         setSize(800, 500);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//         JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
//         formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

//         patientComboBox = new JComboBox<>();
//         doctorComboBox = new JComboBox<>();
//         dateField = new JTextField("YYYY-MM-DD");
//         timeField = new JTextField("HH:MM:SS");
//         reasonField = new JTextField();

//         formPanel.add(new JLabel("Patient:"));
//         formPanel.add(patientComboBox);

//         formPanel.add(new JLabel("Doctor:"));
//         formPanel.add(doctorComboBox);

//         formPanel.add(new JLabel("Date:"));
//         formPanel.add(dateField);

//         formPanel.add(new JLabel("Time:"));
//         formPanel.add(timeField);

//         formPanel.add(new JLabel("Reason:"));
//         formPanel.add(reasonField);

//         JButton bookBtn = new JButton("Book Appointment");
//         formPanel.add(bookBtn);

//         JButton refreshBtn = new JButton("Refresh");
//         formPanel.add(refreshBtn);

//         add(formPanel, BorderLayout.NORTH);

//         // Table setup
//         tableModel = new DefaultTableModel(new String[]{"ID", "Patient", "Doctor", "Date", "Time", "Reason"}, 0);
//         appointmentTable = new JTable(tableModel);
//         add(new JScrollPane(appointmentTable), BorderLayout.CENTER);

//         // Load data
//         loadPatients();
//         loadDoctors();
//         loadAppointments();

//         bookBtn.addActionListener(e -> bookAppointment());
//         refreshBtn.addActionListener(e -> loadAppointments());
//     }

//     private void loadPatients() {
//         try (Connection con = DBConnection.getConnection()) {
//             String sql = "SELECT id, name FROM patient";
//             Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(sql);
//             patientComboBox.removeAllItems();
//             while (rs.next()) {
//                 patientComboBox.addItem(rs.getInt("id") + " - " + rs.getString("name"));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     private void loadDoctors() {
//         try (Connection con = DBConnection.getConnection()) {
//             String sql = "SELECT id, name FROM doctor WHERE available = TRUE";
//             Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(sql);
//             doctorComboBox.removeAllItems();
//             while (rs.next()) {
//                 doctorComboBox.addItem(rs.getInt("id") + " - " + rs.getString("name"));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     private void loadAppointments() {
//         tableModel.setRowCount(0);
//         try (Connection con = DBConnection.getConnection()) {
//             String sql = "SELECT a.id, p.name AS patient, d.name AS doctor, a.appointment_date, a.appointment_time, a.reason " +
//                          "FROM appointment a JOIN patient p ON a.patient_id = p.id " +
//                          "JOIN doctor d ON a.doctor_id = d.id";
//             Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(sql);
//             while (rs.next()) {
//                 tableModel.addRow(new Object[]{
//                         rs.getInt("id"),
//                         rs.getString("patient"),
//                         rs.getString("doctor"),
//                         rs.getDate("appointment_date"),
//                         rs.getTime("appointment_time"),
//                         rs.getString("reason")
//                 });
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     private void bookAppointment() {
//         String patient = (String) patientComboBox.getSelectedItem();
//         String doctor = (String) doctorComboBox.getSelectedItem();
//         String date = dateField.getText();
//         String time = timeField.getText();
//         String reason = reasonField.getText();

//         if (patient == null || doctor == null || date.isEmpty() || time.isEmpty() || reason.isEmpty()) {
//             JOptionPane.showMessageDialog(this, "Please fill all fields.");
//             return;
//         }

//         int patientId = Integer.parseInt(patient.split(" - ")[0]);
//         int doctorId = Integer.parseInt(doctor.split(" - ")[0]);

//         try (Connection con = DBConnection.getConnection()) {
//             String sql = "INSERT INTO appointment (patient_id, doctor_id, appointment_date, appointment_time, reason) VALUES (?, ?, ?, ?, ?)";
//             PreparedStatement stmt = con.prepareStatement(sql);
//             stmt.setInt(1, patientId);
//             stmt.setInt(2, doctorId);
//             stmt.setString(3, date);
//             stmt.setString(4, time);
//             stmt.setString(5, reason);

//             int rows = stmt.executeUpdate();
//             if (rows > 0) {
//                 JOptionPane.showMessageDialog(this, "Appointment booked!");
//                 loadAppointments();
//                 reasonField.setText("");
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
import java.util.Vector;

public class AppointmentPanel extends JFrame {
    private JComboBox<String> patientComboBox, doctorComboBox;
    private JTextField dateField, timeField, reasonField;
    private JTable appointmentTable;
    private DefaultTableModel model;

    public AppointmentPanel() {
        setTitle("Manage Appointments");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // === Form Panel ===
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        panel.add(new JLabel("Patient:"));
        patientComboBox = new JComboBox<>();
        panel.add(patientComboBox);

        panel.add(new JLabel("Doctor:"));
        doctorComboBox = new JComboBox<>();
        panel.add(doctorComboBox);

        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        panel.add(dateField);

        panel.add(new JLabel("Time (HH:MM:SS):"));
        timeField = new JTextField();
        panel.add(timeField);

        panel.add(new JLabel("Reason:"));
        reasonField = new JTextField();
        panel.add(reasonField);

        // === Button Panel ===
        JButton addButton = new JButton("Add Appointment");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(addButton);
        btnPanel.add(updateButton);
        btnPanel.add(deleteButton);
        btnPanel.add(clearButton);

        // === Wrap form and buttons together ===
        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.add(panel, BorderLayout.CENTER);
        formPanel.add(btnPanel, BorderLayout.SOUTH);
        add(formPanel, BorderLayout.NORTH);

        // === Table Setup ===
        model = new DefaultTableModel(new String[]{"ID", "Patient", "Doctor", "Date", "Time", "Reason"}, 0);
        appointmentTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(appointmentTable);
        add(scrollPane, BorderLayout.CENTER);

        // === Load Initial Data ===
        loadPatients();
        loadDoctors();
        loadAppointments();

        // === Action Listeners ===
        addButton.addActionListener(e -> addAppointment());
        updateButton.addActionListener(e -> updateAppointment());
        deleteButton.addActionListener(e -> deleteAppointment());
        clearButton.addActionListener(e -> clearFields());

        appointmentTable.getSelectionModel().addListSelectionListener(e -> populateFieldsFromTable());
    }

    private void loadPatients() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id, name FROM patient";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            patientComboBox.removeAllItems();
            while (rs.next()) {
                patientComboBox.addItem(rs.getInt("id") + " - " + rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadDoctors() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id, name FROM doctor WHERE available = true";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            doctorComboBox.removeAllItems();
            while (rs.next()) {
                doctorComboBox.addItem(rs.getInt("id") + " - " + rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadAppointments() {
        model.setRowCount(0);
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT a.id, p.name AS patient, d.name AS doctor, a.appointment_date, a.appointment_time, a.reason " +
                         "FROM appointment a " +
                         "JOIN patient p ON a.patient_id = p.id " +
                         "JOIN doctor d ON a.doctor_id = d.id";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("id"));
                row.add(rs.getString("patient"));
                row.add(rs.getString("doctor"));
                row.add(rs.getDate("appointment_date").toString());
                row.add(rs.getTime("appointment_time").toString());
                row.add(rs.getString("reason"));
                model.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addAppointment() {
        try {
            int patientId = Integer.parseInt(patientComboBox.getSelectedItem().toString().split(" - ")[0]);
            int doctorId = Integer.parseInt(doctorComboBox.getSelectedItem().toString().split(" - ")[0]);
            String date = dateField.getText();
            String time = timeField.getText();
            String reason = reasonField.getText();

            try (Connection conn = DBConnection.getConnection()) {
                String sql = "INSERT INTO appointment (patient_id, doctor_id, appointment_date, appointment_time, reason) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, patientId);
                stmt.setInt(2, doctorId);
                stmt.setDate(3, Date.valueOf(date));
                stmt.setTime(4, Time.valueOf(time));
                stmt.setString(5, reason);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Appointment booked!");
                loadAppointments();
                clearFields();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage());
        }
    }

    private void updateAppointment() {
        int selectedRow = appointmentTable.getSelectedRow();
        if (selectedRow == -1) return;

        int id = (int) model.getValueAt(selectedRow, 0);
        try {
            int patientId = Integer.parseInt(patientComboBox.getSelectedItem().toString().split(" - ")[0]);
            int doctorId = Integer.parseInt(doctorComboBox.getSelectedItem().toString().split(" - ")[0]);
            String date = dateField.getText();
            String time = timeField.getText();
            String reason = reasonField.getText();

            try (Connection conn = DBConnection.getConnection()) {
                String sql = "UPDATE appointment SET patient_id=?, doctor_id=?, appointment_date=?, appointment_time=?, reason=? WHERE id=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, patientId);
                stmt.setInt(2, doctorId);
                stmt.setDate(3, Date.valueOf(date));
                stmt.setTime(4, Time.valueOf(time));
                stmt.setString(5, reason);
                stmt.setInt(6, id);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Appointment updated.");
                loadAppointments();
                clearFields();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage());
        }
    }

    private void deleteAppointment() {
        int selectedRow = appointmentTable.getSelectedRow();
        if (selectedRow == -1) return;

        int id = (int) model.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this appointment?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM appointment WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Appointment deleted.");
            loadAppointments();
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void clearFields() {
        patientComboBox.setSelectedIndex(0);
        doctorComboBox.setSelectedIndex(0);
        dateField.setText("");
        timeField.setText("");
        reasonField.setText("");
        appointmentTable.clearSelection();
    }

    private void populateFieldsFromTable() {
        int selectedRow = appointmentTable.getSelectedRow();
        if (selectedRow == -1) return;

        String patient = model.getValueAt(selectedRow, 1).toString();
        String doctor = model.getValueAt(selectedRow, 2).toString();
        String date = model.getValueAt(selectedRow, 3).toString();
        String time = model.getValueAt(selectedRow, 4).toString();
        String reason = model.getValueAt(selectedRow, 5).toString();

        for (int i = 0; i < patientComboBox.getItemCount(); i++) {
            if (patientComboBox.getItemAt(i).contains(patient)) {
                patientComboBox.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < doctorComboBox.getItemCount(); i++) {
            if (doctorComboBox.getItemAt(i).contains(doctor)) {
                doctorComboBox.setSelectedIndex(i);
                break;
            }
        }

        dateField.setText(date);
        timeField.setText(time);
        reasonField.setText(reason);
    }
}
