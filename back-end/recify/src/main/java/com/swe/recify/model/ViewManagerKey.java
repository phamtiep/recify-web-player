package com.swe.recify.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class ViewManagerKey implements Serializable {
    @Column(name = "music_id", nullable = false)
    @NotEmpty
    Long musicId;

    @Column(name = "user_id", nullable = false)
    @NotEmpty
    Long userId;

   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((musicId == null) ? 0 : musicId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ViewManagerKey other = (ViewManagerKey) obj;
        if (musicId == null) {
            if (other.musicId != null)
                return false;
        } else if (!musicId.equals(other.musicId))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    public ViewManagerKey() {
        super();
    }


}
