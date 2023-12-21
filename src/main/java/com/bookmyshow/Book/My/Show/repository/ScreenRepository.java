package com.bookmyshow.Book.My.Show.repository;

import com.bookmyshow.Book.My.Show.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScreenRepository extends JpaRepository<Screen, UUID> {
}
