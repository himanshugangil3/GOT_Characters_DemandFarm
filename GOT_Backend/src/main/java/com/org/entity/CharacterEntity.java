package com.org.entity;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "characters")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String characterName;
    private String houseName;
    private String characterImageThumb;
    private String characterImageFull;
    private String characterLink;
    private String actorName;
    private String actorLink;
    private String nickname;
    private Boolean royal;
    private Boolean kingsguard;
    private Boolean isFavourite;

    @ElementCollection
    private List<String> guardianOf;

    @ElementCollection
    private List<String> siblings;
    
    @ElementCollection
    private List<String> sibling;

    @ElementCollection
    private List<String> parents;

    @ElementCollection
    private List<String> killed;

    @ElementCollection
    private List<String> allies;

    @ElementCollection
    private List<String> guardedBy;

    @ElementCollection
    private List<String> killedBy;

    @ElementCollection
    private List<String> marriedEngaged;

    @ElementCollection
    private List<String> parentOf;
    
    @ElementCollection
    private List<String> servedBy;
    
    @ElementCollection
    private List<String> serves;
    
    @ElementCollection
    private List<String> abductedBy;
    
    @ElementCollection
    private List<String> abducted;
    

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "character_id")
    private List<ActorEntity> actors;

	   // Constructors, getters, setters

	
	public CharacterEntity(Long id, String characterName, String houseName, String characterImageThumb,
			String characterImageFull, String characterLink, String actorName, String actorLink, String nickname,
			Boolean royal, Boolean kingsguard, Boolean isFavourite, List<String> guardianOf, List<String> siblings,
			List<String> sibling, List<String> parents, List<String> killed, List<String> allies,
			List<String> guardedBy, List<String> killedBy, List<String> marriedEngaged, List<String> parentOf,
			List<String> servedBy, List<String> serves, List<String> abductedBy, List<String> abducted,
			List<ActorEntity> actors) {
		super();
		this.id = id;
		this.characterName = characterName;
		this.houseName = houseName;
		this.characterImageThumb = characterImageThumb;
		this.characterImageFull = characterImageFull;
		this.characterLink = characterLink;
		this.actorName = actorName;
		this.actorLink = actorLink;
		this.nickname = nickname;
		this.royal = royal;
		this.kingsguard = kingsguard;
		this.isFavourite = isFavourite;
		this.guardianOf = guardianOf;
		this.siblings = siblings;
		this.sibling = sibling;
		this.parents = parents;
		this.killed = killed;
		this.allies = allies;
		this.guardedBy = guardedBy;
		this.killedBy = killedBy;
		this.marriedEngaged = marriedEngaged;
		this.parentOf = parentOf;
		this.servedBy = servedBy;
		this.serves = serves;
		this.abductedBy = abductedBy;
		this.abducted = abducted;
		this.actors = actors;
	}

	public CharacterEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getCharacterImageThumb() {
		return characterImageThumb;
	}

	public void setCharacterImageThumb(String characterImageThumb) {
		this.characterImageThumb = characterImageThumb;
	}

	public String getCharacterImageFull() {
		return characterImageFull;
	}

	public void setCharacterImageFull(String characterImageFull) {
		this.characterImageFull = characterImageFull;
	}

	public String getCharacterLink() {
		return characterLink;
	}

	public void setCharacterLink(String characterLink) {
		this.characterLink = characterLink;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<String> getGuardianOf() {
		return guardianOf;
	}

	public void setGuardianOf(List<String> guardianOf) {
		this.guardianOf = guardianOf;
	}

	public List<String> getSiblings() {
		return siblings;
	}

	public void setSiblings(List<String> siblings) {
		this.siblings = siblings;
	}

	public List<String> getParents() {
		return parents;
	}

	public void setParents(List<String> parents) {
		this.parents = parents;
	}

	public List<String> getKilled() {
		return killed;
	}

	public void setKilled(List<String> killed) {
		this.killed = killed;
	}

	public List<String> getAllies() {
		return allies;
	}

	public void setAllies(List<String> allies) {
		this.allies = allies;
	}

	public List<String> getGuardedBy() {
		return guardedBy;
	}

	public void setGuardedBy(List<String> guardedBy) {
		this.guardedBy = guardedBy;
	}

	public List<String> getKilledBy() {
		return killedBy;
	}

	public void setKilledBy(List<String> killedBy) {
		this.killedBy = killedBy;
	}

	public List<String> getMarriedEngaged() {
		return marriedEngaged;
	}

	public void setMarriedEngaged(List<String> marriedEngaged) {
		this.marriedEngaged = marriedEngaged;
	}

	public List<String> getParentOf() {
		return parentOf;
	}

	public void setParentOf(List<String> parentOf) {
		this.parentOf = parentOf;
	}

	public Boolean getRoyal() {
		return royal;
	}

	public void setRoyal(Boolean royal) {
		this.royal = royal;
	}

	public List<String> getServedBy() {
		return servedBy;
	}

	public void setServedBy(List<String> servedBy) {
		this.servedBy = servedBy;
	}

	public List<String> getServes() {
		return serves;
	}

	public void setServes(List<String> serves) {
		this.serves = serves;
	}

	public Boolean getKingsguard() {
		return kingsguard;
	}

	public void setKingsguard(Boolean kingsguard) {
		this.kingsguard = kingsguard;
	}

	public List<ActorEntity> getActors() {
		return actors;
	}

	public void setActors(List<ActorEntity> actors) {
		this.actors = actors;
	}

	public List<String> getAbductedBy() {
		return abductedBy;
	}

	public void setAbductedBy(List<String> abductedBy) {
		this.abductedBy = abductedBy;
	}

	public List<String> getAbducted() {
		return abducted;
	}

	public void setAbducted(List<String> abducted) {
		this.abducted = abducted;
	}

	public List<String> getSibling() {
		return sibling;
	}

	public void setSibling(List<String> sibling) {
		this.sibling = sibling;
	}

	public Boolean getIsFavourite() {
		return isFavourite;
	}

	public void setIsFavourite(Boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	

    
 
}
