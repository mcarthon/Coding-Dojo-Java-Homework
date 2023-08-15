package BookClub.models;

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
@Table ( name = "books" )
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "Title is required!")
    @Size(min = 1, max = 50, message = "Title must be between 1 and 50 characters. ")
    private String title;
    
    @NotBlank(message = "Author's name is required. ")
    @Size(min = 1, max = 30, message = "Author's name must be between 1 and 30 characters. ")
    private String authorName;
    
    @NotBlank(message = "Posted by is required. ")
    @Size(min = 1, max = 30, message = "Posted by must be between 1 and 30 characters. ")
    private String postedBy;      

	@NotBlank(message = "Your thoughts on the book are required. ")
    @Size(min = 10, max = 300, message = "Your thoughts on the book must be between 10 and 300 characters. ")
    private String myThoughts;
    
    @ManyToOne ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "user_id" )
    private User user;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Book () {}
    
    public Book ( String title, String authorName, String postedBy, String myThoughts ) {
    	
    	this.title = title;
    	
    	this.authorName = authorName;
    	
    	this.postedBy = postedBy;
    	
    	this.myThoughts = myThoughts;
    	
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getMyThoughts() {
		return myThoughts;
	}

	public void setMyThoughts(String myThoughts) {
		this.myThoughts = myThoughts;
	}

	 public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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