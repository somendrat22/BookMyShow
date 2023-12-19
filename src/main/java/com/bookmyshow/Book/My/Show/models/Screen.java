package com.bookmyshow.Book.My.Show.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String screenName;
    @ManyToOne
    Hall hall;
    int screenCapacity;
    boolean status;
    String type;
}
