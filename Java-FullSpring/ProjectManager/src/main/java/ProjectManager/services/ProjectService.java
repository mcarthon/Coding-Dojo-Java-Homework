package ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ProjectManager.models.Project;
import ProjectManager.repositories.ProjectRepository;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	
	public ProjectService ( ProjectRepository projectRepository ) {
		
		this.projectRepository = projectRepository;
		
	}
	
	public Project addProject ( Project project ) {
		
		return this.projectRepository.save ( project );
		
	}
	
	public List<Project> findAllProjects () {
		
		return this.projectRepository.findAll ();
		
	}
	
	public Project findProjectById ( Long id ) {
		
		Optional<Project> optionalProject = this.projectRepository.findById ( id );
		
		if ( optionalProject.isPresent () ) {
			
			return optionalProject.get ();
			
		}
		
		return null;
		
	}
	
	public Project updateProject ( Project project ) {
		
		return this.projectRepository.save ( project );
		
	}
	
	public void deleteProject ( Long id ) {
		
		this.projectRepository.deleteById ( id );
		
	}
	
}















































