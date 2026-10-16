package hibernate.onetoone;

//import java.beans.BeanProperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hibernate.onetoone.dao.AppDao;
import hibernate.onetoone.model.Instructor;
import hibernate.onetoone.model.InstructorDetail;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class OnetooneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetooneApplication.class, args);
	}

	@Bean

	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			//createInstuctor(appDao);
			
			System.out.println(find(appDao, 1));
			
			deleteuser(appDao, 2);

		};
	}

	private void deleteuser(AppDao appDao, int i) {
		appDao.deleteuserbyId(i);
	}

	private Instructor find(AppDao appDao, int i) {
		
		
		return appDao.findbyId(i);
		
	}

	private void createInstuctor(AppDao appDao) {
		Instructor theInstructor = new Instructor("prashanth", "kumar", "prashath@gmail.com");
		
		InstructorDetail theInstructorDetail = new InstructorDetail("www.gixer.com", "timepass");
		
		
		theInstructor.setInstructorDetail(theInstructorDetail);
		
		
		System.out.println(theInstructor);
		
		appDao.save(theInstructor);
	}
}
