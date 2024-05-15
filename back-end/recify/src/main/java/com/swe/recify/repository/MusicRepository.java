package com.swe.recify.repository;

import com.swe.recify.model.Music;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Music, Long> {
    public Music findOneById(long id);
}
