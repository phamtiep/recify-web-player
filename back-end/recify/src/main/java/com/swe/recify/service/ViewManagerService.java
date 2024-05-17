package com.swe.recify.service;

import com.swe.recify.model.Music;
import com.swe.recify.model.User;
import com.swe.recify.model.ViewManager;
import com.swe.recify.model.ViewManagerKey;
import com.swe.recify.repository.UserRepository;
import com.swe.recify.repository.ViewManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("viewManagerService")
public class ViewManagerService {
    @Autowired
    ViewManagerRepository viewManagerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MusicService musicService;

    @Transactional
    public int increaseView(long userID, long musicID) {
        ViewManager viewManager = viewManagerRepository.findViewManagerByUserIdAndMusicId(userID, musicID);
        User user = userService.findById(userID);
        Music music = musicService.findById(musicID);

        if (viewManager == null) {
            viewManager = new ViewManager(music, user, 1);
            viewManagerRepository.save(viewManager);
            return 1;
        } else {
            return viewManager.incrementViewCount();
        }
    }

}
