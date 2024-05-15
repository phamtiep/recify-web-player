package com.swe.recify.repository;

import com.swe.recify.model.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

}
