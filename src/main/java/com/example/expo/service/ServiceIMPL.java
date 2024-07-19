package com.example.expo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expo.exception.UserNotFound;
import com.example.expo.model.Login;
import com.example.expo.model.User;
import com.example.expo.repo.UserRepository;

@Service
public class ServiceIMPL implements UserServiceI{

	
	@Autowired
	private UserRepository ur;
	
	
	@Override
	public int userSave(User user) {
		User user1= ur.save(user);
		return user1.getId();
	}


	@Override
	public List<User> getAllUser() {
		return ur.findAll();
	}


	@Override
	public User getUserDataById(int id) {
		Optional<User> optional = ur.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			 throw new UserNotFound("User Id Does Not exists.");
		}
}



    @Override
    public int saveAllUsers(List<User> users) {
        List<User> savedUsers = ur.saveAll(users);
        return savedUsers.size();
    }

    @Override
    public int deleteUser(int id) {
        ur.deleteById(id);
        return 1;
    }


    @Override
    public long countEntries() {
        return ur.count();
    }


	@Override
	public Login getLoginDetails(String uname) {
		Optional<User> optionalUser = ur.findByLoginUname(uname);
	    if (optionalUser.isPresent()) {
	        User user = optionalUser.get();
	        return user.getLogin();
	    } else {
	        throw new UserNotFound("Login details bind with "+uname+" user name not found");
	    }
	}


	@Override
	public User getUserDataOnly(int id) {
		return null;
		
	}
	@Override
    public User updateUser(int id, User user) {
        User existingUser = ur.findById(id).orElseThrow(() -> new UserNotFound("User Id Does Not exists."));
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setNumber(user.getNumber());
        existingUser.setLogin(user.getLogin());
        return ur.save(existingUser);
    }

    @Override
    public List<User> findByName(String name) {
        return ur.findByName(name);
    }
	}
