package com.bookmyshow.Book.My.Show.dto.request;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddShowDTO {
    int hour; // 13
    int minutes; // 00
    int ticketPrice;
    UUID movieId;
    UUID hallId;
}
