
-- Insert data into Addresses table
INSERT INTO ads_system.address (street, City, zipCode)
VALUES
    ('123 Main St', 'Cityville',  '12345'),
    ('456 Elm St', 'Townsville',  '54321'),
    ('789 Oak St', 'Villageton',  '98765');

-- Insert data into Dentists table
INSERT INTO ads_system.Dentist (first_Name, last_Name, contact, email, specialization)
VALUES
    ('John', 'Doe', '555-123-4567', 'john.doe@example.com', 'General Dentistry'),
    ('Jane', 'Smith', '555-987-6543', 'jane.smith@example.com', 'Orthodontics'),
    ('David', 'Johnson', '555-789-0123', 'david.johnson@example.com', 'Endodontics');

-- Insert data into Patients table
INSERT INTO ads_system.Patient (First_Name, Last_Name, Contact, Email, dob, Address)
VALUES
    ('Alice', 'Brown', '555-111-2222', 'alice.brown@example.com', '1990-05-15', 2),
    ('Bob', 'Davis', '555-333-4444', 'bob.davis@example.com', '1985-08-20', 3),
    ('Carol', 'Evans', '555-555-6666', 'carol.evans@example.com', '2000-12-10', 1);

-- Insert data into Surgeries table
INSERT INTO ads_system.Surgery ( Address)
VALUES
    ( 1 ),
    ( 2 ),
    ( 3 );

-- Insert data into Appointments table
INSERT INTO ads_system.Appointments (Dentist_id, Patient_id, Date, Time, Surgery_id)
VALUES
    (1, 1, '2023-10-15', '09:00:00', 1),
    (2, 2, '2023-10-16', '14:30:00', 2),
    (3, 3, '2023-10-17', '10:15:00', 3);