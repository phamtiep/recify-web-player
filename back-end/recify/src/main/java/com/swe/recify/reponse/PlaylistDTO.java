package com.swe.recify.reponse;

import com.swe.recify.model.Playlist;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PlaylistDTO implements Serializable {
    private long id;
    private String name;
    public PlaylistDTO(Playlist playlist){
        this.id = playlist.getId();
        this.name = playlist.getName();
    }


}
