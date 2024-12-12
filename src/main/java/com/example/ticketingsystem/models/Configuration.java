package com.example.ticketingsystem.models;

import org.springframework.stereotype.Component;

import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;

@Component
public class Configuration {
    private int totalTickets = 100;
    private int ticketReleaseRate = 2;
    private int customerRetrievalRate = 1;
    private int maximumTicketCapacity = 80;

    public Configuration() {}

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maximumTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maximumTicketCapacity = maximumTicketCapacity;

    System.out.println("Simulation config updated: " + DTO);
    }



    public int getTotalTickets() {
        return totalTickets;
    }
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
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



    @Override
    public String toString() {
        return "Configuration {" + "Total Tickets=" + totalTickets + ", Ticket Release Rate=" + ticketReleaseRate +
                "ms" + ", Customer Retrieval Rate=" + customerRetrievalRate +
                "ms" + ", Max Ticket Capacity=" + maximumTicketCapacity + '}';
    }


}
