package com.swe.recify.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "view_manager")
public class ViewManager {
	@EmbeddedId
	ViewManagerKey id = new ViewManagerKey();
	
	@ManyToOne
	@MapsId( "musicId")
	@JoinColumn(name = "music_id")
	Music music;
	
	@ManyToOne
	@MapsId( "userId")
	@Cascade({CascadeType.ALL})
	@JoinColumn(name = "user_id")
	User user;
	
	
	@Column(name = "view_count")
	@Cascade({CascadeType.ALL})
	int viewCount;

	public ViewManagerKey getId() {
		return id;
	}

	public void setId(ViewManagerKey id) {
		this.id = id;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	

	public ViewManager() {
		super();
	}

	public ViewManager(Music music, User user,int viewCount) {
		super();
		this.music = music;
		this.user = user;
		this.viewCount = viewCount;
	}
	
	
	
}
