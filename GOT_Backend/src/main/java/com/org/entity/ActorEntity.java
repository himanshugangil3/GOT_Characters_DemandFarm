package com.org.entity;

import java.util.List;
import javax.persistence.*;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor_entity")

public class ActorEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String actorName;
	    private String actorLink;

	    @ElementCollection
	    @CollectionTable(name = "actor_seasons_active", joinColumns = @JoinColumn(name = "actor_id"))
	    private List<Integer> seasonsActive;

	    // Getters and setters
    public ActorEntity() {
    }

	public ActorEntity(String actorName, String actorLink, List<Integer> seasonsActive) {
		super();
		this.actorName = actorName;
		this.actorLink = actorLink;
		this.seasonsActive = seasonsActive;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorLink() {
		return actorLink;
	}

	public void setActorLink(String actorLink) {
		this.actorLink = actorLink;
	}

	public List<Integer> getSeasonsActive() {
		return seasonsActive;
	}

	public void setSeasonsActive(List<Integer> seasonsActive) {
		this.seasonsActive = seasonsActive;
	}
    
    
}