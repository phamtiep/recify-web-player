package com.swe.recify.reponse;

import com.swe.recify.model.Music;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;

@Getter
@Setter
public class MusicReponse {

    int duration;
    String pathFile;


    public MusicReponse(Music music) {
        super();
        this.duration = music.getLengBySeconds();
        this.pathFile = music.getPathToFile();
    }



}
