package com.swe.recify.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlist")
@Getter
@Setter
public class Playlist implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty
    @Column(name = "playlist_name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    //
    @ManyToMany
    @Cascade({CascadeType.ALL})
    @JoinTable(name = "playlist_has_music",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "music_id")
    )
    private Set<Music> MusicList = new HashSet<Music>(0);




    public Playlist() {
        super();
    }

    public Playlist(User user, String name) {
        super();
        this.user = user;
        this.name = name;

    }


    public void addMusic(Music e) {
        MusicList.add(e);

    }

    public  void removeMusic(Music e) {
        MusicList.remove(e);
    }

}
