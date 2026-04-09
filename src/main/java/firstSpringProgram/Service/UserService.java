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
	
	public String deleteUser(int id)
	{
		userRepository.deleteById(id);
		return "User Deleted";
	}
	
	public String updateUser(int id, User updatedUser)
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
}
