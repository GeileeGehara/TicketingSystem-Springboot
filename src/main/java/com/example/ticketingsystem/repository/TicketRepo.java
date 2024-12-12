package com.example.ticketingsystem.repository;

import com.example.ticketingsystem.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
}