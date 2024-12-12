package com.example.ticketingsystem.models;

import com.example.ticketingsystem.service.TicketPool;

import java.math.BigDecimal;

public class Vendor implements Runnable {
    private final int totalTickets;
    private final int ticketReleaseRate;
    private final TicketPool ticketPool;

    public Vendor(int totalTickets, int ticketReleaseRate, TicketPool ticketPool) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int i = 1; i <= totalTickets; i++) {

            Ticket ticket = new Ticket("Simple Event", new BigDecimal("100.00"));
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
