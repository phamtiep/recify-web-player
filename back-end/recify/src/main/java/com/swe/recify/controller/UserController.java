package com.swe.recify.controller;

import com.swe.recify.model.Playlist;
import com.swe.recify.reponse.JwtResponse;
import com.swe.recify.reponse.PlaylistDTO;
import com.swe.recify.reponse.UserDTO;
import com.swe.recify.security.JwtTokenProvider;
import com.swe.recify.service.UserService;
import jakarta.websocket.server.PathParam;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<JwtResponse> login(@RequestBody UserDTO userDTO) {
        long id = userService.login(userDTO);
        JwtResponse res = null;
        if (id == 0) return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        res = new JwtResponse(tokenProvider.generateToken(userDTO));
        System.out.println("vao controller");
        return ResponseEntity.ok().body(res);
    }


    @GetMapping("/getAllPlaylist/")
    public ResponseEntity<Set<PlaylistDTO>> getAllPlaylist(@RequestHeader(name="Authorization") String token) {
    	 System.out.println("da vao controllercx");
        Set<PlaylistDTO> res = userService.getAllPlaylist(token).stream().map(PlaylistDTO::new).collect(Collectors.toSet());
       
       return  ResponseEntity.ok().body(res);
    }



    @PostMapping("/register/")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        String mess = userService.register(userDTO);
        if (mess == null)
            return new ResponseEntity<>("Username da ton tai", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(mess, HttpStatus.OK);
    }

    @PostMapping("/createNewPlaylist")
    public ResponseEntity<String> newPlaylist(@RequestHeader(name="Authorization")String token,
                                                                @RequestParam("name") String name) {
        System.out.println("da vao");
        return ResponseEntity.ok().body(userService.addPlaylist(name, token));
    }

    @PutMapping("/changeRole/")
    public ResponseEntity<String> changeRole(@RequestParam("userId") long userId
                            , @RequestParam("role") String role) {

        return ResponseEntity.ok().body(userService.changeRole(userId, role));
    }
}
