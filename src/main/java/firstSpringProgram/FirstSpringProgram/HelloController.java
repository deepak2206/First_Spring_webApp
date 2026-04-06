package firstSpringProgram.FirstSpringProgram;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
	@Autowired
	UserService userService;
//	List<User> users = new ArrayList<>();
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "hello Deepak!";
//    }
//    
//    @GetMapping("/")
//    public String home() {
//        return "Welcome to Spring Boot";
//    }
	
	// Just by adding one service layer we now removed all the actions from here and made this code clean;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{
		return userService.deleteUser(id);
	}
	
	@PutMapping("/updateUser/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User user)
	{
		return userService.updateUser(id, user);
	}
}