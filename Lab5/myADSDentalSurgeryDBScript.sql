CREATE DATABASE IF NOT EXISTS ADS;

CREATE TABLE Addresses (
    AddressID INT PRIMARY KEY AUTO_INCREMENT,
    StreetAddress VARCHAR(255) NOT NULL,
    City VARCHAR(100) NOT NULL,
    State VARCHAR(50) NOT NULL,
    ZipCode VARCHAR(10) NOT NULL
);


CREATE TABLE Dentists (
    DentistID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    ContactPhone VARCHAR(15),
    Email VARCHAR(100) UNIQUE,
    Specialization VARCHAR(100),
    AddressID INT
);


CREATE TABLE Patients (
    PatientID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    ContactPhone VARCHAR(15),
    Email VARCHAR(100) UNIQUE,
    DateOfBirth DATE,
    AddressID INT,
    FOREIGN KEY (AddressID) REFERENCES Addresses(AddressID)
);


CREATE TABLE Surgeries (
    SurgeryID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    AddressID INT,
    TelephoneNumber VARCHAR(15),
    FOREIGN KEY (AddressID) REFERENCES Addresses(AddressID)
);

CREATE TABLE Appointments (
    AppointmentID INT PRIMARY KEY AUTO_INCREMENT,
    DentistID INT,
    PatientID INT,
    AppointmentDateTime DATETIME NOT NULL,
    SurgeryLocation INT,
    Status ENUM('Scheduled', 'Cancelled', 'Completed') DEFAULT 'Scheduled',
    FOREIGN KEY (DentistID) REFERENCES Dentists(DentistID),
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (SurgeryLocation) REFERENCES Surgeries(SurgeryID)
);


INSERT INTO Addresses (StreetAddress, City, State, ZipCode)
VALUES
    ('123 Main St', 'Cityville', 'CA', '12345'),
    ('456 Elm St', 'Townsville', 'NY', '54321'),
    ('789 Oak St', 'Villageton', 'TX', '98765');

-- Insert data into Dentists table
INSERT INTO Dentists (FirstName, LastName, ContactPhone, Email, Specialization, AddressID)
VALUES
    ('John', 'Doe', '555-123-4567', 'john.doe@example.com', 'General Dentistry', 1),
    ('Jane', 'Smith', '555-987-6543', 'jane.smith@example.com', 'Orthodontics', 2),
    ('David', 'Johnson', '555-789-0123', 'david.johnson@example.com', 'Endodontics', 3);

-- Insert data into Patients table
INSERT INTO Patients (FirstName, LastName, ContactPhone, Email, DateOfBirth, AddressID)
VALUES
    ('Alice', 'Brown', '555-111-2222', 'alice.brown@example.com', '1990-05-15', 2),
    ('Bob', 'Davis', '555-333-4444', 'bob.davis@example.com', '1985-08-20', 3),
    ('Carol', 'Evans', '555-555-6666', 'carol.evans@example.com', '2000-12-10', 1);

-- Insert data into Surgeries table
INSERT INTO Surgeries (Name, AddressID, TelephoneNumber)
VALUES
    ('City Dental Clinic', 1, '555-111-1111'),
    ('Town Family Dentistry', 2, '555-222-2222'),
    ('Village Dental Center', 3, '555-333-3333');

-- Insert data into Appointments table
INSERT INTO Appointments (DentistID, PatientID, AppointmentDateTime, SurgeryLocation, Status)
VALUES
    (1, 1, '2023-10-15 09:00:00', 1, 'Scheduled'),
    (2, 2, '2023-10-16 14:30:00', 2, 'Scheduled'),
    (3, 3, '2023-10-17 10:15:00', 3, 'Scheduled');
  

-- Display the list of ALL Dentists sorted by LastName:
SELECT * FROM Dentists
ORDER BY LastName ASC;

-- Display the list of ALL Appointments for a given Dentist (e.g., Dentist with DentistID = 1) with Patient information:
 
SELECT A.AppointmentID, A.AppointmentDateTime, A.Status, P.FirstName AS PatientFirstName, P.LastName AS PatientLastName
FROM Appointments A
INNER JOIN Patients P ON A.PatientID = P.PatientID
WHERE A.DentistID = 2;

-- Display the list of ALL Appointments at a given Surgery Location (e.g., Surgery with SurgeryID = 1):
 
SELECT A.AppointmentID, A.AppointmentDateTime, A.Status, D.FirstName AS DentistFirstName, D.LastName AS DentistLastName, P.FirstName AS PatientFirstName, P.LastName AS PatientLastName
FROM Appointments A
INNER JOIN Dentists D ON A.DentistID = D.DentistID
INNER JOIN Patients P ON A.PatientID = P.PatientID
WHERE A.SurgeryLocation = 3;

-- Display the list of Appointments booked for a given Patient (e.g., Patient with PatientID = 1) on a given Date (e.g., '2023-10-15'):
 
SELECT A.AppointmentID, A.AppointmentDateTime, A.Status, D.FirstName AS DentistFirstName, D.LastName AS DentistLastName
FROM Appointments A
INNER JOIN Dentists D ON A.DentistID = D.DentistID
WHERE A.PatientID = 1 AND DATE(A.AppointmentDateTime) = '2023-10-15';