package com.swe.recify.reponse;

import com.swe.recify.model.Music;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MusicDTO implements Serializable {
    long id;
    String name;
    int duration;
    public MusicDTO(Music music){
        this.id = music.getId();
        this.name = music.getMusicName();
        this.duration = music.getLengBySeconds();
    }

}
