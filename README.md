# 📚 Library Management System (Desktop Application)

A fully functional Desktop GUI application built using **Java (Swing/AWT)** to automate library workflow operations. This project provides a graphical interface for librarians to manage books inventory, handle issuance, and process returns smoothly.

---

## 🎥 Project Demo
Check out the working preview of the application:
* 📁 **`LibraryManagementSystem(Demo).mp4`** (Available in the root directory of this repository)

---

## 🚀 Features & Core Modules

The application is structured around dedicated Java components for each operational task:

* **🔒 Secure Access (`LoginPage.java`):** Password-protected entry screen for authorized librarians/admins.
* **📊 Central Command (`Dashboard.java`):** The primary navigation hub to access all internal library panels.
* **➕ Inventory Management (`AddBook.java` & `DeleteBook.java`):** Allows quick insertion of new books into the catalog or removal of decommissioned copies.
* **🔍 Advanced Cataloguing (`SearchBook.java` & `ViewBooks.java`):** Live database search features to query specific books or display the entire book registry in a structured table.
* **🔄 Transaction Processing (`IssueBook.java` & `ReturnBook.java`):** Logs real-time book borrowing protocols, tracks due dates, and manages standard return entries.

---

## 🛠️ Tech Stack Used

* **Language:** Java (JDK 8 or higher)
* **GUI Framework:** Java Swing / AWT (Abstract Window Toolkit)
* **Database:** JDBC with MySQL / SQLite *(Update this line if you are using an internal file system or database)*

---

## 📂 File Architecture

```text
├── AddBook.java                  # UI & Logic to add new books
├── Dashboard.java                # Main navigation dashboard
├── DeleteBook.java               # UI to delete books from inventory
├── IssueBook.java                # Book issuance transaction handler
├── LoginPage.java                # Admin authentication panel
├── ReturnBook.java               # Book return processing panel
├── SearchBook.java               # Search functionality across the library
├── ViewBooks.java                # Displays all available books in a table matrix
├── LibraryManagementSystem(Demo).mp4  # Video walkthrough of the project
└── README.md                     # Documentation guide
