package firstSpringProgram.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firstSpringProgram.Model.User;
import firstSpringProgram.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String addUser(User user)
	{
		userRepository.save(user);
		return "User added !";
	}
	
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}
	
	public String deleteUser(Integer id)
	{
		userRepository.deleteById(id);
		return "User Deleted";
	}
	
	public String updateUser(Integer id, User updatedUser)
	{
		User existingUser = userRepository.findById(id).orElse(null);
		if(existingUser == null)
			return "User not Found";
		if(updatedUser.getName() != null)
		{
			existingUser.setName(updatedUser.getName());
		}
		
		userRepository.save(existingUser);
		
		return "User Updated";
	}
	
	public String login(User user)
	{
		User existingUser = userRepository.findByEmail(user.getEmail());
		if(existingUser == null)
		{
			return "User not found";
		}
		if(existingUser.getPassword().equals(user.getPassword()))
		{
			return "Login Successfull";
		}
		else
		{
			return "Invalid Credintials";
		}
	}
}
