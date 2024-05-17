package com.swe.recify.repository;

import com.swe.recify.model.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {


}
