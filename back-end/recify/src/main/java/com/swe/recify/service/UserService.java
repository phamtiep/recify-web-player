package com.swe.recify.service;

import com.swe.recify.reponse.UserDTO;
import com.swe.recify.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("musicService")
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    User DTOtoUser(UserDTO userDTO){
        return new User(userDTO.getUsername(), userDTO.getPassword());
    }

    long login(UserDTO userDTO){
        userRepository.
    }

}
