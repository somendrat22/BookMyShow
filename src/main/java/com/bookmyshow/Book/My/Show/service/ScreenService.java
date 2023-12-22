package com.bookmyshow.Book.My.Show.service;

import com.bookmyshow.Book.My.Show.models.Screen;
import com.bookmyshow.Book.My.Show.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ScreenService {
    @Autowired
    ScreenRepository screenRepository;

    public void registerScreen(Screen screen){
        screenRepository.save(screen);
    }

    public void bookScreen(UUID id){
        screenRepository.bookScreen(id);
    }

}
