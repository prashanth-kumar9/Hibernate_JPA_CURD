package prepare.spring.p1.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import prepare.spring.p1.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	private EntityManager entityManager;
	
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
		
	}

	@Override
	public Student findbyId(Integer id) {
		Student tempStudent = entityManager.find(Student.class, id);
		return tempStudent;
	}

	@Override
	public List<Student> findAll() {
		
		//creating query
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
		//return query
		return theQuery. getResultList();
	}

	@Override
	public List<Student> findByRegExemail(String regex_param) {
		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where email like :theData", Student.class);
		
		//Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.department = :dept");

		
		// Output: SELECT e FROM Employee e WHERE e.department = :dept
		
		theQuery.setParameter("theData", regex_param);
		// Unwrap the query string directly
				String queryString = theQuery.unwrap(org.hibernate.query.Query.class).getQueryString();
				System.out.println("Executing HQL: " + queryString); 
		//return query
		return theQuery. getResultList();
	}

	@Override
	public int updatetheRecord(Student theStudent) {
		
		int count = entityManager.createQuery("UPDATE ").executeUpdate();
		return count;
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
		
	}

	@Override
	@Transactional
	public int deleteRecords() {
		int query1= entityManager.createQuery("DELETE FROM Student").executeUpdate();
		
		
		return query1;
		
		
		
	}
	
	
	

}
