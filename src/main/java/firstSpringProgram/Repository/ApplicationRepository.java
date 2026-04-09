package firstSpringProgram.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import firstSpringProgram.Model.Applications;

public interface ApplicationRepository extends JpaRepository<Applications, Integer>{

}
