package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.access.StudentDAO;
import ro.academic.model.Faculty;
import ro.academic.model.Student;
import ro.academic.model.User;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Student> getStudents(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Student.class);

		List<Student> resultAsList = (List<Student>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}

	@Override
	public Student getStudentByUser(User user) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("user", user));
		List<Student> resultAsList = (List<Student>) (criteria.list());
		
		session.getTransaction().commit();
		session.close();
		return resultAsList.get(0);
	}
	
}
