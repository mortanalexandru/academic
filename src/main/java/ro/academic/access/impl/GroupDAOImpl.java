package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.model.Faculty;
import ro.academic.model.Group;

@Repository
public class GroupDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Group> getGroups(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Group.class);

		List<Group> resultAsList = (List<Group>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
	
}
