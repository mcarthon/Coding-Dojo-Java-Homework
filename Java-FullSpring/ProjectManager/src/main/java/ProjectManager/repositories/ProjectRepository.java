package ProjectManager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ProjectManager.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	List<Project> findAll ();
	
	Optional<Project> findById ( Long id );

}
