package JoyBundler.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import JoyBundler.models.BabyNames;
import JoyBundler.models.User;
import JoyBundler.repositories.BabyNamesRepository;
import JoyBundler.repositories.UserRepository;

@Service
public class JointService {
	
	private final UserRepository userRepository;
	
	private final BabyNamesRepository babynamesRepository;
	
	public JointService ( UserRepository userRepository, BabyNamesRepository babynamesRepository ) {
		
		this.userRepository = userRepository;
		
		this.babynamesRepository = babynamesRepository;
		
	}
	
	public User findUserById ( Long id ) {
		
		Optional<User> optionalUser = this.userRepository.findById ( id );
		
		if ( optionalUser.isPresent() ) {
			
			return optionalUser.get();
			
		}
		
		return null;
		
	}	
	
	public BabyNames findBabyNameById ( Long id ) {
		
		Optional<BabyNames> optionalName = this.babynamesRepository.findById ( id );
		
		if ( optionalName.isPresent () ) {
			
			return optionalName.get ();
			
		}
		
		return null;
		
	}
	
	
	public void upvote ( Long userId, Long babynamesId ) {
		
		User user = this.findUserById ( userId );
		
		BabyNames babyname = this.findBabyNameById ( babynamesId );
		
		if ( user.getBabynames () != null && !user.getBabynames ().contains ( babyname )  ) {
			
			user.getBabynames ().add ( babyname );
			
		}
		
		else if ( user.getBabynames () != null && user.getBabynames ().contains ( babyname ) ) {
			
			return;
			
		}
		
		else {
			
			List<BabyNames> babynames = new ArrayList<BabyNames> ();
			
			babynames.add ( babyname );
			
			user.setBabynames ( babynames );
			
		}
		
//		if ( babyname.getUsers () != null && !babyname.getUsers ().contains ( user ) ) {
//			
//			babyname.getUsers ().add ( user );						
//			
//		}
//		
//		else if ( babyname.getUsers () != null && babyname.getUsers ().contains ( user ) ) {
//			
//			return;
//			
//		}
//		
//		else {
//			
//			List<User> users = new ArrayList<User> ();
//			
//			users.add ( user );
//			
//			babyname.setUsers ( users );
//			
//		}
		
		this.userRepository.save ( user );
		
//		this.babynamesRepository.save ( babyname );
		
	}
	
	public void downvote ( Long userId, Long babynamesId ) {
		
		User user = this.findUserById ( userId );
		
		BabyNames babyname = this.findBabyNameById ( babynamesId );
		
		List<BabyNames> babynames = user.getBabynames ();
		
		babynames.remove ( babyname );
		
		user.setBabynames ( babynames );
		
		List<User> users = babyname.getUsers ();
		
		users.remove ( user );
		
		babyname.setUsers ( users );
		
		this.userRepository.save ( user );
		
		this.babynamesRepository.save ( babyname );
		
	}
	
	public boolean hasUpvoted ( Long userId, Long babynameId ) {
		
		User user = this.findUserById ( userId );
		
		BabyNames babyname = this.findBabyNameById ( babynameId );
		
		if ( babyname.getUsers ().contains ( user ) ) {
			
			return true;
			
		}
		
		return false;
		
	}

}































































