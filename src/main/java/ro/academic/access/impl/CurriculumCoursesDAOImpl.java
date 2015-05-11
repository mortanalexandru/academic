package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.model.Course;
import ro.academic.model.CurriculumCourse;

/**
 * Curriculum Course DAO implementation
 * @author Alexandru
 *
 */
@Repository
public class CurriculumCoursesDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<CurriculumCourse> getCurriculumCourses(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(CurriculumCourse.class);

		List<CurriculumCourse> resultAsList = (List<CurriculumCourse>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
}
