package com.example.ticketingsystem.service;

import com.example.ticketingsystem.models.Configuration;
import com.example.ticketingsystem.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketPool {
    private final Configuration configuration;
    private final BlockingQueue<Ticket> ticketQueue;

    private int totalTicketsProduced = 0;
    private int totalTicketsRemoved = 0;

    @Autowired
    public TicketPool(Configuration configuration) {
        if (configuration.getMaximumTicketCapacity() <= 0) {
            throw new IllegalArgumentException("Maximum ticket capacity must be greater than 0");
        }
        this.configuration = configuration;
        this.ticketQueue = new LinkedBlockingQueue<>(configuration.getMaximumTicketCapacity());
    }

    public synchronized void addTicket(Ticket ticket){
        if (totalTicketsProduced >= configuration.getTotalTickets()) {
            throw new RuntimeException("All tickets have been added.");
        }
        try {
            ticketQueue.put(ticket);
            totalTicketsProduced++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized Ticket buyTicket() {
        try {
            Ticket ticket = ticketQueue.take();
            totalTicketsRemoved++;
            return ticket;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public int getTotalTicketsProduced() {
        return totalTicketsProduced();
    }

    private int totalTicketsProduced() {
        return totalTicketsProduced;
    }
    public int getTotalTicketsRemoved() {
        return totalTicketsRemoved;
    }


}
