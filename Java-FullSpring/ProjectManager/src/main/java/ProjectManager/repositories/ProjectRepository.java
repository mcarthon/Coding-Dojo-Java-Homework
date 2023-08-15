package ProjectManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ProjectManager.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	List<Project> findAll ();

}
