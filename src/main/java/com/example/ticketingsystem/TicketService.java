package com.example.ticketingsystem;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

import lombok.Getter;

import org.springframework.stereotype.Service;



@Service
public class TicketService {
    private int totalTicketsProduced = 0;
    private int totalTicketsRemoved = 0;
    private int maximumTicketCapacity = 100;
    private Queue<Ticket> ticketQueue = new LinkedList<>();
    private SimulationConfig simulationConfig;

    public void setSimulationConfig(SimulationConfig config) {
        this.simulationConfig = config;
        this.maximumTicketCapacity = config.getMaxTicketCapacity();
        this.totalTicketsProduced = config.getTotalTickets();
        System.out.println("Simulation config updated: " + config);
    }

    public void startSimulation() {
        if (simulationConfig == null) {
            System.out.println("Simulation is already running.");
            return;
        }
        System.out.println("Starting simulation...");

        for (int i = 0; i < simulationConfig.getTotalTickets(); i++) {
            Ticket ticket = new Ticket("Event #" + (totalTicketsProduced + 1), new BigDecimal(100));  // Example ticket creation
            addTicket(ticket);
        }
    }

    public void stopSimulation() {
        ticketQueue.clear();
        totalTicketsProduced = 0;
        totalTicketsRemoved = 0;
        System.out.println("Simulation stopped and cleared.");
    }


    public synchronized void addTicket(Ticket ticket){
        if (ticketQueue.size() < maximumTicketCapacity){
            ticketQueue.add(ticket);
            totalTicketsProduced++;
            System.out.println("Ticket added: " + totalTicketsProduced);
        }
    }

    public synchronized Ticket buyTicket() {
        if(ticketQueue.isEmpty()) {
            System.out.println("No tickets available.");
            return null;
        }
        totalTicketsRemoved++;
        System.out.println("Tickets removed: " + totalTicketsRemoved);
        return ticketQueue.poll();
    }

    public int getTotalTicketsProduced() {
        return totalTicketsProduced;
    }

    public int getTotalTicketsRemoved() {
        return totalTicketsRemoved;
    }

    public void startSimulation(int totalTicket, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {

    }
}
