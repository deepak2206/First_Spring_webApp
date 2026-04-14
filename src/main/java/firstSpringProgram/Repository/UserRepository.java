package firstSpringProgram.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import firstSpringProgram.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{
	User findByEmail(String email);
}
