package com.swe.recify.service;

import com.swe.recify.model.Playlist;
import com.swe.recify.model.User;
import com.swe.recify.reponse.UserDTO;
import com.swe.recify.repository.PlaylistRepository;
import com.swe.recify.repository.UserRepository;
import com.swe.recify.security.CustomUserDetail;
import com.swe.recify.security.JwtTokenProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("userService")
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PlaylistService playlistService;




    User DTOtoUser(UserDTO userDTO) {
        return new User(userDTO.getUsername(), userDTO.getPassword(), "USER");
    }

    User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public long login(UserDTO userDTO) {
        User user = userRepository.findUserByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
        if (user == null) return 0;

        return user.getId();
    }

    public String register(UserDTO userDTO) {

        if (userRepository.findUserByUsername(userDTO.getUsername()) == null) {
            userRepository.save(this.DTOtoUser(userDTO));
            return "Dang ky thanh cong";
        } else {
            return null;
        }
    }
    public Set<Playlist> getAllPlaylist(String bearerToken){
        return userRepository.findUserByUsername(jwtTokenProvider.getUsernameFromJWT(bearerToken.substring(7))).getAllPlaylist();

    }

    public String changeRole(long userId, String role) {
        User user = userRepository.findById(userId).orElse(null);
        assert user != null;
        user.setRole(role);
        userRepository.save(user);
        return role;
    }

    public String addPlaylist(String name, String bearerToken){
        User user = userRepository.findUserByUsername(jwtTokenProvider.getUsernameFromJWT(bearerToken.substring(7)));
        Playlist playlist = new Playlist(user, name);
        return playlistService.createPlaylist(playlist);
    }

    @Transactional
    public void removePlaylist(String bearerToken, long playlistId){
        User user = userRepository.findUserByUsername(jwtTokenProvider.getUsernameFromJWT(bearerToken.substring(7)));
        Playlist playlist = playlistService.findById(playlistId);
        user.removePlaylist(playlist);

    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        else {
            return new CustomUserDetail(user);
        }
    }
}
