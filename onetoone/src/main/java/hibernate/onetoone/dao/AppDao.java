package hibernate.onetoone.dao;

import org.springframework.stereotype.Repository;

import hibernate.onetoone.model.Instructor;


public interface AppDao {
	
	void save(Instructor theInstructor);
	
	Instructor findbyId(int findid);
	
	
	void deleteuserbyId(int byid);
	

}
