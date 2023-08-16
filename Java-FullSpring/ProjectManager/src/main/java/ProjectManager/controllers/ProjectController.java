package ProjectManager.controllers;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ProjectManager.models.Project;
import ProjectManager.models.Task;
import ProjectManager.models.User;
import ProjectManager.services.JointService;
import ProjectManager.services.ProjectService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {

	private final ProjectService projectService;
	
	private final JointService jointService;
	
	public ProjectController ( ProjectService projectService, JointService jointService ) {
		
		this.projectService = projectService;
		
		this.jointService = jointService;
	}
	
	@GetMapping("/projects")
	public String allProjects ( Model model, HttpSession session ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			Long id = (Long) session.getAttribute ( "user_id" );
			
			model.addAttribute ( "myProjects", this.jointService.myProjects ( id ) );
			
			model.addAttribute ( "notMyProjects", this.jointService.notMyProjects ( id ) );
			
			return "dashboard.jsp";			
			
		}
		
		return "redirect:/";
		
	}
	
	@GetMapping("/projects/new")
	public String newProjectPage ( @ModelAttribute ( "newProject" ) Project newProject, HttpSession session ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			return "newProjectPage.jsp";
				
		}

		return "redirect:/";
		
	}
	
	@PostMapping("/projects") 
	public String addNewProject ( Project project, @Valid @ModelAttribute ( "newProject" ) Project newProject, BindingResult bindingResult, Model model, HttpSession session ) {
		
		if ( bindingResult.hasErrors () ) {
			
			return "newProjectPage.jsp";
			
		}
		
		Long userId = (Long) session.getAttribute ( "user_id" );
		
		User teamLead = this.jointService.findUserById ( userId );
		
		newProject.setTeamLead ( teamLead );
		
		this.jointService.addTeamLeadProject ( teamLead, newProject );
		
		Project savedProject = this.projectService.addProject ( newProject );
		
		this.jointService.joinTeam ( userId, savedProject.getId() );
		
		return "redirect:/projects";
		
	}
	
	@GetMapping("/projects/{id}")
 	public String showProject ( @PathVariable ( "id" ) Long id, Model model, HttpSession session ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			model.addAttribute ( "project", this.projectService.findProjectById ( id ) );
			
			return"showProject.jsp";			
			
		}
		
		return "redirect:/";		
	}
	
	@GetMapping("/projects/edit/{id}")
	public String showEditPage ( @PathVariable ( "id" ) Long id, Model model, HttpSession session, @ModelAttribute ( "project" ) Project project ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			
			Project projectNewDate = this.projectService.findProjectById ( id );
			
			String strDate = date.format(projectNewDate.getDueDate () );			
			
			model.addAttribute ( "project", projectNewDate );
			
			model.addAttribute ( "newDueDate", strDate );
			
			return "editPage.jsp";
						
		}
		
		return "redirect:/";
		
	}
	
	@PatchMapping("/projects/edit/{id}")
	public String editProject ( @PathVariable ( "id" ) Long id, @Valid @ModelAttribute ( "project" ) Project project, BindingResult bindingResult, Model model ) {
		
		if ( bindingResult.hasErrors () ) {
			
//			System.out.println ( bindingResult.getFieldErrors ().get (1).getDefaultMessage() );
//			
//			System.out.println ( bindingResult.getFieldErrors ( ).size () );
			
			String errors = "";
			
			for (  int i = 0; i < bindingResult.getFieldErrors ( ).size (); ++ i ) {
				
				errors += bindingResult.getFieldErrors ( ).get (i).getDefaultMessage () + "\n\n";
				
			}
			
			model.addAttribute ( "project", this.projectService.findProjectById ( id ) );
			
			model.addAttribute ( "errors", errors );
			
			return "editPage.jsp";
			
		}
		
		this.projectService.updateProject ( project );
		
		return "redirect:/projects/{id}";
		
	}
	
	@DeleteMapping("/projects/{id}")
	public String deleteProject ( @PathVariable ( "id" ) Long id ) {
		
		Project project = this.projectService.findProjectById ( id );
		
		project.setTeamLead ( null );
		
		project.setUsers ( null );
		
		project.setTasks ( null );
		
		this.projectService.deleteProject ( id );
		
		return "redirect:/projects";
		
	}
	
	@PostMapping("/projects/join/{user_id}/{project_id}")
	public String joinTeam ( @PathVariable ( "user_id" ) Long userId, @PathVariable ( "project_id" ) Long projectId ) {
		
		this.jointService.joinTeam ( userId, projectId );
		
		return "redirect:/projects";
		
	}
	
	@PostMapping("/projects/leave/{user_id}/{project_id}")
	public String leaveTeam ( @PathVariable ( "user_id" ) Long userId, @PathVariable ( "project_id" ) Long projectId ) {
		
		this.jointService.leaveTeam ( userId, projectId );
		
		return "redirect:/projects";
		
	}
	
	@GetMapping("/projects/{projectId}/tasks")
	public String showTasksPage ( @PathVariable ("projectId") Long projectId, HttpSession session, Model model, @ModelAttribute ( "task" ) Task task ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			model.addAttribute ( "project", this.projectService.findProjectById ( projectId ) );
			
			return "tasks.jsp";
			
		}
		
		return "redirect:/";
		
	}
	
	@PostMapping("/projects/{projectId}/tasks")
	public String addTask ( @Valid @ModelAttribute ( "task" ) Task task, BindingResult bindingResult, @PathVariable ( "projectId" ) Long projectId, HttpSession session ) {
		
		if ( bindingResult.hasErrors () ) {
			
			return "tasks.jsp";
			
		}
		
		Long userId = (Long) session.getAttribute ( "user_id" );
		
		this.jointService.addTask ( task, this.projectService.findProjectById ( projectId ), this.jointService.findUserById ( userId ) );
		
		return "redirect:/projects/{projectId}/tasks";
		
	}
	
}
















































