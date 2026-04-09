package firstSpringProgram.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firstSpringProgram.Model.Job;
import firstSpringProgram.Repository.JobRepository;

@Service
public class JobService {
	@Autowired
	JobRepository jobRepository;

	public String addJob(Job job) {
		jobRepository.save(job);
		return "Job Added !";
	}

	public List<Job> getJob() {
		return jobRepository.findAll();
	}
	
	
}
