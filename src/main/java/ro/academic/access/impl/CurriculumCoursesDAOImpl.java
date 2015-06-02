package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.access.CurriculumCoursesDAO;
import ro.academic.model.ContractCourse;
import ro.academic.model.Course;
import ro.academic.model.CurriculumCourse;
import ro.academic.model.Student;
import ro.academic.model.User;

/**
 * Curriculum Course DAO implementation
 * @author Alexandru
 *
 */
@Repository
public class CurriculumCoursesDAOImpl implements CurriculumCoursesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<CurriculumCourse> getCurriculumCourses(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(CurriculumCourse.class);
		List<CurriculumCourse> resultAsList = (List<CurriculumCourse>) (criteria.list());

		return resultAsList;
	}
	
	public List<CurriculumCourse> getCurriculumCoursesByTeacher(User user)
	{
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		final Criteria criteria = session.createCriteria(CurriculumCourse.class,"contract");
		criteria.createAlias("contract.teacher", "teacher"); // inner join by default
		criteria.add(Restrictions.eq("teacher.user", user));
		List<CurriculumCourse> resultAsList = (List<CurriculumCourse>) (criteria.list());
		return resultAsList;
		
		
	}
	public List<CurriculumCourse> getStudentsByCurriculumCourses(String code)
	{
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		final Criteria criteria = session.createCriteria(CurriculumCourse.class, "curriculum");
		criteria.createAlias("curriculum.course", "course");
		criteria.add(Restrictions.eq("course.code", code));
		List<CurriculumCourse> result = (List<CurriculumCourse>) (criteria.list());
		
		return result;
		
	}
	

	public void setCurriculumCourses(Course c) {
		
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
