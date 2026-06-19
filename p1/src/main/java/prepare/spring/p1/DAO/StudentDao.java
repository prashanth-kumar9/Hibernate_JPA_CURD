package prepare.spring.p1.DAO;

import java.util.List;

import prepare.spring.p1.entity.Student;

public interface StudentDao {
	
	void save(Student theStudent);
	
	 Student findbyId(Integer id);
	 
	 List<Student> findAll();
	 
	 List<Student> findByRegExemail(String regex_param);
	 
	 int updatetheRecord(Student theStudent);
	 
	 void update(Student theStudent);
	 
	 int deleteRecords();
	 

}
