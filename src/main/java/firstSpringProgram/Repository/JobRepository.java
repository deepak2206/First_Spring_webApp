package firstSpringProgram.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import firstSpringProgram.Model.Job;

public interface JobRepository extends JpaRepository<Job, Integer>
{

}
