package com.russell.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.russell.bookclub.models.LoginUser;
import com.russell.bookclub.models.User;
import com.russell.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
    public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = this.userRepo.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Email Taken", "Email is taken!");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "No Match", "Password does not match!");
		}
		if(result.hasErrors()) {  
			return null;
		}
		else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return this.userRepo.save(newUser);
		}
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> potentialUser = this.userRepo.findByEmail(newLoginObject.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Not Found", "Invalid Credentials");
		}
		else {
			if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
			result.rejectValue("password", "No Match", "Invalid Credentials");
			}
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			return potentialUser.get();
		}
    }
		public User findOneUser(Long id) {
		return this.userRepo.findById(id).orElse(null);
    }
}
