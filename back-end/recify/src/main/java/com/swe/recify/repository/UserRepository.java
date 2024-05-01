package com.swe.recify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.swe.recify.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

public interface UserRepository extends CrudRepository<User, Long> {
		

}