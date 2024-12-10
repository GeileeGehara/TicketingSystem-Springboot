package com.example.ticketingsystem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private int ticketId;
    private String eventName;
    private BigDecimal ticketPrice;

    public Ticket(){
    }

    public Ticket(String eventName, BigDecimal ticketPrice) {
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Ticket{" + " ticketId= " + ticketId + ", eventName='" + eventName + '\'' +
                ", ticketPrice = " + ticketPrice + '}';
    }
}

