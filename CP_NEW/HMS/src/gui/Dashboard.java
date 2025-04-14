// // package gui;

// // import javax.swing.*;
// // import java.awt.*;

// // public class Dashboard extends JFrame {
// //     public Dashboard() {
// //         setTitle("Hospital Dashboard");
// //         setSize(500, 500);
// //         setDefaultCloseOperation(EXIT_ON_CLOSE);
// //         setLocationRelativeTo(null);

// //         JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10)); // ✅ changed to 4 rows
// //         panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

// //         JButton patientBtn = new JButton("Manage Patients");
// //         JButton doctorBtn = new JButton("Manage Doctors");
// //         JButton appointmentBtn = new JButton("Manage Appointments");
// //         JButton historyBtn = new JButton("Medical History"); // ✅ new button

// //         patientBtn.addActionListener(e -> new PatientPanel().setVisible(true));
// //         doctorBtn.addActionListener(e -> new DoctorPanel().setVisible(true));
// //         appointmentBtn.addActionListener(e -> new AppointmentPanel().setVisible(true));
// //         historyBtn.addActionListener(e -> new MedicalHistoryPanel().setVisible(true)); // ✅ action listener

// //         panel.add(patientBtn);
// //         panel.add(doctorBtn);
// //         panel.add(appointmentBtn);
// //         panel.add(historyBtn); // ✅ add to panel

// //         add(panel);
// //         setVisible(true);
// //     }
// // }

// package gui;

// import javax.swing.*;
// import java.awt.*;

// public class Dashboard extends JFrame {
//     public Dashboard() {
//         setTitle("Hospital Dashboard");
//         setSize(500, 500);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
//         panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

//         JButton patientBtn = new JButton("Manage Patients");
//         JButton doctorBtn = new JButton("Manage Doctors");
//         JButton appointmentBtn = new JButton("Manage Appointments");
//         JButton medicalHistoryBtn = new JButton("Manage Medical History");
//         JButton diagnosisBtn = new JButton("Manage Diagnosis");

//         patientBtn.addActionListener(e -> new PatientPanel().setVisible(true));
//         doctorBtn.addActionListener(e -> new DoctorPanel().setVisible(true));
//         appointmentBtn.addActionListener(e -> new AppointmentPanel().setVisible(true));
//         medicalHistoryBtn.addActionListener(e -> new MedicalHistoryPanel().setVisible(true));
//         diagnosisBtn.addActionListener(e -> new DiagnosePanel().setVisible(true));

//         panel.add(patientBtn);
//         panel.add(doctorBtn);
//         panel.add(appointmentBtn);
//         panel.add(medicalHistoryBtn);
//         panel.add(diagnosisBtn);

//         add(panel);
//         setVisible(true);
//     }
// }

package gui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Hospital Dashboard");
        setSize(500, 550); // Increased size to fit header and footer
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Use BorderLayout for better organization
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Header panel with a title
        JLabel headerLabel = new JLabel("Hospital Management System", JLabel.CENTER);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Center panel with buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton patientBtn = new JButton("Manage Patients");
        patientBtn.setToolTipText("Click to manage patient records");

        JButton doctorBtn = new JButton("Manage Doctors");
        doctorBtn.setToolTipText("Click to manage doctor records");

        JButton appointmentBtn = new JButton("Manage Appointments");
        appointmentBtn.setToolTipText("Click to manage appointments");

        JButton medicalHistoryBtn = new JButton("Manage Medical History");
        medicalHistoryBtn.setToolTipText("Click to view and manage medical history");

        JButton diagnosisBtn = new JButton("Manage Diagnosis");
        diagnosisBtn.setToolTipText("Click to manage diagnosis details");

        patientBtn.addActionListener(e -> new PatientPanel().setVisible(true));
        doctorBtn.addActionListener(e -> new DoctorPanel().setVisible(true));
        appointmentBtn.addActionListener(e -> new AppointmentPanel().setVisible(true));
        medicalHistoryBtn.addActionListener(e -> new MedicalHistoryPanel().setVisible(true));
        diagnosisBtn.addActionListener(e -> new DiagnosePanel().setVisible(true));

        buttonPanel.add(patientBtn);
        buttonPanel.add(doctorBtn);
        buttonPanel.add(appointmentBtn);
        buttonPanel.add(medicalHistoryBtn);
        buttonPanel.add(diagnosisBtn);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Footer panel with a status label
        JLabel footerLabel = new JLabel("@Hospital Management System", JLabel.CENTER);
        mainPanel.add(footerLabel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}
