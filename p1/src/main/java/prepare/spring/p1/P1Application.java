package prepare.spring.p1;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import prepare.spring.p1.DAO.StudentDao;
import prepare.spring.p1.entity.Student;

@SpringBootApplication
public class P1Application {

	public static void main(String[] args) {
		SpringApplication.run(P1Application.class, args);
	}
	
	@Bean
	
	public CommandLineRunner commandLineRunner (StudentDao studentDao) {
		return runner -> {
			System.out.println("Hello World");
			createstudents(studentDao);
			//readRecord(studentDao);
			//printAlllist(studentDao);
			
			//deletebyname(studentDao);
		};
	}

	private void deletebyname(StudentDao studentDao) {
		
		int num=studentDao.deleteRecords();
		System.out.println("no of rows deleted: " + num);
	
	}

	private void printAlllist(StudentDao studentDao) {
		
		String regexp_cust = "\'%is%\'";
		System.out.println(regexp_cust);
		
		//List<Student> getall = studentDao.findAll();
		List<Student> getall = studentDao.findByRegExemail(regexp_cust);
		
		for (Student tempStudent : getall) {
			System.out.println(tempStudent);
		}
		
	}

	private void readRecord(StudentDao studentDao) {
		
		Student myStudent  = new Student("manavi", "isuka", "manaviisuka@gmail.com");
		studentDao.save(myStudent);
		int theId = myStudent.getId();
		//retrive data
		System.out.println("Getting the data form DB " + theId);
		
		Student readStudent = studentDao.findbyId(theId);
		
		System.out.println("the record " + readStudent.toString());
		
	}

	private void createstudents(StudentDao studentDao) {
		
		//creating the new student
		System.out.println("Creating new student object");
		Student tempStudent= new Student("Adivi", "manishi", "adivimanishi@gmail.com");
		
		// save the student object
		System.out.println("Saving the student recored.........");
		studentDao.save(tempStudent);
		
		//display student record
		
		System.out.println("student record is saved as " + tempStudent.getId());
		
		
		
	}
	
	
	
}
