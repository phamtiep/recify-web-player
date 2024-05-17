package com.swe.recify.repository;

import com.swe.recify.model.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface MusicRepository extends CrudRepository<Music, Long> {
    public Music findOneById(long id);
    Long deleteById(long musicId);
}
