package com.example.expo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.expo.exception.UserNotFound;
import com.example.expo.model.Login;
import com.example.expo.model.User;
import com.example.expo.service.UserServiceI;

@RestController
public class UserController {

	
	@Autowired
	private UserServiceI si;
	
	@PostMapping(value = "/saveUser")
	public ResponseEntity<String> saveUserData(@RequestBody User user){
		System.out.println("Check user Data  : " + user);
		int i = si.userSave(user); 
		if( i > 0 ) {
			return new ResponseEntity<String>("User SuccessFully Registerd.",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("User not SuccessFully Registerd.",HttpStatus.INTERNAL_SERVER_ERROR);
			//HttpStatus.BAD_REQUEST (400):
			//HttpStatus.INTERNAL_SERVER_ERROR (500):
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUser() {
		List<User>  ulist = si.getAllUser();
		return new ResponseEntity<List<User>>(ulist,HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<User> getUserDataById(@PathVariable int id){
		System.out.println("Fetching user data usibng id : " + id);
		User user = si.getUserDataById(id);
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> updateUserAndLoginData(@RequestBody  User user){
		System.out.println("Upadated User Data : " + user);
		int i = si.userSave(user);
		if( i > 0 ) {
			return new ResponseEntity<String>("User SuccessFully Updated.",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Somthing went wrong",HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/saveAllUsers")
    public ResponseEntity<String> saveAllUsersData(@RequestBody List<User> users) {
        int count = si.saveAllUsers(users);
        if (count > 0) {
            return new ResponseEntity<>("All Users Successfully Saved.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("No Users Saved.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        int result = si.deleteUser(id);
        if (result > 0) {
            return new ResponseEntity<>("User Successfully Deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found or deletion failed.", HttpStatus.NOT_FOUND);
        }
    }
	 @GetMapping(value = "/countEntry")
	    public ResponseEntity<Long> countEntry() {
	        long count = si.countEntries();
	        return new ResponseEntity<>(count, HttpStatus.OK);
	    }

	 @GetMapping(value = "/getLoginDetails/{uname}")
	 public ResponseEntity<?> getLoginDetails(@PathVariable String uname) {
		 Login loginDetails = si.getLoginDetails(uname);
		 if(loginDetails!=null) {
			 return new ResponseEntity<>(loginDetails, HttpStatus.FOUND);
		 }else {
			 return new ResponseEntity<>("Login details bind with "+uname+" user name not found ", HttpStatus.NOT_FOUND);
		 }
    }
	 @GetMapping(value = "/getUserDataOnly/{id}")
	 public ResponseEntity<?> getUserDataOnly(@PathVariable int id) {
		 User loginDetails = si.getUserDataOnly(id);
		 if(loginDetails!=null) {
			 return new ResponseEntity<>(loginDetails, HttpStatus.FOUND);
		 }else {
			 return new ResponseEntity<>("Login details bind with "+id+" id not found ", HttpStatus.NOT_FOUND);
		 }
    }
	
	 @GetMapping(value = "/getUserDataOnly/{id}")
	    public ResponseEntity<?> getUserData(@PathVariable int id) {
	        try {
	            User user = si.getUserDataOnly(id);
	            return new ResponseEntity<>(user, HttpStatus.OK);
	        } catch (UserNotFound e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping(value = "/searchByName/{name}")
	    public ResponseEntity<List<User>> searchByName(@PathVariable String name) {
	        List<User> users = si.findByName(name);
	        if (users.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

}