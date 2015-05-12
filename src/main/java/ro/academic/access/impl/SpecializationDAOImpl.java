package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.model.Department;
import ro.academic.model.Specialization;

@Repository
public class SpecializationDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Specialization> getSpecializations(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Specialization.class);

		List<Specialization> resultAsList = (List<Specialization>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
}
