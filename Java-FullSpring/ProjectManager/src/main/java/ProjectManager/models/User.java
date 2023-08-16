package ProjectManager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table ( name = "users" )
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="Name is required!")
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
    private String name;
    
    @NotBlank(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotBlank(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotBlank(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    
    @OneToMany ( mappedBy = "teamLead", fetch = FetchType.LAZY )
    private List<Project> teamLeadProjects;
    
    @ManyToMany ( fetch = FetchType.LAZY )
    @JoinTable (
    
    		name = "users_projects",
    		
    		joinColumns = @JoinColumn ( name = "user_id" ),
    		
    		inverseJoinColumns = @JoinColumn ( name = "project_id" )
    		
    )
    private List<Project> projects;
    
    @OneToMany ( mappedBy = "author", fetch = FetchType.LAZY )
    private List<Task> tasks;
        
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
      
	public User() {}
    
    public User ( String name, String email, String password, String confirm ) {
    	
    	this.name = name;
    	
    	this.email = email;
    	
    	this.password = password;
    	
    	this.confirm = confirm;
    	
    }        

	@PrePersist
    protected void onCreate(){
    	
        this.createdAt = new Date();
        
    }

	@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<Project> getTeamLeadProjects() {
		return teamLeadProjects;
	}

	public void setTeamLeadProjects(List<Project> teamLeadProjects) {
		this.teamLeadProjects = teamLeadProjects;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}