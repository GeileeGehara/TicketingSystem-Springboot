package com.example.ticketingsystem.models;

import java.math.BigDecimal;

public class Vendor implements Runnable {
    private int totalTickets;
    private int ticketReleaseRate;
    private Configuration ticketPool;

    public Vendor(int totalTickets, int ticketReleaseRate, Configuration ticketPool) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int i = 1; i <= totalTickets; i++) {

            Ticket ticket = new Ticket(i, "Simple Event", new BigDecimal("100.00"));
            ticketPool.addTicket(ticket);
            System.out.println(Thread.currentThread().getName() + " added ticket: " + ticket);

            // Simulate ticket release rate
            try {
                Thread.sleep(ticketReleaseRate); // Delay between releasing tickets
            } catch (InterruptedException e) {
                System.err.println(Thread.currentThread().getName() + " was interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(Thread.currentThread().getName() + " finished releasing tickets.");
    }
}
