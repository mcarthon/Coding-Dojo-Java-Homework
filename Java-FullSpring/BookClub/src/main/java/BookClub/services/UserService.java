package BookClub.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import BookClub.models.LoginUser;
import BookClub.models.User;
import BookClub.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService ( UserRepository userRepository ) {
		
		this.userRepository = userRepository;
		
	}
	
	public User register ( User newUser, BindingResult bindingResult ) {
		
		if ( this.userRepository.findByEmail( newUser.getEmail() ).isPresent() ) {
			
			bindingResult.rejectValue ( "email", "Already Registered", "This email has already been registered. " );
			
			return null;
			
		}
		
		if ( !newUser.getPassword().equals( newUser.getConfirm() ) ) {
			
			bindingResult.rejectValue ( "confirm", "Not Matching", "The passwords do not match. " );
			
			return null;
			
		}
		
		if ( bindingResult.hasErrors() ) {
			
			return null;
			
		}
		
		newUser.setPassword( BCrypt.hashpw ( newUser.getPassword(), BCrypt.gensalt() ) );
		
		return this.userRepository.save( newUser );
		
	}
	
	public User login ( LoginUser user, BindingResult bindingResult ) {
		
		if ( !this.userRepository.findByEmail ( user.getEmail() ).isPresent() ) {
			
			bindingResult.rejectValue ( "email", "Not Registered", "Invalid Credentials " );
			
		}
		
		if ( bindingResult.hasErrors() ) {
			
			return null;
			
		}
		
		User userWithThisEmail = this.userRepository.findByEmail ( user.getEmail() ).get();
		
		if ( !BCrypt.checkpw ( user.getPassword(), userWithThisEmail.getPassword() ) ) {
			
			bindingResult.rejectValue ( "password", "Not Matching", "Invalid Credentials" );
			
		}
		
		return userWithThisEmail;
		
	}
	
	public User getUserById ( Long id ) {
		
		return this.userRepository.findById ( id ).get ();
		
	}
	
}