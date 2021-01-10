package com.example.demo.repositories;

import com.example.demo.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    // this method retrieves all the books from the databasecopy
    List<Song> findAll();

    void deleteById(Long id);

    List<Song> findSongsByArtist(String name);
    List<Song> findTop10ByOrderByRatingDesc();


}