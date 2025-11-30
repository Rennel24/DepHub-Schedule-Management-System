📘 DepHub – Academic Schedule Management System

Keeping academic records organized, secure, and accessible is a major responsibility in any educational institution. Since student information is highly sensitive, improper handling may lead to data loss, errors, or unauthorized access.

To address these challenges, **DepHub** was developed as a **console-based Java application** that manages academic schedules within a university department.

DepHub streamlines tasks for **administrators, professors, and students** while showcasing Object-Oriented Programming (OOP) concepts such as **abstraction, inheritance, encapsulation, and polymorphism**.

---

## 📌 FEATURES OVERVIEW

### 👨‍🎓 Student Features
- Login authentication using SR-Code and password  
- View all available schedules (day, time, room, professor)  
- View enrolled schedules  
- Enroll in schedules with automatic conflict checking  
- Role description showing student permissions  

### 👨‍🏫 Professor Features
- Login authentication using ID and password  
- View assigned schedules  
- Role description outlining faculty responsibilities  

### 🛠️ Admin Features
- Login authentication (default credentials)  
- Add new schedule (program, day, time, room, professor)  
- View all schedules  
- Find schedule by ID  
- Assign professor and room  

---

## ⚙️ System Features

### 🔄 Exception Handling  
Handles incorrect inputs, missing data, and scheduling conflicts  
(including `ScheduleConflictException`).

### 🧠 OOP Implementation  
- **Abstraction:** Person, Admin  
- **Inheritance:** Professor, Student, CICSAdmin  
- **Polymorphism:** `roleDescription()` method overriding  
- **Encapsulation:** Getters, setters, and private attributes  





### 🧭 Menu-Based Navigation  
Clean console UI for each user role.

### 📚 Collections for Data Management  
Uses **ArrayList** to store schedules, professors, rooms, and enrollments.

### 🗂️ Package Organization  
Structured folders for clean, maintainable code.

---

## 🗂️ Project Structure

```text
SCHEDULE_MANAGEMENT/
│
├── abstractclasses/
│   ├── Person.java
│   └── Admin.java
│
├── polymorphicclasses/
│   ├── Student.java
│   └── Professor.java
│
├── model/
│   ├── Schedule.java
│   ├── Program.java
│   ├── Room.java
│   └── Time.java
│
├── exceptions/
│   └── ScheduleConflictException.java
│
├── ui/
│   └── MenuUI.java
│
└── main/
    ├── Runner.java
    └── Main.java
```

---

## 🧩 Class Descriptions

- **Main** – Entry point; launches Runner  
- **Runner** – Handles user interaction and menu navigation  
- **Person (abstract)** – Stores id, name, and `roleDescription()`  
- **Admin (abstract)** – Defines schedule management logic  
- **CICSAdmin** – Implements admin-specific functions  
- **Professor** – Holds professor data and assigned schedules  
- **Student** – Manages enrollment and schedule viewing  
- **Schedule / Program / Room / Time** – Core model entities  
- **ScheduleConflictException** – Detects overlapping schedules  
- **MenuUI** – Displays user interface menus  

---

## ▶️ How to Run

1. Open Terminal or CMD  
2. Navigate to project directory:  


cd SCHEDULE_MANAGEMENT/src

3. Compile:  


javac main/Main.java

4. Run:  


java main/Main

5. Use the menu to log in as Admin, Professor, or Student.

---

## 🖥️ Sample Output
========= STUDENT MENU =========

Show Role Description

View All Available Schedules

View Enrolled Schedules

Enroll in a Schedule

Logout
Enter your choice: 2

All Available Schedules:
Schedule ID: S104a
Program: Calculus-Based Physics (3 units)
Section: IT-2101
Professor: GOMEZ, RICARDO T.
Day: Monday
Time: 07:00 - 10:00
Room: 402 (Cap: 40)

✓ Successfully enrolled in schedule: S104a

⚠ Time conflict! You already have a class on Monday at 07:00 - 10:00


---

## 🙏 Acknowledgements
- Almighty God for guidance and strength  
- Mr. Jason Abratique for teaching and support  
- Our parents for continuous encouragement  

---

## 👥 Authors
<table>
  <tr>
    <th>Image</th>
    <th>Name</th>
    <th>Role</th>
  </tr>


  <tr>
    <td align="center">
      <img src="assets/rennel-pic.png" width="90" style="border-radius: 10px;" />
    </td>
    <td>
      <strong>Rennel T. Senyahan</strong><br/>
      <a href="https://github.com/Rennel24">GitHub</a>
    </td>
    <td>Lead Programmer</td>
  </tr>

  <tr>
    <td align="center">
      <img src="assets/mhar-pic.png" width="90" style="border-radius: 10px;" />
    </td>
    <td>
      <strong>Jhon Mhar R. Salapare</strong><br/>
      <a href="https://github.com/Mharmar">GitHub</a>
    </td>
    <td>Project Leader / System Architect</td>
  </tr>

 <tr>
    <td align="center">
      <img src="assets/rayver-pic.png" width="90" style="border-radius: 10px;" />
    </td>
    <td>
      <strong>Rayver Ian De Torres</strong><br/>
      <a href="https://github.com/USERNAME1">GitHub</a>
    </td>
    <td>Documentation & Presentation Specialist</td>
  </tr>

  <tr>
    <td align="center">
      <img src="assets/jessa-pic.png" width="90" style="border-radius: 10px;" />
    </td>
    <td>
      <strong>Jessa Soriano</strong><br/>
      <a href="https://github.com/USERNAME3">GitHub</a>
    </td>
    <td>Tester</td>
  </tr>

</table>


---

## 🚀 Future Enhancements
- Graphical User Interface (GUI)  
- Database Integration (MySQL / SQLite / PostgreSQL)  
- Multi-account system with secure login  
- Search and filtering features  

---

## 📚 References
- W3Schools – Java OOP Tutorial  
- Oracle Java Documentation  
- GeeksforGeeks – Java Programming  