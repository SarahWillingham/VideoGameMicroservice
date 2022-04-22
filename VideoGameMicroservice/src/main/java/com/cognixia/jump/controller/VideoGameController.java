package com.cognixia.jump.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.VideoGame;
import com.cognixia.jump.repository.VideoGameRepository;

@RequestMapping("/api")
@RestController
public class VideoGameController {

	@Autowired
	VideoGameRepository repo;
	
	@GetMapping("/videogames")
	public ResponseEntity<Object> getAllVideoGamess() {
		List<VideoGame> allVideoGames = repo.findAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(allVideoGames);
	}
	
	
	@PostMapping("/addvideogame")
	public ResponseEntity<Object> addVideoGame(@RequestBody VideoGame newVideoGame) {
		
		VideoGame addedVideoGame = repo.save(newVideoGame);	
		
		return ResponseEntity.status(HttpStatus.OK).body(addedVideoGame.toString() + " created");
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteVideoGameById(@PathVariable Long id){
		
		Optional<VideoGame> foundVideoGame = repo.findById(id);
		
		if(foundVideoGame.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("VideoGame: " + foundVideoGame.get().toString() + " deleted");
		}		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VideoGame not found for deletion");
	}
	
	
	@GetMapping("/videogame/{id}")
	public ResponseEntity<Object> getVideoGameById(@PathVariable Long id) {
		Optional<VideoGame> foundVideoGame = repo.findById(id);
		
		if(foundVideoGame.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(foundVideoGame.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VideoGame not found with id " + id);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateVideoGame(@RequestBody VideoGame updateGame){
		
		Optional<VideoGame> found = repo.findById(updateGame.getId());
		
		if(found.isPresent()) {
			repo.save(updateGame);
			return ResponseEntity.status(HttpStatus.OK).body("Saved: " + updateGame.toString());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VideoGame not found for update");

	}
	
}
