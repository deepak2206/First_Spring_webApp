package firstSpringProgram.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
	
	@Id
	private Integer id;
	
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Job> jobs;
	
	public User()
	{
		
	}
	public User(Integer id, String name)
	{
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	
}

