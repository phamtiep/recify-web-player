package com.swe.recify.controller;

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

@RestController
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    MusicService musicService;

    @PostMapping  (value = "/uploadFile/")
    public ResponseEntity<UploadDTO> upLoadFile(@RequestParam("file") MultipartFile file,
                                                @RequestParam("duration") int duration, @RequestParam("category") String category) {

        long sizeFile = musicService.uploadMusic(file, duration, category);
        String fileName = file.getOriginalFilename();

        UploadDTO upLoadResponse = new UploadDTO();

        upLoadResponse.setNameFile(fileName);
        upLoadResponse.setSize(sizeFile);

        return new ResponseEntity<>(upLoadResponse, HttpStatus.OK);

    }

    @GetMapping("/getFile/{idFile}")
    public ResponseEntity<Resource> getFile(@PathVariable("idFile") long idFile) throws IOException {

        HttpHeaders headers = new HttpHeaders();


        MusicReponse musicReponse = musicService.getMusicReponseByID(idFile);
        String duration = String.valueOf(musicReponse.getDuration());
        headers.add("Content-Type", "application/octet-stream");
        headers.add("Duration", duration);
        return ResponseEntity.ok().headers(headers)
                .contentLength(musicReponse.getFile().contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + musicReponse.getFile().getFilename() + "\"")
                .body(musicReponse.getFile());
    }

    @DeleteMapping("/deleteMusic/{idFile}")
    public ResponseEntity<String> deleteMusic(@PathVariable("idFile") long idFile) {

        musicService.deleteMusic(idFile);
        return new ResponseEntity<>("Deleted Success", HttpStatus.OK);
    }

}

