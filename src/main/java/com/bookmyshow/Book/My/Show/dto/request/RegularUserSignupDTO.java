package com.bookmyshow.Book.My.Show.dto.request;

import com.bookmyshow.Book.My.Show.enums.UserType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegularUserSignupDTO {
    String name;
    String email;
    long phoneNumber;
    String password;
    UserType type; // movieOwners, HallOwners and RegularUserServce
    int age;
}
