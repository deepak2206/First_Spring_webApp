package firstSpringProgram.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Job 
{
	@Id
	private int id;
	private String name;
	
	@ManyToOne	
	@JoinColumn(name = "user_id")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job(int id, String name, User user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}
	
	public Job() {}
	
	
}
