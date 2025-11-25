package com.gucart.backend;
// CRITERIA: OOP - Base Class (Inheritance)
abstract class User {
    protected String email;
    protected String password;
    protected String role;

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // CRITERIA: Polymorphism (Abstract method)
    public abstract void showDashboard();

    public String getEmail() { return email; }
}

// Subclass 1
class Customer extends User {
    public Customer(String email, String password) {
        super(email, password, "Buyer");
    }

    @Override
    public void showDashboard() {
        System.out.println("\n--- 🛒 WELCOME BUYER (" + this.email + ") ---");
        System.out.println("1. View Products");
        System.out.println("2. Add to Cart");
        System.out.println("3. Checkout");
    }
}

// Subclass 2
class Admin extends User {
    public Admin(String email, String password) {
        super(email, password, "Admin");
    }

    @Override
    public void showDashboard() {
        System.out.println("\n--- 🛡️ ADMIN PANEL ---");
        System.out.println("1. View All Users");
        System.out.println("2. View Orders");
    }
}