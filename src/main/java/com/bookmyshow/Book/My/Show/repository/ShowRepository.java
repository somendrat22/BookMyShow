package com.bookmyshow.Book.My.Show.repository;

import com.bookmyshow.Book.My.Show.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ShowRepository extends JpaRepository<Show, UUID> {

    @Query(value = "select * from show where movie_id=:id", nativeQuery = true)
    public List<Show> getShowByMovieID(UUID id);
    @Query(value = "select * from show where hall_id=:id", nativeQuery = true)
    public List<Show> getShowByHallId(UUID id);

    @Query(value = "select * from show where hall_id=:hallId and movie_id=:movieId", nativeQuery = true)
    public List<Show> getShowByHallIDAndMovieId(UUID hallId, UUID movieId);
}
