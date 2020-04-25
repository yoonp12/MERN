package com.paulyoon.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paulyoon.lookify.models.Song;
import com.paulyoon.lookify.services.SongService;

@Controller
public class SongController {
	
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Song song) {
		return "/new.jsp";
	}
	
	@RequestMapping(value="/addSong", method=RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "/new.jsp";
		}else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song songInfo = songService.findSong(id);
		model.addAttribute("songs", songInfo);
		return "/show.jsp";
	}
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> topTen = songService.topTenSongs();
		model.addAttribute("songs", topTen);
		return "/topTen.jsp";
	}
	
	@RequestMapping(value="/search")
	public String search(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "/dashboard.jsp";
		}else {
			String artist = song.getArtist();
			return "redirect:/search/"+ artist;
		}
	}
	@RequestMapping(value="/search/{artist}")
	public String allSongsByArtist(@PathVariable("artist") String artist, Model model) {
		List<Song> byArtist = songService.songsByArtist(artist);
		model.addAttribute("songs", byArtist);
		System.out.println(byArtist);
		return "/byArtist.jsp";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
}


