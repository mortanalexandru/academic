package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.access.CourseDAO;
import ro.academic.model.Course;
import ro.academic.model.Curriculum;
import ro.academic.model.Student;

/**
 * Course DAO implementation
 * @author Alexandru
 *
 */
@Repository
public class CourseDAOImpl implements CourseDAO {

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
	
	public Course getCourseByCode(String code){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Course.class);
		criteria.add(Restrictions.eq("code", code));
		List<Course> resultAsList = (List<Course>) (criteria.list());
		session.getTransaction().commit();
		session.close();
		return resultAsList.get(0);
		
	}

	@Override
	public void deleteCourse(Course course) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(course);
		session.getTransaction().commit();
		session.close();
	}
	
}
