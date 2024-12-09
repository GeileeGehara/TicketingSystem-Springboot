package com.example.ticketingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public String addTicket(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);
        return "Ticket added successfully!";
    }

    @GetMapping("/buy")
    public Ticket buyTicket() {
        return ticketService.buyTicket();
    }
}

