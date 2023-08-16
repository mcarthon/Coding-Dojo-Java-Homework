package ProjectManager.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table ( name = "tasks" )
public class Task {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn ( name = "author" )
	private User author;	
	
	@ManyToOne ( fetch = FetchType.LAZY )
	@JoinColumn ( name = "project" )
	private Project project;
	
	@NotBlank(message="Description is required!")
    @Size(min=1, max=300, message="Description must be between 1 and 128 characters")
    private String description;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Task () {}
    
    public Task ( User author, Project project, String description ) {
    	
    	this.author = author;
    	
    	this.project = project;
    	
    	this.description = description;
    	
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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