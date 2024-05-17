package com.swe.recify.controller;

import com.swe.recify.model.Playlist;
import com.swe.recify.reponse.JwtResponse;
import com.swe.recify.reponse.PlaylistDTO;
import com.swe.recify.reponse.UserDTO;
import com.swe.recify.security.JwtTokenProvider;
import com.swe.recify.service.UserService;
import com.swe.recify.service.ViewManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/updateView")
public class ViewManagerController {
    @Autowired
    ViewManagerService viewManagerService;

    @PostMapping("/increase")
    ResponseEntity<Integer> increaseView(@RequestParam("userId")long userID, @RequestParam("musicId")long musicID){


        return  ResponseEntity.ok(viewManagerService.increaseView(userID, musicID));

    }

}
