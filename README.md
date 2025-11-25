# 🛒 GUcart - Java Spring Boot E-commerce Platform

GUcart is a full-stack e-commerce application built with **Java Spring Boot** for the backend and **HTML/Tailwind CSS** for the frontend. It demonstrates a complete shopping lifecycle including product management, shopping cart functionality, order processing, and role-based dashboards (Admin, Seller, Buyer).

This project was designed to showcase advanced Java concepts such as **Object-Oriented Programming (OOP)**, **Multithreading**, **Collections Framework**, and **JDBC**.

---

## 🚀 Features

### 👤 User Roles & Authentication
* **Buyer:** Browse products, add to cart, checkout, and view order history.
* **Seller:** Add new products, view sales performance graphs, and manage inventory.
* **Admin:** Monitor system activity, view all orders, and update order statuses (Shipped/Delivered).
* **Polymorphism:** The login system automatically detects the user role based on email patterns and directs them to the correct dashboard.

### 🛍️ Shopping Experience
* **Dynamic Product Grid:** Products are fetched from the database and rendered dynamically.
* **Shopping Cart:** Persistence using LocalStorage and Java Collections.
* **Checkout System:** Order placement processing handled via **Multithreading** to simulate background tasks.

### 📊 Dashboards
* **Admin Panel:** Live order table with status toggle buttons.
* **Seller Dashboard:** Real-time sales charts using Chart.js and backend aggregation logic.

---

## 🛠️ Tech Stack

### Backend (Core Java & Spring Boot)
* **Language:** Java 17+
* **Framework:** Spring Boot 3.4.0 (Web MVC)
* **Database Connectivity:** JDBC (Java Database Connectivity) via `java.sql`
* **Data Storage:** H2 In-Memory Database (Dev) / MySQL (Prod)
* **Core Concepts:**
    * **OOP:** Inheritance (`User` -> `Customer`/`Admin`) & Polymorphism.
    * **Multithreading:** `Runnable` interface used for processing orders asynchronously.
    * **Collections:** `ArrayList` and `HashMap` used for data manipulation.

### Frontend (UI/UX)
* **Structure:** HTML5
* **Styling:** Tailwind CSS (CDN)
* **Scripting:** Vanilla JavaScript (ES6+)
* **Icons:** Google Material Symbols

---

## 📂 Project Structure

```text
GUcart/
├── src/main/java/com/gucart/backend/
│   ├── ApiController.java       # REST API Endpoints (Web Layer)
│   ├── DatabaseConnection.java  # JDBC Connection Logic
│   ├── ProductDAO.java          # Data Access Object for Products
│   ├── OrderDAO.java            # Data Access Object for Orders
│   ├── OrderProcessor.java      # Multithreading Logic (Runnable)
│   ├── User.java                # OOP Parent Class
│   ├── DataSeeder.java          # Database Initializer
│   └── BackendApplication.java  # Main Entry Point
│
└── src/main/resources/static/   # Frontend Files
    ├── index.html               # Homepage
    ├── login.html               # Auth Page
    ├── cart.html                # Shopping Cart
    ├── checkout.html            # Order Placement
    ├── add-product.html         # Seller Form
    ├── AdminDashboard...html    # Admin Panel
    └── SellerDashboard...html   # Seller Panel
