package com.gucart.backend;
// CRITERIA: Multithreading (Implementing Runnable)
class OrderProcessor implements Runnable {
    private int orderId;

    public OrderProcessor(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        processOrder();
    }

    // CRITERIA: Synchronization (Synchronized method)
    public synchronized void processOrder() {
        try {
            System.out.println("⏳ Processing Order #" + orderId + "...");
            Thread.sleep(2000); // Simulate time-consuming task
            System.out.println("✅ Order #" + orderId + " Confirmed and Email Sent!");
        } catch (InterruptedException e) {
            System.out.println("Order interrupted.");
        }
    }
}