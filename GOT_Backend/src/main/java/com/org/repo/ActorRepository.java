package com.org.repo;

import com.org.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
    List<ActorEntity> findBySeasonsActive(int seasons);
}

