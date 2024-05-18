package com.swe.recify.service;

import com.swe.recify.model.Music;
import com.swe.recify.reponse.MusicReponse;
import com.swe.recify.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service("musicService")
@Transactional
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public Music findById(long id) {

        Optional<Music> resultList = musicRepository.findById(id);
        return resultList.orElse(null);
    }

    public long deleteById(long id) {
        return  musicRepository.deleteById(id);
    }

    public long deleteMusic(long musicID) {

        musicRepository.deleteById(musicID);
        return musicID;
    }
    public long uploadMusic(String  pathFile, String fileName,int duration,String category) {
            Music music = new Music(fileName, duration, pathFile, category);
            return musicRepository.save(music).getId();
    }
    public List<Music> getAllMusic(){
        return (List<Music>) musicRepository.findAll();
    }

//    public long uploadMusic(MultipartFile multipartFile, int duration, String category) {
//
//        String pathCategory = null;
//        switch (category) {
//            case "chill":
//                pathCategory = "chill-music/";
//                break;
//            case "study":
//                pathCategory = "study-music/";
//                break;
//            case "workout":
//                pathCategory = "workout-music/";
//                break;
//            default:
//                break;
//        }
//
//        String fileName = multipartFile.getOriginalFilename();
//        File currentDir = new File("MusicUpload/" + pathCategory + fileName);
//
//        String path = currentDir.getPath();
//
//        if (!currentDir.exists()) {
//            currentDir.mkdir();
//        }
//        try (InputStream inputStream = multipartFile.getInputStream()) {
//            String filePath = currentDir.getPath();
//            Files.copy(inputStream, currentDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException ioe) {
//            System.out.println("cant save file");
//        }
//        musicRepository.save(new Music(fileName, duration, currentDir.getPath(), category));
//
//        return multipartFile.getSize();
//    }



    public MusicReponse getMusicReponseByID(long id) throws IOException {
        Music music = this.findById(id);
        MusicReponse res = new MusicReponse(music);
        res.setDuration(music.getLengBySeconds());
        return res;
    }

}
