package com.example.demo.controllers;


import com.example.demo.models.Song;
import com.example.demo.services.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongsApi {
    private final SongService songService;
    public SongsApi(SongService songService){
        this.songService = songService;
    }
    @RequestMapping("/api/songs")
    public List<Song> index() {
        return songService.allSongs();

    }


    @RequestMapping(value="/api/songs/top10")
    public List <Song> top10() {
        // List <Song>songs = songService.findSongByArtist(artist);
        List <Song>songs = songService.findTop10ByOrderByRatingDesc();
        return songs;
    }
    @RequestMapping(value="/api/songs/search", method= RequestMethod.POST)
    public List <Song> search(@RequestParam(value="artist") String artist) {
         List <Song>songs = songService.findSongByArtist(artist);
      return songs;
      }
    @RequestMapping(value="/api/songs", method= RequestMethod.POST)
    public Song create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") Integer rating) {
        Song song = new Song(title, artist, rating);
        return songService.createSong(song);
    }

    @RequestMapping("/api/songs/{id}")
    public Song show(@PathVariable("id") Long id) {
        Song song = songService.findSong(id);
        return song;
    }

    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
    }



    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.PUT)
    public Song update(@PathVariable("id") Long id,@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") Integer rating) {
        Song song = songService.updateSong(id,title,artist,rating);
        return song;
    }

/*

    @RequestMapping(
            value="/api/books/{id}",
            method=RequestMethod.PUT,
            consumes = "application/json")
    public Book update(@RequestBody Map<String, Object> payload, @PathVariable("id") Long id) {

        String title = (String) payload.get("title");
        String desc = (String) payload.get("description");
        String lang = (String) payload.get("language");
        Integer pages = (Integer) payload.get("pages");
        Book book = bookService.updateBook(id, title, desc, lang, pages);

        return book;
    }*/
}
