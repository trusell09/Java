package com.russell.loginreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.russell.loginreg.models.LoginUser;
import com.russell.loginreg.models.User;
import com.russell.loginreg.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	//public UserService(UserRepository userRepo){
	//	this.userRepo = userRepo
	//}          
	//@ AutoWired replaces the above code, nice short cut
	 
    	// TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	// TO-DO- Reject values or register if no errors:
    	
    Optional<User> potentialUser = this.userRepo.findByEmail(newUser.getEmail()); // check if the email of the object coming from the registration form matches any users email in the db. If the email matches, that means the email is taken!
    	if(potentialUser.isPresent()) {
    		// this means email is taken because it found a user that matched the email from registration form
    		result.rejectValue("email", "Email Already Exists", "Please Submit New Email");
    	}
    		//Reject if password doesn't match confirmation
    if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Invalid", "Passwords don't Match");
    }
    		// Return null if result has errors (if there are validation errors still)
    if(result.hasErrors()) {
    		return null;
    }else {//if no errors after checking all the validations, then we can create a user.
    			// to create a user, we must first secure their password using bcrypt then save them to the db.
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    			//set the user objects password to be the hashed password
    		newUser.setPassword(hashed);
    		return this.userRepo.save(newUser);
    }
	//Hash and set password, save user to database
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
 
        // Find user in the DB by email
    	   Optional<User> potentialUser = this.userRepo.findByEmail(newLoginObject.getEmail()); 
    		// Reject if NOT present
    	   // if the email was not found, create a custom validation error message
    	   if(!potentialUser.isPresent()) {
    		   result.rejectValue("email", "Not Found", "This email does not exist");
    	   }else {
    		   //else means user tried to login with an email that if found - which s good, but now check to make sure the password matches. Since bcrypt is used to store passwords, use bcrypt to check passwords.
    		   if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
    			 //Reject if BCrypt password match fails (create a new validation error)
    			   result.rejectValue("password", "No Matches", "Invalid Credentials");
    		   }
    	   }

    	 //Return null if result has errors
    	   if(result.hasErrors()) {
    		   return null;   
    	   }else {
      //Otherwise, return the user object
    		   return potentialUser.get();
    	   }
    		
    }
    
    //get one user by id
    public User findOneUser(Long id) {
    	
    		return this.userRepo.findById(id).orElse(null);
    }
	
}
