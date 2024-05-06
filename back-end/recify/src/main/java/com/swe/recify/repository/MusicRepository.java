package com.swe.recify.repository;

import org.springframework.data.repository.CrudRepository;

import com.swe.recify.model.Music;
import com.swe.recify.model.User;

public interface MusicRepository extends CrudRepository<Music, Long> {
	public Music findOneById(long id);
}
