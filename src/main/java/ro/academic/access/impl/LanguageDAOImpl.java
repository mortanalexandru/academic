package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.model.Faculty;
import ro.academic.model.Language;

@Repository
public class LanguageDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Language> getLanguages(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Language.class);

		List<Language> resultAsList = (List<Language>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
}
