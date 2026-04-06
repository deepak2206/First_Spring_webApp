package firstSpringProgram.FirstSpringProgram;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	List <User> users = new ArrayList<>();
	
	public String addUser(User user)
	{
		users.add(user);
		return "User added !";
	}
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public String deleteUser(int id)
	{
		boolean removed = users.removeIf(u -> u.getId() == id);
		return removed ? "User Deleted" : "User not Found";
	}
	
	public String updateUser(int id, User updatedUser)
	{
		for(User u: users)
		{
			if(u.getId() == id)
			{
				u.setName(updatedUser.getName());
				return "User Updated!";
			}
			
		}
		return "User Not Found";
	}
}
