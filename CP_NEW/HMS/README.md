# Hospital Management System using Java and MYSQL by Atharva Salitri

javac -cp "lib/mysql-connector-j-9.2.0.jar" -d bin src/db/DBConnection.java src/gui/*.java src/Main.java

java -cp "bin;lib/mysql-connector-j-9.2.0.jar" Main


## ✅ Project Summary
This project is a Hospital Management System built using Java Swing for GUI and MySQL for the database. It's designed to help manage doctors (patients and appointments modules coming soon). The system allows users to:
- Add, edit, delete doctor records.
- View all doctors in a table.
- Search doctors by specialization and availability.
- Display doctor availability status as "Yes" or "No".
- Navigate using a basic dashboard.
- Easily go back to the dashboard using the Back button (with `dispose()` functionality).
- reference: https://www.youtube.com/watch?v=Lij8svibdho

## ✅ File Descriptions
1. **Main.java**: The starting point of the project. It launches the dashboard window.
2. **db/DBConnection.java**: Handles connecting to the MySQL database using JDBC. You need to provide your database name, username, and password here.
3. **gui/Dashboard.java**: Displays the main dashboard with buttons to open different modules (currently opens DoctorPanel).
4. **gui/DoctorPanel.java**: The main doctor management panel. It lets you:
   - Add, update, delete doctors
   - View all doctors in a table
   - Search doctors by specialization and availability
   - Go back to the dashboard

## ✅ How to Run This Project on Any Laptop
## Step 1: Prerequisites
Make sure the user has the following installed:
- Java JDK (version 8 or above)
- MySQL Server
- An IDE like VS Code, IntelliJ, or Eclipse (optional but recommended)
- MySQL JDBC driver (usually `mysql-connector-j.jar`)

## Step 2: MySQL Database Setup
Open MySQL Workbench or command line and run these SQL commands:
```sql
CREATE DATABASE hospital_db;

USE hospital_db;

-- Admin table
CREATE TABLE admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Insert default admin
INSERT INTO admin (username, password) VALUES ('admin', 'admin123');

-- Patient table
CREATE TABLE patient (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    contact VARCHAR(15),
    address TEXT
);

-- Doctor table
CREATE TABLE doctor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100),
    contact VARCHAR(15),
    availability VARCHAR(50)
);

-- Appointment table
DROP TABLE IF EXISTS appointment;

CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(255),
    FOREIGN KEY (patient_id) REFERENCES patient(id),
    FOREIGN KEY (doctor_id) REFERENCES doctor(id)
);

DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS doctor;

CREATE TABLE doctor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100),
    contact VARCHAR(15),
    available BOOLEAN DEFAULT TRUE
);

CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(255),
    FOREIGN KEY (patient_id) REFERENCES patient(id),
    FOREIGN KEY (doctor_id) REFERENCES doctor(id)
);

INSERT INTO doctor (name, specialization, contact, available)
VALUES 
('Dr. Aisha Singh', 'Cardiology', '9999999999', TRUE),
('Dr. Ravi Verma', 'Neurology', '8888888888', TRUE);
```

## Step 3: Update DBConnection.java
Open the `db/DBConnection.java` file and set your database credentials:
```java
String url = "jdbc:mysql://localhost:3306/hospital_db";
String username = "your_mysql_username";
String password = "your_mysql_password";
```
Replace `"your_mysql_username"` and `"your_mysql_password"` with your actual MySQL login.

## Step 4: Compile and Run the Project
### Option 1 (using an IDE like VS Code or IntelliJ)
- Open the folder.
- Make sure your JDBC jar file is added to the classpath.
- Run `Main.java` or `Dashboard.java`.

### Option 2 (using terminal)
If you’re compiling manually from terminal:
```bash
javac -cp .;path-to/mysql-connector-j.jar db/*.java gui/*.java Main.java
java -cp .;path-to/mysql-connector-j.jar Main

PS E:\VIT PUNE '27\S.Y - DOME\OOP Main\CP_NEW\HMS\src> javac -cp ".;../lib/mysql-connector-j-9.2.0.jar" db/*.java gui/*.java Main.java
PS E:\VIT PUNE '27\S.Y - DOME\OOP Main\CP_NEW\HMS\src> java -cp ".;../lib/mysql-connector-j-9.2.0.jar" Main
```
Note: On macOS/Linux, replace `;` with `:` in the classpath.

## 🏁 Default Start Behavior
The project starts from `Main.java` → `Dashboard.java` → `DoctorPanel.java`. The doctor management screen is currently fully working. More modules like patient and appointment panels can be added from the dashboard.

---



## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
