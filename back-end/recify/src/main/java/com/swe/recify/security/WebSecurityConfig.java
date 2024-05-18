package com.swe.recify.security;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig  {
    @Autowired
    private JwtAuthencationFilter jwtAuthencationFilter;
//


    @Bean

    SecurityFilterChain web(HttpSecurity http) throws Exception {
        String apiPrefix = "/api/user";

        http.csrf(csrf-> csrf.disable()).
                cors(cors -> cors.configurationSource(corsConfigurationSource())).
                addFilterBefore(jwtAuthencationFilter, UsernamePasswordAuthenticationFilter.class)

                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/user/login/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/user/register/**").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/music/getFile/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/user/getAllPlaylist/").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.POST, "/api/music/uploadFile/**").hasAnyRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/music/uploadFile/**").hasAnyRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/playlist/getAllMusicPlaylist/**")
                                        .hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.DELETE, "/api/music/deleteMusic/**").hasAnyRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/user/createNewPlaylist/**").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, "/api/playlist/addMusicToPlaylist/**").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.DELETE, "/api/playlist/removeMusicFromPlaylist/**").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.POST, "/api/updateView/increase/**").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/api/playlist/deletePlaylist/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/user/changeRole/**").hasAnyRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/music/getAllMusic/**").permitAll());

        // ...

        return http.build();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
