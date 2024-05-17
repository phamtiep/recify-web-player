package com.swe.recify.repository;

import com.swe.recify.model.User;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(@NotEmpty String userName);

    User findUserByUsernameAndPassword(@NotEmpty String userName, @NotEmpty String password);

}