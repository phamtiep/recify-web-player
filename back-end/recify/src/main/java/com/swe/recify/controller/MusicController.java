package com.swe.recify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.swe.recify.reponse.UpLoadReponse;
import com.swe.recify.service.MusicService;

@RestController
public class MusicController {
	 
	@Autowired
	MusicService userService;
	
	@PostMapping("/uploadFile")
	public ResponseEntity <UpLoadReponse> upLoadFile(@RequestParam("file") MultipartFile file, 
			 							@RequestParam("duration") int duration, @RequestParam("category") String category) {
		
		long sizeFile = userService.uploadMusic(file, duration,category);
		String fileName = file.getOriginalFilename();
		
		UpLoadReponse upLoadReponse = new UpLoadReponse();
		
		upLoadReponse.setNameFile(fileName);
		upLoadReponse.setSize(sizeFile);
		
		return  new ResponseEntity<>(upLoadReponse,HttpStatus.OK); 
	    
	    }
}

