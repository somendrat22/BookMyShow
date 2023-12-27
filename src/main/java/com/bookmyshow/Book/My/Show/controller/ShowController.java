package com.bookmyshow.Book.My.Show.controller;

import com.bookmyshow.Book.My.Show.models.Show;
import com.bookmyshow.Book.My.Show.service.ShowService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @Parameters({
            @Parameter(name = "movieId", description = "It accepts only UUID", required = true),
            @Parameter(name = "hallId", description = "It accepts only UUID")
    })

    @GetMapping("/search")
    public ResponseEntity searchShowByMovieId(@RequestParam(required = false, defaultValue = "21072a55-5394-43bb-8f1b-9a36cf396563") UUID movieId,  @RequestParam(required = false, defaultValue = "21072a55-5394-43bb-8f1b-9a36cf396563") UUID hallId){

        if(movieId != null && hallId != null){
            // search for both movieId and hallId
            List<Show> shows = showService.getShowByHallIDAndMovieId(hallId, movieId);
            return new ResponseEntity(shows, HttpStatus.OK);
        }else if(movieId == null && hallId != null){
            List<Show> shows = showService.getShowByHallId(hallId);
            // search for only halls
            return new ResponseEntity(shows, HttpStatus.OK);
        }else if(movieId != null && hallId == null){
            List<Show> shows = showService.getShowsByMovieID(movieId);
            return new ResponseEntity(shows, HttpStatus.OK);
        }else{
            return new ResponseEntity("Please pass atleast one param", HttpStatus.OK);
        }
    }

}
