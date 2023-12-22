package com.bookmyshow.Book.My.Show.service;

import com.bookmyshow.Book.My.Show.models.Show;
import com.bookmyshow.Book.My.Show.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    public void createShow(Show show){
        showRepository.save(show);
    }

    public List<Show> getShowsByMovieID(UUID movieId){
        return showRepository.getShowByMovieID(movieId);
    }

}
