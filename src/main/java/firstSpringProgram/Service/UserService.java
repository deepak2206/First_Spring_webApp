package firstSpringProgram.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import firstSpringProgram.Model.User;
import firstSpringProgram.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserRepository userRepository;
	
	public User addUser(User user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
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
		if(encoder.matches(user.getPassword(), existingUser.getPassword()))
		{
			return "Login Successfull";
		}
		else
		{
			return "Invalid Credintials";
		}
	}
}
