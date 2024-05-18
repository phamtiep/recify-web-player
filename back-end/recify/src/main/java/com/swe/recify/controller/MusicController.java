package com.swe.recify.controller;

import com.swe.recify.reponse.MusicDTO;
import com.swe.recify.reponse.MusicReponse;
import com.swe.recify.reponse.UploadDTO;
import com.swe.recify.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    MusicService musicService;

    @PostMapping  (value = "/uploadFile")
    public ResponseEntity<Long> upLoadFile(@RequestParam("pathFile") String pathFile,@RequestParam("fileName") String fileName,
                                                @RequestParam("duration") int duration, @RequestParam("category") String category) {

        long musicId = musicService.uploadMusic(pathFile,fileName, duration, category);

        System.out.println("da vao controller");

        return new ResponseEntity<>(musicId, HttpStatus.OK);

    }



    @GetMapping("/getFile/{idFile}")
    public ResponseEntity<MusicReponse> getFile(@PathVariable("idFile") long idFile) throws IOException {


        MusicReponse musicReponse = musicService.getMusicReponseByID(idFile);

        return ResponseEntity.ok()
                .body(musicReponse);
    }

    @DeleteMapping("/deleteMusic/{idFile}")
    public ResponseEntity<String> deleteMusic(@PathVariable("idFile") long idFile) {
        musicService.deleteMusic(idFile);
        return new ResponseEntity<>("Deleted Success", HttpStatus.OK);
    }
    @GetMapping("/getAllMusic/")
    public ResponseEntity<List<MusicDTO>> getAllMusic(){
        List<MusicDTO>res = musicService.getAllMusic().stream().map(MusicDTO::new).toList();
        return ResponseEntity.ok().body(res);
    }


}

