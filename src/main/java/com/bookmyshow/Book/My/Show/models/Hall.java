package com.bookmyshow.Book.My.Show.models;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "This represents hall model.")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, example = "21072a55-5394-43bb-8f1b-9a36cf396563")
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
