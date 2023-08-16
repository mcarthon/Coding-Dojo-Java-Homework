package ProjectManager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ProjectManager.models.Project;
import ProjectManager.models.Task;
import ProjectManager.models.User;
import ProjectManager.repositories.ProjectRepository;
import ProjectManager.repositories.TaskRepository;
import ProjectManager.repositories.UserRepository;

@Service
public class JointService {
	
	private final UserRepository userRepository;
	
	private final ProjectRepository projectRepository;
	
	private final TaskRepository taskRepository;
	
	public JointService ( UserRepository userRepository, ProjectRepository projectRepository, TaskRepository taskRepository ) {
		
		this.userRepository = userRepository;
		
		this.projectRepository = projectRepository;
		
		this.taskRepository = taskRepository;
		
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
	
	public JointService leaveTeam ( Long userId, Long projectId ) {
		
		User user = this.findUserById ( userId );
		
		Project project = this.findProjectById ( projectId );
		
		List<Project> userProjects = user.getProjects ();
		
		userProjects.remove ( project );
		
		user.setProjects ( userProjects );
		
		this.userRepository.save ( user );
		
		List<User> projectUsers = project.getUsers ();
		
		projectUsers.remove ( user );
		
		project.setUsers ( projectUsers );
		
		this.projectRepository.save ( project );
		
		return this;
		
	}
	
	public JointService joinTeam ( Long userId, Long projectId ) {
		
		User user = this.findUserById ( userId );
		
		Project project = this.findProjectById ( projectId );
		
		if ( user.getProjects () != null ) {
			
			user.getProjects ().add ( project );
			
		}
		
		else {
			
			List<Project> userProjects = new ArrayList<Project> ();
			
			userProjects.add ( project );
			
			user.setProjects  ( userProjects );
			
		}
		
		if ( project.getUsers () != null ) {
			
			project.getUsers ().add ( user );
			
		}
		
		else {
			
			List<User> projectUsers = new ArrayList<User> ();
			
			projectUsers.add ( user );
			
			project.setUsers ( projectUsers );
			
		}
		
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
	
	public User addTeamLeadProject ( User user, Project project ) {
		
		if ( user.getTeamLeadProjects () != null ) {
			
			user.getTeamLeadProjects ().add ( project );
			
		}
		
		else {
			
			List<Project> teamLeadProjects = new ArrayList<Project> ();
			
			teamLeadProjects.add ( project );
		}		
		
		return this.userRepository.save ( user );
		
	}
	
	public Project addTask ( Task task, Project project, User user ) {
		
		task.setAuthor ( user );
		
		task.setProject ( project );
		
		task = this.taskRepository.save ( task );
		
		if ( project.getTasks () != null ) {
			
			project.getTasks ().add ( task );
			
		}
		
		else {
			
			List<Task> tasks = new ArrayList<Task> ();
			
			tasks.add ( task );
			
			project.setTasks ( tasks );
			
		}			
				
		return this.projectRepository.save ( project );
		
	}
	
}



















































