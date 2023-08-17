package JoyBundler.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import JoyBundler.models.BabyNames;

public interface BabyNamesRepository extends CrudRepository<BabyNames, Long> {
	
	List<BabyNames> findAll ();
	
	Optional<BabyNames> findById ( Long id );

}