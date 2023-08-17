package JoyBundler.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import JoyBundler.models.BabyNames;
import JoyBundler.models.User;
import JoyBundler.repositories.BabyNamesRepository;

@Service
public class BabyNamesService {

	private final BabyNamesRepository babynamesRepository;
	
	public BabyNamesService ( BabyNamesRepository babynamesRepository ) {
		
		this.babynamesRepository = babynamesRepository;
		
	}
	
	public BabyNames create ( BabyNames babyname, BindingResult bindingResult ) {
		
		List<BabyNames> names = this.babynamesRepository.findAll ();
		
		for ( BabyNames name: names ) {
			
			if ( babyname.getName ().equals ( name.getName () ) ) {
				
				bindingResult.rejectValue ( "name", "Not Unique", "This name has already been used. " );
				
				return null;
				
			}
			
		}
		
		return this.babynamesRepository.save ( babyname );
		
	}
	
	public List<BabyNames> findAllNames () {
		
		return this.babynamesRepository.findAll ();
		
	}
	
	public BabyNames findOneName ( Long id ) {
		
		Optional<BabyNames> optionalName = this.babynamesRepository.findById ( id );
		
		if ( optionalName.isPresent () ) {
			
			return optionalName.get ();
			
		}
		
		return null;
		
	}
	
	public BabyNames update ( BabyNames babyname ) {
		
		return this.babynamesRepository.save ( babyname );
		
	}
	
	public void delete ( Long id ) {
		
		this.babynamesRepository.deleteById ( id );
		
	}
	
}