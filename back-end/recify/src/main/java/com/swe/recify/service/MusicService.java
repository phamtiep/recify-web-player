package com.swe.recify.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
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
		File currentDir = new File("MusicUpload/" + pathCategory +  fileName + ".mp3");
		
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
	
}
