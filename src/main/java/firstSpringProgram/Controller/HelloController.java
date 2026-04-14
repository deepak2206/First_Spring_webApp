package firstSpringProgram.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import firstSpringProgram.Model.Applications;
import firstSpringProgram.Model.Job;
import firstSpringProgram.Model.User;
import firstSpringProgram.Service.ApplicationService;
import firstSpringProgram.Service.JobService;
import firstSpringProgram.Service.UserService;
import jakarta.validation.Valid;

@RestController
public class HelloController {
    
	@Autowired
	UserService userService;
	
	@Autowired
	JobService jobService;
	
	@Autowired
	ApplicationService applicationService;
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

// Mappings for Users 
	@PostMapping("/addUser")
	public String addUser(@Valid @RequestBody User user)
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
	
//Mapping for Jobs
	
	@PostMapping("/addJob")
	public String addJob(@RequestBody Job job)
	{
		return jobService.addJob(job);
	}
	
	@GetMapping("/getJob")
	public List<Job> getJob()
	{
		return jobService.getJob();
	}
	
//Mapping for Applications
	
	@PostMapping("/applyJob")
	public Applications applyJob(@RequestBody Applications applications)
	{
		return applicationService.applyJob(applications);
	}
	
	@GetMapping("/getApplications")
	public List<Applications> getApplications()
	{
		return applicationService.getApplications();		
	}
	
//Mapping for login
	
	@PostMapping("/Login")
	public String login(@RequestBody User user)
	{
		return userService.login(user);
	}
	
}