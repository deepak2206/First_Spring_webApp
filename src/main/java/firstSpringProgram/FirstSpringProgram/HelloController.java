package firstSpringProgram.FirstSpringProgram;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
	List<User> users = new ArrayList<>();
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "hello Deepak!";
//    }
//    
//    @GetMapping("/")
//    public String home() {
//        return "Welcome to Spring Boot";
//    }
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user)
	{
		users.add(user);
		return "User added";
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers()
	{
		return users;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{
		boolean removed = users.removeIf(u -> u.getId() == id);
		
		if(removed)
			return "User deleted";
		else
			return "User not deleted";
	}
}