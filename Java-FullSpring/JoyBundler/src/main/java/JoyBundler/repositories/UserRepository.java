package JoyBundler.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import JoyBundler.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByEmail ( String email );
	
	Optional<User> findById  ( Long id );
	
}