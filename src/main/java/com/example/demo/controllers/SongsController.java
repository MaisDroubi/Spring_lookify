package com.example.demo.controllers;

import com.example.demo.models.Song;
import com.example.demo.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;
@Controller
public class SongsController {
    private final SongService songService;

    public SongsController(SongService songService) {
        this.songService=songService;
    }

    @RequestMapping("/songs")
    public String index(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "index.jsp";
    }


    @RequestMapping(value="/songs/top10")
    public String top10(Model model) {
        // List <Song>songs = songService.findSongByArtist(artist);
        List <Song>songs = songService.findTop10ByOrderByRatingDesc();
        model.addAttribute("songs", songs);

        return "top.jsp";
    }

    @RequestMapping(value="/songs/search", method= RequestMethod.POST)
    public String search(@RequestParam(value="artist") String artist , Model model) {
        List<Song> songs = songService.findSongByArtist(artist);
        model.addAttribute("songs", songs);
        return "index.jsp";
    }

    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "new.jsp";
    }



    @RequestMapping(value="/songs", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/songs";
        }
    }

    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id,Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "show.jsp";
    }
    @RequestMapping("/songs/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "edit.jsp";
    }

    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            songService.updateSong(song.getId(),song.getTitle(),song.getArtist(),song.getRating());
            return "redirect:/songs";
        }
    }

    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/songs";
    }




}