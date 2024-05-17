package com.swe.recify.security;

import com.swe.recify.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Null;
import lombok.extern.slf4j.Slf4j;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
@Slf4j
public class JwtAuthencationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService UserService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {




        try {
            if(isByPassToken(request)){
                filterChain.doFilter(request, response);
                System.out.println("done");
                return;
            }
            String jwt = getJwtFromRequest(request);
            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                String username = tokenProvider.getUsernameFromJWT(jwt);

                UserDetails userDetails = UserService.loadUserByUsername(username);
                if(userDetails != null){
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        catch (Exception e) {
            log.error("fail on set user authencation", e);
        }
        filterChain.doFilter(request,response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    boolean isByPassToken(HttpServletRequest request){
        final List<Pair<String,String>> byPassTokens = Arrays.asList(
                Pair.of("/api/user/login/", "GET"),
                Pair.of("/api/user/register/", "POST"),
                Pair.of("/api/music/getFile/", "GET"),
                Pair.of("/api/updateView/increase/", "POST")
        );




        String requestPath = request.getServletPath();
        System.out.println(requestPath);
        String requestMethod = request.getMethod();



        return containsMatch(requestPath ,byPassTokens.stream().map(Pair::getFirst).toList());
    }
    public static boolean containsMatch(String string, List<String> regexList) {
        return regexList.stream()
                .map(Pattern::compile)
                .anyMatch(regex -> regex.matcher(string).find());
    }




}
