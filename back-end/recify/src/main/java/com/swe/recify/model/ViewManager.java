package com.swe.recify.model;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@Table(name = "view_manager")
@Getter
@Setter

public class ViewManager {
    @EmbeddedId
    ViewManagerKey id = new ViewManagerKey();

    @ManyToOne
    @MapsId("musicId")
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "music_id")
    Music music;

    @ManyToOne
    @MapsId("userId")
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "user_id")
    User user;


    @Column(name = "view_count")
    @Cascade({CascadeType.ALL})
    int viewCount;




    public ViewManager() {
        super();
    }

    public ViewManager(Music music, User user, int viewCount) {
        super();
        this.music = music;
        this.user = user;
        this.viewCount = viewCount;
    }


    public int incrementViewCount() {
        this.setViewCount(this.getViewCount() + 1);

        return this.getViewCount();
    }

}
