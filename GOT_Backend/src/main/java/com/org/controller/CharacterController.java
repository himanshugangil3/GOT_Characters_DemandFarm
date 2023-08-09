package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.entity.CharacterEntity;
import com.org.repo.CharacterRepository;
import com.org.service.CharacterService;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
	
	   public CharacterController(CharacterService characterService) {
	        this.characterService = characterService;
	    }

	
    @Autowired
    private CharacterRepository characterRepository;
    
    @Autowired
    private  CharacterService characterService;

    @CrossOrigin(origins = "*")
    @PostMapping("/persist-characters")
    public ResponseEntity<String> persistCharacters(@RequestBody List<com.org.entity.CharacterEntity> characters) {
        characterRepository.saveAll(characters);
        return ResponseEntity.ok("Characters persisted successfully!");
    }
    
    
 // Endpoint to get a list of all unique house names
    @CrossOrigin(origins = "*")
    @GetMapping("/houses")
    public ResponseEntity<List<String>> getAllUniqueHouseNames() {
        List<String> houseNames = characterService.getAllUniqueHouseNames();
        return ResponseEntity.ok(houseNames);
    }

    // Endpoint to get a list of all characters belonging to a given house
    @CrossOrigin(origins = "*")
    @GetMapping("/familytree/{houseName}")
    public ResponseEntity<List<CharacterEntity>> getCharactersByHouseName(@PathVariable String houseName) {
        List<CharacterEntity> characters = characterService.getCharactersByHouseName(houseName);
        return ResponseEntity.ok(characters);
    }

    // Endpoint to mark a character as favorite
    @CrossOrigin(origins = "*")
    @PutMapping("/{id}/favourite")
    public ResponseEntity<Void> markCharacterAsFavorite(@PathVariable Long id) throws Exception {
        characterService.markCharacterAsFavorite(id);
        return ResponseEntity.ok().build();
    }
    
    
}
