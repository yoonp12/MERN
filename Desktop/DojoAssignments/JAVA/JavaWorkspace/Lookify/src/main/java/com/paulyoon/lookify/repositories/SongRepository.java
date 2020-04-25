package com.paulyoon.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.paulyoon.lookify.models.*;

public interface SongRepository extends CrudRepository<Song, Long>{
	
	List<Song> findAll();
	
    List<Song> findByArtistContaining(String artist);
    
    List<Song> findTop10ByOrderByRatingDesc();
    
    Long deleteByTitleStartingWith(String search);
}
