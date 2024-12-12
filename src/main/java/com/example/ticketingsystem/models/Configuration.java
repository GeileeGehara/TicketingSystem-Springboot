package com.example.ticketingsystem.models;

import org.springframework.stereotype.Component;

import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;

@Component
public class Configuration {
    private int totalTicket = 100;
    private int ticketReleaseRate = 2;
    private int customerRetrievalRate = 1;
    private int maximumTicketCapacity = 80;
    private boolean running = false;

    public Configuration() {}

    public Configuration(int totalTicket, int ticketReleaseRate, int customerRetrievalRate, int maximumTicketCapacity) {
        this.totalTicket = totalTicket;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maximumTicketCapacity = maximumTicketCapacity;

    System.out.println("Simulation config updated: " + DTO);
    }



    public int getTotalTicket() {
        return totalTicket;
    }
    public void setTotalTicket(int totalTicket) {
        this.totalTicket = totalTicket;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }
    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public void setMaximumTicketCapacity(int maximumTicketCapacity) {
        this.maximumTicketCapacity = maximumTicketCapacity;
    }


    public void stopSimulation() {
        running = false;
        // Signal simulation threads or processes to stop
    }

    public boolean isRunning() {
        return running;
    }


    @Override
    public String toString() {
        return "Configuration {" + "Total Tickets=" + totalTicket + ", Ticket Release Rate=" + ticketReleaseRate +
                "ms" + ", Customer Retrieval Rate=" + customerRetrievalRate +
                "ms" + ", Max Ticket Capacity=" + maximumTicketCapacity + '}';
    }


}
