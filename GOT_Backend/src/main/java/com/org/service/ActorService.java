package com.org.service;

import com.org.entity.ActorEntity;
import com.org.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ActorEntity saveActor(ActorEntity actor) {
        return actorRepository.save(actor);
    }

    public List<ActorEntity> getAllActors() {
        return actorRepository.findAll();
    }

    public Optional<ActorEntity> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    public void deleteActorById(Long id) {
        actorRepository.deleteById(id);
    }

    public List<ActorEntity> getActorsBySeasonsActive(int seasons) {
        return actorRepository.findBySeasonsActive(seasons);
    }
}

