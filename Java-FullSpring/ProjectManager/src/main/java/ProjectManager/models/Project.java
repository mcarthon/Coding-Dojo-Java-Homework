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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table ( name = "projects" )
public class Project {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "Title is required!")
    @Size(min = 1, max = 30, message = "Title must be between 1 and 30 characters")
    private String title;
	
	@NotBlank(message="Description is required!")
    @Size(min=1, max=300, message="Description must be between 1 and 128 characters")
    private String description;
	
	@DateTimeFormat(pattern="mm/dd/yyy")
    private Date dueDate;
	
	@ManyToMany ( fetch = FetchType.LAZY )
    @JoinTable (
    
    		name = "users_projects",
    		
    		joinColumns = @JoinColumn ( name = "project_id" ),
    		
    		inverseJoinColumns = @JoinColumn ( name = "user_id" )
    		
    )
    private List<User> users;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Project () {}
    
    public Project ( String title, String description, Date dueDate ) {
    	
    	this.title = title;
    	
    	this.description = description;
    	
    	this.dueDate = dueDate;
    	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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

















































