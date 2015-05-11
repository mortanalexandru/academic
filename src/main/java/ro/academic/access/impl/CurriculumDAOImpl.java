package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.model.Curriculum;
import ro.academic.model.Specialization;

/**
 * Curriculum DAO Impl
 * @author Alexandru
 *
 */
@Repository
public class CurriculumDAOImpl {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Curriculum> getCurriculums(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Curriculum.class);

		List<Curriculum> resultAsList = (List<Curriculum>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
}
