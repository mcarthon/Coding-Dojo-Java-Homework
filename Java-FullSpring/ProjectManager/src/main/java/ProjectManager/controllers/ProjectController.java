package ProjectManager.controllers;

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
import ProjectManager.services.ProjectService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {

	private final ProjectService projectService;
	
	public ProjectController ( ProjectService projectService ) {
		
		this.projectService = projectService;
		
	}
	
	@GetMapping("/projects")
	public String allProjects ( Model model, HttpSession session ) {
		
		if ( session.getAttribute ( "user_id" ) != null ) {
			
			model.addAttribute ( "allProjects", this.projectService.findAllProjects () );
			
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
	public String addNewProject ( Project project, @Valid @ModelAttribute ( "newProject" ) Project newProject, BindingResult bindingResult, Model model ) {
		
		if ( bindingResult.hasErrors () ) {
			
			return "newProjectPage.jsp";
			
		}
		
		this.projectService.addProject ( newProject );
		
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
			
			model.addAttribute ( "project", this.projectService.findProjectById ( id ) );
			
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
				
				errors += bindingResult.getFieldErrors ( ).get (i).getDefaultMessage () + "\n";
				
			}
			
			model.addAttribute ( "project", this.projectService.findProjectById ( id ) );
			
			model.addAttribute ( "errors", errors );
			
			return "editPage.jsp";
			
		}
		
		this.projectService.updateProject ( project );
		
		return "redirect:/projects{id}";
		
	}
	
	@DeleteMapping("/projects/{id}")
	public String deleteProject ( @PathVariable ( "id" ) Long id ) {
		
		this.projectService.deleteProject ( id );
		
		return "redirect:/projects";
		
	}
	
}
















































