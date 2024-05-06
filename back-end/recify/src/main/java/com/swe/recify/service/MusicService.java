package com.swe.recify.service;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.swe.recify.model.Music;
import com.swe.recify.repository.MusicRepository;

@Service("musicService")
@Transactional
public class MusicService {
	@Autowired
	private MusicRepository musicRepository;
	
	public Music findById(long id) {
		
		Optional<Music> resultList = musicRepository.findById(id);
		
		return resultList.orElse(null);
		
	}
	
	public long uploadMusic(MultipartFile multipartFile, int duration, String category) {
		
		String pathCategory = null;
		switch (category) {
		case "chill":
			pathCategory = "chill-music/";
			break;
		case "study":
			pathCategory = "study-music/";
			break;
		case "workout":
			pathCategory = "workout-music/";
			break;
		default:
			break;
		}
		
		String fileName = multipartFile.getOriginalFilename();
		File currentDir = new File("MusicUpload/" + pathCategory +  fileName );
		
		String path = currentDir.getPath();
		
		if(!currentDir.exists()) {
			currentDir.mkdir();
		}
		try (InputStream inputStream = multipartFile.getInputStream()) {
            String filePath = currentDir.getPath();
            Files.copy(inputStream, currentDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            System.out.println("cant save file");
        }      
		
	
		musicRepository.save(new Music(fileName , duration, currentDir.getPath(), category));
		
		return  multipartFile.getSize();
	}
	
	public UrlResource getMusicbyID(long id) throws IOException {
		Music music = this.findById(id);
		
		File file = new File(music.getPathToFile());
	    
		UrlResource resource = new UrlResource(file.toURI());
	    
	    
		return resource;
		
		
	}
	
}
