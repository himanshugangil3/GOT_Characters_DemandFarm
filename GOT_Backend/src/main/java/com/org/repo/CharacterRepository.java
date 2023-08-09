package com.org.repo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.entity.CharacterEntity;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
   
	//  custom query methods 
	
	@Query("SELECT DISTINCT c.houseName FROM CharacterEntity c WHERE c.houseName IS NOT NULL")
    List<String> findAllUniqueHouseNames();

    List<CharacterEntity> findByHouseName(String houseName);
    
    List<CharacterEntity> findByCharacterName(String characterName);
	
	@Query("SELECT c FROM CharacterEntity c WHERE c.houseName = :houseName AND c.id IS NOT NULL")
    List<CharacterEntity> findByHouseNameAndIdIsNotNull(@Param("houseName") String houseName);

    default List<CharacterEntity> findByUniqueCharacterNames(String houseName) {
        List<CharacterEntity> characters = findByHouseNameAndIdIsNotNull(houseName);
        return characters.stream()
            .collect(Collectors.toMap(
                CharacterEntity::getCharacterName,
                character -> character,
                (existing, replacement) -> existing
            ))
            .values()
            .stream()
            .collect(Collectors.toList());
    }
}

