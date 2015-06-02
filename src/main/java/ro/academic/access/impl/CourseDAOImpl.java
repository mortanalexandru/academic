package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.model.Course;
import ro.academic.model.Curriculum;

/**
 * Course DAO implementation
 * @author Alexandru
 *
 */
@Repository
public class CourseDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Gets all the courses
	 * @return
	 */
	public List<Course> getCourses(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Course.class);

		List<Course> resultAsList = (List<Course>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
	
}
