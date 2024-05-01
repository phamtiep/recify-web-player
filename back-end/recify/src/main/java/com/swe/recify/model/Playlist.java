package com.swe.recify.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="playlist")
public class Playlist  {

	
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;


    @NotEmpty
    @Column(name="playlist_name", nullable=false)
    private String name;
 	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
 	
 
    
//    
    @ManyToMany
    @Cascade({ CascadeType.ALL})
    @JoinTable(name = "playlist_has_music",
    		joinColumns = @JoinColumn(name = "playlist_id"),
    		inverseJoinColumns = @JoinColumn(name = "music_id")
    )
    private Set<Music> MusicList = new HashSet<Music>(0);


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Playlist() {
		super();
	}

	public Playlist(User user, String name) {
		super();
		this.user = user;
		this.name = name;
		
	}

	public Set<Music> getMusicList() {
		return MusicList;
	}

	public void setMusicList(Set<Music> musicList) {
		MusicList = musicList;
	}
	
	public void addMusic(Music e){
		MusicList.add(e);
		
	}
 
}
