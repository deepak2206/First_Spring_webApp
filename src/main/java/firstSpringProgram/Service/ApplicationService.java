package firstSpringProgram.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firstSpringProgram.Model.Applications;
import firstSpringProgram.Repository.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;
	
	public Applications applyJob(Applications app) {
		return applicationRepository.save(app);
	}

	public List<Applications> getApplications() {
		return applicationRepository.findAll();
	}

}
