package com.swe.recify.reponse;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

public class MusicReponse  {
	
	int duration;
	Resource file;
	
	
	public MusicReponse(Resource file) {
		super();
		this.file = file;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Resource getFile() {
		return file;
	}
	public void setFile(Resource file) {
		this.file = file;
	}
	
}
