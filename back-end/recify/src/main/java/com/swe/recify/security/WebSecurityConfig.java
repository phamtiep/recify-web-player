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
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


import static org.springframework.security.config.Customizer.withDefaults;

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

        http.csrf(csrf -> csrf.disable()).
                addFilterBefore(jwtAuthencationFilter, UsernamePasswordAuthenticationFilter.class)

                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET, "/api/user/login/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/user/register/**").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/music/getFile/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/music/uploadFile").hasAnyRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/music/uploadFile").hasAnyRole("ADMIN"));





        // ...

        return http.build();
    }

}
