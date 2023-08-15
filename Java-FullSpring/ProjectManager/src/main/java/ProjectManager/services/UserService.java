package ProjectManager.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import ProjectManager.models.LoginUser;
import ProjectManager.models.Project;
import ProjectManager.models.User;
import ProjectManager.repositories.UserRepository;


@Service
public class UserService {

	private final UserRepository userRepository;
	
	private final ProjectService projectService;
	
	public UserService ( UserRepository userRepository, ProjectService projectService ) {
		
		this.userRepository = userRepository;
		
		this.projectService = projectService;
		
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
	
	public User findUserById ( Long id ) {
		
		Optional<User> optionalUser = this.userRepository.findById ( id );
		
		if ( optionalUser.isPresent() ) {
			
			return optionalUser.get();
			
		}
		
		return null;
		
	}
	
	public User addProject ( Long userId, Long projectId ) {
		
		User user = this.findUserById ( userId );
		
		Project project = this.projectService.findProjectById ( projectId );
		
		user.getProjects ().add ( project );
		
		return this.userRepository.save ( user );
		
	}
	
}