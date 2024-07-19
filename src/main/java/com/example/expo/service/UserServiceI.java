package com.example.expo.service;

import java.util.List;

import com.example.expo.model.Login;
import com.example.expo.model.User;

public interface UserServiceI {

	int userSave(User user);

	List<User> getAllUser();

	User getUserDataById(int id);

	int saveAllUsers(List<User> user);

	int deleteUser(int id);

	long countEntries();

	Login getLoginDetails(String uname);

	User getUserDataOnly(int id);
	
	User updateUser(int id, User user);
	
    List<User> findByName(String name);

}
