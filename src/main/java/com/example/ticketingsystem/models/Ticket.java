package com.example.ticketingsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String eventName;
    private BigDecimal ticketPrice;

    public Ticket(String eventName, BigDecimal ticketPrice) {
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    public Ticket() {}

    public Long getTicketId() {
        return ticketId;
    }
    public String getEventName() {
        return eventName;
    }
    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }



    public void setEventName(String eventName) {
        this.eventName = eventName;
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
