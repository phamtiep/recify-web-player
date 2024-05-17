package com.swe.recify.reponse;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class JwtResponse implements Serializable {


    private final String message = "Đăng nhập thành công";


    private final String token;


    public JwtResponse(String token) {


        this.token = token;


    }



}
