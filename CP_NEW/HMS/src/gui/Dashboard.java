package gui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Hospital Dashboard");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JButton patientBtn = new JButton("Manage Patients");
        JButton doctorBtn = new JButton("Manage Doctors");
        JButton appointmentBtn = new JButton("Manage Appointments"); // ✅ Removed (Coming Soon)

        patientBtn.addActionListener(e -> new PatientPanel().setVisible(true));
        doctorBtn.addActionListener(e -> new DoctorPanel().setVisible(true));
        appointmentBtn.addActionListener(e -> new AppointmentPanel().setVisible(true)); // ✅ Fully working

        panel.add(patientBtn);
        panel.add(doctorBtn);
        panel.add(appointmentBtn);

        add(panel);
        setVisible(true);
    }
}
