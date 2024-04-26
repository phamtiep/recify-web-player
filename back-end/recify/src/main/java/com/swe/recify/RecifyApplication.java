package com.swe.recify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.swe.recify.model.Music;
import com.swe.recify.model.Playlist;
import com.swe.recify.model.User;
import com.swe.recify.model.ViewManager;
import com.swe.recify.repository.MusicRepository;
import com.swe.recify.repository.PlaylistRepository;
import com.swe.recify.repository.UserRepository;
import com.swe.recify.repository.ViewManagerRepository;

@SpringBootApplication
public class RecifyApplication {

  private static final Logger log = LoggerFactory.getLogger(RecifyApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(RecifyApplication.class);
  }

  @Bean
  public CommandLineRunner demo(ViewManagerRepository viewManagerRepository, UserRepository userRepository, MusicRepository musicRepository) {
    return (args) -> {
    	
    	User userTest = new User("tiepanh2", "tieptoan10", "admin");
    	
    	
    	Music musicTest = new Music("abc","def","ghi");
    	
    	userRepository.save(userTest);
    	musicRepository.save(musicTest);
    	
    	
    	ViewManager viewManagerTest = new ViewManager(musicTest, userTest, 8);
    	
    	viewManagerRepository.save(viewManagerTest);
    	
    	
    	
    };
  }
}