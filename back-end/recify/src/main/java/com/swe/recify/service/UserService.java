package com.swe.recify.service;

import com.swe.recify.model.User;
import com.swe.recify.reponse.UserDTO;
import com.swe.recify.repository.UserRepository;
import com.swe.recify.security.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    User DTOtoUser(UserDTO userDTO) {
        return new User(userDTO.getUsername(), userDTO.getPassword(), "USER");
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
