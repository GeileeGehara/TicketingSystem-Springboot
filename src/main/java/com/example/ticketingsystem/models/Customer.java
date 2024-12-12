package com.example.ticketingsystem.models;

import com.example.ticketingsystem.service.TicketPool;

import java.util.Random;

public class Customer implements Runnable{
    private final TicketPool ticketPool;
    private final int customerRetrievalRate;
    private final int quantity;

    public Customer(TicketPool ticketPool, int customerRetrievalRate, int quantity) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        Random random = new Random();
        int ticketsPurchased = 0;

        while (ticketsPurchased < quantity) {
            try {
                Ticket ticket = ticketPool.buyTicket();

                if (ticket != null) {
                    ticketsPurchased++;
                    System.out.println(Thread.currentThread().getName() + " purchased ticket: " + ticket);
                } else {
                    System.out.println(Thread.currentThread().getName() + " found no tickets available.");
                    break; // Exit loop if no tickets are left
                }

                // Simulate customer retrieval rate
                Thread.sleep(customerRetrievalRate + random.nextInt(100)); // Add randomness to simulate real behavior
            } catch (InterruptedException e) {
                System.err.println(Thread.currentThread().getName() + " was interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(Thread.currentThread().getName() + " finished purchasing " + ticketsPurchased + " tickets.");
    }
}
