package com.example.demo.services;
import com.example.demo.models.Song;
import com.example.demo.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    // creates a book
    public Song createSong(Song l) {
        return songRepository.save(l);
    }
    // retrieves a book
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }



    public List<Song> findSongByArtist(String artist) {
        return songRepository.findSongsByArtist(artist);
    }


    public List<Song> findTop10ByOrderByRatingDesc() {
        return songRepository.findTop10ByOrderByRatingDesc();
    }

    public Song updateSong(Long id, String title, String artist, int rating) {
        Optional <Song> update = songRepository.findById(id);
        if(update != null && update.isPresent()) {
            update.get().setTitle(title);
            update.get().setArtist(artist);
            update.get().setRating(rating);
            songRepository.save(update.get());
            return update.get();
        }
        return null;
    }

}