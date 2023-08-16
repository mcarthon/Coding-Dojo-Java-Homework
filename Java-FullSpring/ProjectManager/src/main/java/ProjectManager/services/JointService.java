package ProjectManager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ProjectManager.models.Project;
import ProjectManager.models.User;
import ProjectManager.repositories.ProjectRepository;
import ProjectManager.repositories.UserRepository;

@Service
public class JointService {
	
	private final UserRepository userRepository;
	
	private final ProjectRepository projectRepository;
	
	public JointService ( UserRepository userRepository, ProjectRepository projectRepository ) {
		
		this.userRepository = userRepository;
		
		this.projectRepository = projectRepository;
		
	}
	
	public User findUserById ( Long id ) {
		
		Optional<User> optionalUser = this.userRepository.findById ( id );
		
		if ( optionalUser.isPresent() ) {
			
			return optionalUser.get();
			
		}
		
		return null;
		
	}
	
	public Project findProjectById ( Long id ) {
		
		Optional<Project> optionalProject = this.projectRepository.findById ( id );
		
		if ( optionalProject.isPresent () ) {
			
			return optionalProject.get ();
			
		}
		
		return null;
		
	}
	
	public JointService joinTeam ( User user, Project project ) {
		
		user.getProjects ().add ( project );
		
		project.getUsers ().add ( user );
		
		this.userRepository.save ( user );
		
		this.projectRepository.save ( project );
		
		return this;
		
	}
	
	public List<Project> myProjects ( Long userId ) {
		
		List<Project> allProjects = this.projectRepository.findAll ();
		
		List<Project> myProjects = new ArrayList<Project>();
		
		boolean addToMyProjects = false;
		
		for ( Project project: allProjects ) {
			
			for ( User user: project.getUsers()  ) {
				
				if ( user.getId() == userId ) {
					
					addToMyProjects = true;
					
					break;
					
				}
				
			}
			
			if ( addToMyProjects ) {
				
				myProjects.add ( project );
				
				addToMyProjects = false;
				
			}
			
		}
		
		return myProjects;
		
	}
	
	public List<Project> notMyProjects ( Long userId ) {
		
		List<Project> allProjects = this.projectRepository.findAll ();
		
		List<Project> myProjects = this.myProjects ( userId );
		
		List<Project> notMyProjects = new ArrayList<Project>();
		
		for ( Project project: allProjects ) {
			
			if ( !myProjects.contains ( project ) ) {
				
				notMyProjects.add ( project );
				
			}
			
		}
		
		return notMyProjects;
		
	}
	
}



















































