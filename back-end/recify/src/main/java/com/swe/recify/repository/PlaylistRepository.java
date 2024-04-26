package com.swe.recify.repository;

import org.springframework.data.repository.CrudRepository;

import com.swe.recify.model.Playlist;
import com.swe.recify.model.User;

public interface PlaylistRepository  extends CrudRepository<Playlist, Long>{

}
