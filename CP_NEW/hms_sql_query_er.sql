CREATE DATABASE IF NOT EXISTS hospital_db;
USE hospital_db;

-- Admin table
CREATE TABLE IF NOT EXISTS admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Insert default admin
INSERT IGNORE INTO admin (username, password) VALUES ('admin', 'admin123');

-- Patient table
CREATE TABLE IF NOT EXISTS patient (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    contact VARCHAR(15),
    address TEXT
);

-- Doctor table
CREATE TABLE IF NOT EXISTS doctor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100),
    contact VARCHAR(15),
    available BOOLEAN DEFAULT TRUE
);

-- Appointment table
CREATE TABLE IF NOT EXISTS appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(255),
    FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES doctor(id) ON DELETE CASCADE
);

-- Insert sample doctors
INSERT INTO doctor (name, specialization, contact, available)
VALUES 
('Dr. Aisha Singh', 'Cardiology', '9999999999', TRUE),
('Dr. Ravi Verma', 'Neurology', '8888888888', TRUE);

-- ==============================
-- New Tables from Advanced Schema
-- ==============================

-- Medical History
CREATE TABLE IF NOT EXISTS medical_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    conditions VARCHAR(100) NOT NULL,
    surgeries VARCHAR(100) NOT NULL,
    medication VARCHAR(100) NOT NULL
);

-- Patient fills medical history
-- CREATE TABLE IF NOT EXISTS patients_fill_history (
--     patient_id INT NOT NULL,
--     history_id INT NOT NULL,
--     PRIMARY KEY (history_id),
--     FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE,
--     FOREIGN KEY (history_id) REFERENCES medical_history(id) ON DELETE CASCADE
-- );

-- Doctor views medical history
-- CREATE TABLE IF NOT EXISTS doctor_views_history (
--     doctor_id INT NOT NULL,
--     history_id INT NOT NULL,
--     PRIMARY KEY (doctor_id, history_id),
--     FOREIGN KEY (doctor_id) REFERENCES doctor(id) ON DELETE CASCADE,
--     FOREIGN KEY (history_id) REFERENCES medical_history(id) ON DELETE CASCADE
-- );

-- Patients attend appointments
-- CREATE TABLE IF NOT EXISTS patients_attend_appointments (
--     patient_id INT NOT NULL,
--     appointment_id INT NOT NULL,
--     concerns VARCHAR(100),
--     symptoms VARCHAR(100),
--     PRIMARY KEY (patient_id, appointment_id),
--     FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE,
--     FOREIGN KEY (appointment_id) REFERENCES appointment(id) ON DELETE CASCADE
-- );

-- Diagnosis by doctor
CREATE TABLE IF NOT EXISTS diagnose (
    appointment_id INT NOT NULL,
    doctor_id INT NOT NULL,
    diagnosis VARCHAR(100),
    prescription VARCHAR(100),
    PRIMARY KEY (appointment_id, doctor_id),
    FOREIGN KEY (appointment_id) REFERENCES appointment(id) ON DELETE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES doctor(id) ON DELETE CASCADE
);

-- Doctor schedule slots
-- CREATE TABLE IF NOT EXISTS schedule (
--     id INT AUTO_INCREMENT,
--     start_time TIME NOT NULL,
--     end_time TIME NOT NULL,
--     break_time TIME NOT NULL,
--     day VARCHAR(20) NOT NULL,
--     PRIMARY KEY (id)
-- );

-- Doctor has schedule
-- CREATE TABLE IF NOT EXISTS doctor_schedule (
--     doctor_id INT NOT NULL,
--     schedule_id INT NOT NULL,
--     PRIMARY KEY (doctor_id, schedule_id),
--     FOREIGN KEY (doctor_id) REFERENCES doctor(id) ON DELETE CASCADE,
--     FOREIGN KEY (schedule_id) REFERENCES schedule(id) ON DELETE CASCADE
-- );
