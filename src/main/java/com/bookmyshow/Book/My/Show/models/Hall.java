package com.bookmyshow.Book.My.Show.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    String address;
    @ManyToOne
    ApplicationUser owner;
    @OneToMany(mappedBy = "hall")
    List<Screen> screens;
    @OneToMany(mappedBy = "hall")
    List<Show> shows;
    @OneToMany(mappedBy = "hall")
    List<Ticket> tickets;
}
