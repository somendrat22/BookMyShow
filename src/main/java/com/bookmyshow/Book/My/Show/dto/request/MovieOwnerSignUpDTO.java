package com.bookmyshow.Book.My.Show.dto.request;

import com.bookmyshow.Book.My.Show.enums.UserType;
import com.bookmyshow.Book.My.Show.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieOwnerSignUpDTO {
    String name;
    String email;
    long phoneNumber;
    String password;
    UserType type;
    int companyAge;
    List<Movie> movies;
}
