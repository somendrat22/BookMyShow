package com.bookmyshow.Book.My.Show.controller;

import com.bookmyshow.Book.My.Show.dto.request.RegularUserSignupDTO;
import com.bookmyshow.Book.My.Show.models.ApplicationUser;
import com.bookmyshow.Book.My.Show.service.RegularUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RegularUserController {

    @Autowired
    RegularUserService regularUserService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody  RegularUserSignupDTO regularUserSignupDTO){
        ApplicationUser user = regularUserService.signup(regularUserSignupDTO);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }


}
