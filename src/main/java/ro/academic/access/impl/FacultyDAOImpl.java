package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.model.Faculty;
import ro.academic.model.User;

@Repository
public class FacultyDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Faculty> getFaculties(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Faculty.class);

		List<Faculty> resultAsList = (List<Faculty>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
	
}
