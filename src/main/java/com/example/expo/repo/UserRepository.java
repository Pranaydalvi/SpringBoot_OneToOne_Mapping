package com.example.expo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expo.model.User;
import com.example.expo.model.Login;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByLoginUname(String uname);

	List<User> findByName(String name);

}
