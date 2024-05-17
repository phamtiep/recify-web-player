package com.swe.recify.service;

import com.swe.recify.model.Music;
import com.swe.recify.model.Playlist;
import com.swe.recify.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("playlistService")
@Transactional
public class PlaylistService {
    @Autowired
    PlaylistRepository playlistRepository;


    public Playlist findById(long id) {
        Optional<Playlist> resultList = playlistRepository.findById(id);
        return resultList.orElse(null);
    }

    public String createPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
        return playlist.getName();
    }

    @Transactional
    public void addMusicToPlaylist(Playlist playlist, Music music) {
        playlist.addMusic(music);
    }

    @Transactional
    public void removeMusicFromPlaylist(Playlist playlist, Music music) {
        playlist.removeMusic(music);
    }

    @Transactional
    public void deleteById(long playlistId){
        playlistRepository.deleteById(playlistId);
    }

}
