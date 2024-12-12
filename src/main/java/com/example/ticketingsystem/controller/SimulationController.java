package com.example.ticketingsystem.controller;

import com.example.ticketingsystem.DTO.TicketDTO;
import com.example.ticketingsystem.models.Configuration;
import com.example.ticketingsystem.models.Ticket;
import com.example.ticketingsystem.service.TicketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/simulation")
public class SimulationController {
    private final TicketPool ticketPool;
    private final Configuration configuration;

    @Autowired
    public SimulationController(TicketPool ticketPool, Configuration configuration) {
        this.ticketPool = ticketPool;
        this.configuration = configuration;
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus(){
        return ResponseEntity.ok(Map.of("ticketsAdded", ticketPool.getTotalTicketsProduced(), "ticketsBuy", ticketPool.getTotalTicketsRemoved()));
    }

    @PostMapping("/start")
    public ResponseEntity<String> startSimulation(@RequestBody TicketDTO DTO) {
        configuration.setTotalTickets(DTO.getTotalTickets());
        configuration.setTicketReleaseRate(DTO.getTicketReleaseRate());
        configuration.setCustomerRetrievalRate(DTO.getCustomerRetrievalRate());
        configuration.setMaximumTicketCapacity(DTO.getMaximumTicketCapacity());

        if (configuration.getMaximumTicketCapacity() <= 0) {
            return ResponseEntity.badRequest().body("Max ticket capacity must be greater than 0");
        }

        return ResponseEntity.ok("Simulation started.");
    }

    @PostMapping("/stop")
    public String stopSimulation() {
        configuration.stopSimulation();
        System.out.println("Simulation stopped");
        return "Simulation stopped!";
    }
}
