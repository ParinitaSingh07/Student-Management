📘 README – Student Management System (OOP, Inheritance, Interfaces)
---
📌 Project Overview
--

The Student Management System is a Java console application designed to demonstrate key Object-Oriented Programming (OOP) concepts:

✔ Inheritance

Student extends an abstract class Person.

✔ Polymorphism

Method overriding (displayInfo())

Method overloading (addStudent(...))

✔ Interfaces

RecordActions interface defines CRUD methods:

addStudent()

updateStudent()

deleteStudent()

viewStudents()

✔ Abstract Class

Person contains:

Fields: name, email

Abstract method: displayInfo()

✔ Record Management

StudentManager class implements RecordActions

Uses an ArrayList to store student objects

Prevents duplicate roll numbers

🛠️ Features
✔ Add Student

Supports method overloading:

Add using complete details

Add using only rollNo and name

✔ Update Student Record

Update course, email, marks, etc.

✔ Delete Student

Removes record by roll number.

✔ View All Students

Displays formatted student records.

✔ Duplicate Prevention

Does not allow adding students with an already existing roll number.

🎓 Class Structure
1️⃣ Abstract Class: Person

Fields: name, email

Methods:

Constructor

Abstract method displayInfo()

2️⃣ Student Class (extends Person)

Extra fields: rollNo, course, marks, grade

Overrides:

displayInfo()

Contains:

calculateGrade() method

3️⃣ Interface: RecordActions

Defines CRUD operations:

addStudent()

updateStudent()

deleteStudent()

viewStudents()

4️⃣ StudentManager Class

Implements RecordActions

Stores student records in ArrayList

Prevents duplicate roll numbers

5️⃣ Main Class

Presents a menu for user operations.

▶️ How to Run
Step 1: Save all code in a single .java file
StudentManagementSystem.java

Step 2: Compile:
javac StudentManagementSystem.java

Step 3: Run:
java StudentManagementSystem# Student-Management

Author
---
Parinita singh 
KR mangalam university
