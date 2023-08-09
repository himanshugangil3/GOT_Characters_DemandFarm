package com.org.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.entity.CharacterEntity;
import com.org.repo.CharacterRepository;

@Service
public class CharacterService {
    public List<CharacterEntity> readCharactersFromJson(String filePath) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, new TypeReference<List<CharacterEntity>>() {});
    }
    
    @Autowired
    private  CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<String> getAllUniqueHouseNames() {
        return characterRepository.findAllUniqueHouseNames();
    }

    public List<CharacterEntity> getCharactersByHouseName(String houseName) {
        return characterRepository.findByUniqueCharacterNames(houseName);
    }

//    public void markCharacterAsFavorite(Long id) throws Exception {
//        Optional<CharacterEntity> characterOptional = characterRepository.findById(id);
//        if (characterOptional.isPresent()) {
//            CharacterEntity character = characterOptional.get();
//            character.setIsFavourite(true);
//            characterRepository.save(character);
//        } else {
//           
//            throw new Exception("Character not found with ID: " + id);
//        }
//    }
    
    public void markCharacterAsFavorite(Long id) throws Exception {
        CharacterEntity character = characterRepository.findById(id)
                .orElseThrow(() -> new Exception("Character not found"));

        // Toggle the isFavourite flag
        Boolean isFavourite = character.getIsFavourite();
        if (isFavourite == null) {
            isFavourite = false; // Default to false if null
        }
        character.setIsFavourite(!isFavourite);

        
        List<CharacterEntity> charactersWithSameName = characterRepository.findByCharacterName(character.getCharacterName());
        for (CharacterEntity sameNameCharacter : charactersWithSameName) {
            sameNameCharacter.setIsFavourite(!isFavourite);
        }

        characterRepository.saveAll(charactersWithSameName);
    }


}

