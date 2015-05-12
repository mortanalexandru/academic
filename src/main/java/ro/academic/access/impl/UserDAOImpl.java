package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.access.UserDAO;
import ro.academic.model.User;

/**
 * User DAO implementation
 * @author Alexandru
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserByUsername(String username) {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		   User result = null;
		   criteria.add(Restrictions.eq("username", username));
		   List<User> resultAsList = (List<User>) (criteria.list());
		   if (!resultAsList.isEmpty()) {
		    result = resultAsList.get(0);
		   }
		  
		return result;
	}
}
