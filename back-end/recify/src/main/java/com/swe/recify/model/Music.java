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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name="music")
public class Music implements Serializable {
	 	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO )
	    private Long id;
	 
	    @NotEmpty
	    @Column(name="music_name", nullable=false)
	    private String musicName;
	 
	    @NotEmpty
	    @Column(name="length_by_seconds", nullable=false)
	    private String lengBySeconds;
	    
	    @NotEmpty
	    @Column(name="path_to_file", nullable=false)
	    private String pathToFile;
	    
	    @ManyToMany( mappedBy = "MusicList")
	    @Cascade({CascadeType.ALL})
	    private Set<Playlist> playlist = new HashSet<Playlist>(0);
	   
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "music")
	    @Cascade({CascadeType.ALL})
	    private Set<ViewManager> ViewManager = new HashSet<ViewManager>(0);
	

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMusicName() {
			return musicName;
		}

		public void setMusicName(String musicName) {
			this.musicName = musicName;
		}

		public String getLengBySeconds() {
			return lengBySeconds;
		}

		public void setLengBySeconds(String lengBySeconds) {
			this.lengBySeconds = lengBySeconds;
		}

		public String getPathToFile() {
			return pathToFile;
		}

		public void setPathToFile(String pathToFile) {
			this.pathToFile = pathToFile;
		}
		
		public void addPlaylist(Playlist e) {
			playlist.add(e);
		}
		
	    public Music() {
				super();
			}

		public Music(@NotEmpty String musicName, @NotEmpty String lengBySeconds, @NotEmpty String pathToFile
				) {
			super();
			
			this.musicName = musicName;
			this.lengBySeconds = lengBySeconds;
			this.pathToFile = pathToFile;
		
		}
}
