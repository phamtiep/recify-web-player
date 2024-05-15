package com.swe.recify.controller;

import com.swe.recify.reponse.JwtResponse;
import com.swe.recify.reponse.UserDTO;
import com.swe.recify.security.JwtTokenProvider;
import com.swe.recify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider tokenProvider;

    @RequestMapping("/login/")
    public ResponseEntity<JwtResponse> login(UserDTO userDTO) {
        long id = userService.login(userDTO);
        JwtResponse res = null;
        if (id == 0) return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        res = new JwtResponse(tokenProvider.generateToken(userDTO));
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/register/")
    public ResponseEntity<String> register(UserDTO userDTO) {
        String mess = userService.register(userDTO);
        if (mess == null)
            return new ResponseEntity<>("Username da ton tai", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(mess, HttpStatus.OK);
    }

}
