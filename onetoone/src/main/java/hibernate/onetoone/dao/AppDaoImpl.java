package hibernate.onetoone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.onetoone.model.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
public class AppDaoImpl implements AppDao{
	
	
	
	private EntityManager entityManager;
	
	@Autowired
	public AppDaoImpl(EntityManager entityManager) {
		this.entityManager= entityManager;
	}
	
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
		
	}


	@Override
	public Instructor findbyId(int findid) {
		Instructor details = entityManager.find(Instructor.class, findid);
		return details;
	}


	@Override
	@Transactional
	public void deleteuserbyId(int byid) {
		Instructor details = entityManager.find(Instructor.class, byid);
		
		entityManager.remove(details);
		
	}

}
