CREATE DATABASE leavemanagement;

USE leavemanagement;

CREATE TABLE employee(
    employee_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    leave_balance INT,
    total_leave_used INT DEFAULT 0
);

CREATE TABLE leave_requests(
    leave_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id VARCHAR(20),
    leave_type VARCHAR(20),
    number_of_days INT,
    reason VARCHAR(255),
    request_date DATE
);

INSERT INTO employee VALUES
('EMP101','Kavi',15,0),
('EMP102','Arun',12,0),
('EMP103','Priya',20,0);
