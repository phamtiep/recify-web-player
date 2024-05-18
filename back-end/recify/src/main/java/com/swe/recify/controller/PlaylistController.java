package com.swe.recify.controller;

import com.swe.recify.model.Music;
import com.swe.recify.model.Playlist;
import com.swe.recify.reponse.JwtResponse;
import com.swe.recify.reponse.MusicDTO;
import com.swe.recify.reponse.UserDTO;
import com.swe.recify.security.JwtTokenProvider;
import com.swe.recify.service.MusicService;
import com.swe.recify.service.PlaylistService;
import com.swe.recify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {
    @Autowired
    PlaylistService playlistService;
    @Autowired
    private MusicService musicService;
    @Autowired
    private UserService userService;


    @GetMapping("/getAllMusicPlaylist/{idPlaylist}")
    public ResponseEntity<Set<MusicDTO>> getAllMusic(@PathVariable("idPlaylist") long id){

        Playlist playlist = playlistService.findById(id);
        Set<MusicDTO> res = playlist.getMusicList().stream().map(MusicDTO::new).collect(Collectors.toSet());
        return ResponseEntity.ok().body(res);
    }
    @PostMapping("/addMusicToPlaylist")
    public ResponseEntity<Long> addMusicToPlaylist(@RequestParam("musicID") long musicID,
                                                     @RequestParam("playlistID") long playlistID){
        playlistService.addMusicToPlaylist( playlistService.findById(playlistID), musicService.findById(musicID));
        System.out.println("da vao controller");

        return ResponseEntity.ok().body(playlistID);
    }

    @DeleteMapping("/removeMusicFromPlaylist")
    public ResponseEntity<Long> removeMusicFromPlaylist(@RequestParam("musicID") long musicID,
                                                   @RequestParam("playlistID") long playlistID){

        playlistService.removeMusicFromPlaylist(playlistService.findById(playlistID), musicService.findById(musicID));
        return ResponseEntity.ok().body(playlistID);
    }
    @DeleteMapping("/deletePlaylist")
    public ResponseEntity<String> deletePlaylist(@RequestHeader(name="Authorization")String token,
                                                        @RequestParam("playlistId")long playlistId) {

        userService.removePlaylist(token, playlistId);
        return  ResponseEntity.ok().body("xoa thanh cong");
    }

}
