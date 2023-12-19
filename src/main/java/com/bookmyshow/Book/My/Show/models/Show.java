package com.bookmyshow.Book.My.Show.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    Hall hall;
    @ManyToOne
    Movie movie;
    @ManyToOne
    Screen screen;
    int availableTickets;
    Date startTime;
    Date endTime;
    int ticketPrice;
    @OneToMany(mappedBy = "show")
    List<Ticket> tickets;
}
