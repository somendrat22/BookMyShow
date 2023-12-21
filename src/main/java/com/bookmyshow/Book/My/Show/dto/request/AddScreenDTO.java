package com.bookmyshow.Book.My.Show.dto.request;

import com.bookmyshow.Book.My.Show.models.Screen;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddScreenDTO {
    List<Screen> screens;
    UUID hallId;
}
