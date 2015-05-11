package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.model.Curriculum;
import ro.academic.model.Teacher;

@Repository
public class TeacherDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Teacher> getTeachers(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Teacher.class);

		List<Teacher> resultAsList = (List<Teacher>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
}
