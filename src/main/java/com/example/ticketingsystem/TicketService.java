package com.example.ticketingsystem;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class TicketService {
    private int maximumTicketCapacity = 100;
    private Queue<Ticket> ticketQueue = new LinkedList<>();

    public synchronized void addTicket(Ticket ticket){
        if (ticketQueue.size() < maximumTicketCapacity){
            ticketQueue.add(ticket);
            System.out.println("Ticket added: " + ticket);
        }
    }

    public synchronized Ticket buyTicket() {
        if(ticketQueue.isEmpty()) {
            System.out.println("No tickets available.");
            return null;
        }
        return ticketQueue.poll();
    }
}
