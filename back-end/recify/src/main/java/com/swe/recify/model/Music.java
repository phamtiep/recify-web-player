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
@Table(name = "music")
@Getter
@Setter
public class Music implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "music_name", nullable = false)
    private String musicName;

    @Column(name = "length_by_seconds", nullable = false)
    private int lengBySeconds;

    @NotEmpty
    @Column(name = "path_to_file", nullable = false)
    private String pathToFile;

    @Column(name = "category", nullable = false)
    private String category;

    @ManyToMany(mappedBy = "MusicList")
    @Cascade({CascadeType.ALL})
    private Set<Playlist> playlist = new HashSet<Playlist>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "music")
    @Cascade({CascadeType.ALL})
    private Set<ViewManager> ViewManager = new HashSet<ViewManager>(0);




    public void addPlaylist(Playlist e) {
        playlist.add(e);
    }

    public Music() {
        super();
    }

    public Music(@NotEmpty String musicName, int lengBySeconds, @NotEmpty String pathToFile, @NotEmpty String category
    ) {
        super();
        this.category = category;
        this.musicName = musicName;
        this.lengBySeconds = lengBySeconds;
        this.pathToFile = pathToFile;

    }
}
