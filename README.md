# Students-Grading-System
The Student Grade System is designed to assist teachers in managing student grades and subjects. 
It has two user roles: teachers and admins.

Features
Teachers:
Access and Update Grades: Teachers can view and update student grades.
Subject Management: Teachers can manage subjects they teach.
Grade Averages: Teachers can calculate and view students’ grade averages.
Restricted Access: Teachers can only access and update students in their assigned subjects.

Admins:
Teacher Management: Admins can add or delete teachers.
Subject Management: Admins can add or delete subjects.
View Teachers and Subjects: Admins can see the list of teachers and the subjects they teach.
Global Subject List: Admins can view all subjects available in the system.
Assign Subjects: Admins can add or remove subjects from teachers.

Setup Instructions
Clone this repository to your local machine.
Set up your MySQL database with the necessary tables for students, teachers, subjects, and grades.
Configure the database connection in the application, Edit databaseconnection.java file to connect to MySql database.
Build and run the application.
ERD diagram is provided whith all tables used, you should only create them with the constraints in MySql.

Usage
Log in as a teacher or admin.
Navigate to the relevant sections to manage grades, subjects, and users.
Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to create a pull request.
