package com.org;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.controller.CharacterController;
import com.org.entity.CharacterEntity;
import com.org.service.CharacterService;


@SpringBootApplication

public class FmsSpringBootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsSpringBootBackendApplication.class, args);
	}
	
	   @Autowired
	    private CharacterService characterService;

	    @Autowired
	    private CharacterController characterController;

	    @PostConstruct
	    public void persistCharactersFromJson() {
	        try {
	            List<CharacterEntity> characters = characterService.readCharactersFromJson("D:\\ch.json");
	            characterController.persistCharacters(characters);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

