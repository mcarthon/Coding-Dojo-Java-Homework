package JoyBundler.models;

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
@Table ( name = "babynames" )
public class BabyNames {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Baby Name is required!")
    @Size(min = 2, max = 30, message="Name must be between 2 and 30 characters")
    private String name;
	
	@ManyToMany ( fetch = FetchType.LAZY )
	@JoinTable ( 
			
			name = "users_names",
			
			joinColumns = @JoinColumn ( name = "name_id" ),
			
			inverseJoinColumns = @JoinColumn ( name = "user_id" )
			
			)
	private List<User> users;
	
	@NotBlank ( message = "Typical Gender must be selected. " )
	private String gender;
	
	@NotBlank(message="Origin is required!")
    @Size(min = 1, max = 30, message="Origin must be between 1 and 30 characters")
    private String origin;
	
	@NotBlank(message="The meaning of the name is required!")
    @Size(min = 1, max = 100, message="Name meaning must be between 1 and 100 characters")
    private String meaning;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
      
    public BabyNames () {}
    
    public BabyNames ( String name, List<User> users, String gender, String origin, String meaning ) {
    	
    	this.name = name;
    	
    	this.users = users;
    	
    	this.gender = gender;
    	
    	this.origin = origin;
    	
    	this.meaning = meaning;
    	
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
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