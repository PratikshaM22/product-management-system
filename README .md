# Product Management System (Java Console App)

A console-based Product Management System built in **Java**, using **POJO** and **DAO** design patterns with **MySQL (JDBC)** for persistent data storage. Developed as a final training project.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)

## 📋 Features

- ➕ **Add Product** — insert a new product record into the database
- ❌ **Delete Product** — remove a product by ID
- 🔍 **Search by ID** — retrieve a single product's details
- 🔎 **Search by Category** — list all products under a given category
- 📃 **Display All Products** — view the full product list
- ✏️ **Update Product** — modify an existing product's details

## 🛠️ Tech Used

- **Java** — core application logic
- **JDBC** — connects the Java application to MySQL
- **MySQL** — relational database for persistent storage
- **Design Patterns:**
  - **POJO (Plain Old Java Object)** — `Product.java` representing a product record
  - **DAO (Data Access Object)** — `ProductDAO` (interface) and `ProductDAOImpl` (implementation) handling all database operations, keeping SQL logic separate from the console menu

## 📁 Project Structure

```
ProductManagementSystem/
├── src/
│   └── productDAO/
│       ├── Main.java              # entry point — console menu
│       ├── Product.java             # POJO — product fields (id, name, category, price, etc.)
│       ├── ProductDAO.java            # DAO interface — declares CRUD operations
│       ├── ProductDAOImpl.java          # DAO implementation — actual SQL/JDBC logic
│       └── ProductDBConnection.java       # handles MySQL database connection
├── .classpath
├── .project
├── .gitignore
└── README.md
```

## ⚙️ Setup Instructions

1. Install **MySQL** and create a database (e.g. `product_management_db`)
2. Create a `products` table with the required columns (id, name, category, price, etc.)
3. Update the database connection details (URL, username, password) in `ProductDBConnection.java`
4. Add the **MySQL JDBC connector JAR** to your project's build path
5. Run `Main.java` — the console menu will guide you through the available operations

## 🖥️ How to Use

Run the application and choose from the console menu:
```
1. Add Product
2. Delete Product
3. Search Product by ID
4. Search Products by Category
5. Display All Products
6. Update Product
7. Exit
```

## 🎓 About This Project

Built as a training/final project to practice:
- Object-Oriented Programming in Java
- POJO and DAO design pattern separation
- JDBC connectivity between Java and MySQL
- CRUD (Create, Read, Update, Delete) operations on a relational database

## 📜 License

This project is for educational purposes.
