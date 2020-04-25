package com.paulyoon.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paulyoon.lookify.models.Song;
import com.paulyoon.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	public List<Song> allSongs(){
		return songRepo.findAll();
	}
	public List<Song> topTenSongs(){
		return songRepo.findTop10ByOrderByRatingDesc();
	}
	public List<Song> songsByArtist(String artist){
		return songRepo.findByArtistContaining(artist);
	}
	public Song createSong(Song song) {
		return songRepo.save(song);
	}
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}
	}
	public Song updateSong(Long id, String title, String artist, Integer rating) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			Song mySong = optionalSong.get();
			mySong.setTitle(title);
			mySong.setArtist(artist);
			mySong.setRating(rating);
			return mySong;
		}else {
			return null;
		}
	}
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	public Song updateSongObj(Song song) {
		return songRepo.save(song);
	}
}
