package com.bookmyshow.Book.My.Show.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    String directorName;
    String actorName;
    String actressName;
    int imdbRating;
    double duration; //hours
    @OneToMany(mappedBy = "movie")
    List<Ticket> tickets;
    @ManyToOne
    ApplicationUser owner;
}
