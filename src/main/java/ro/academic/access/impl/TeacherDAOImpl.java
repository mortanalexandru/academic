package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.access.TeacherDAO;
import ro.academic.model.Curriculum;
import ro.academic.model.Student;
import ro.academic.model.Teacher;
import ro.academic.model.User;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Teacher> getTeachers(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Teacher.class);

		List<Teacher> resultAsList = (List<Teacher>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
	public Teacher getTeacherByUser(User user) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Teacher.class);
		criteria.add(Restrictions.eq("user", user));
		List<Teacher> resultAsList = (List<Teacher>) (criteria.list());
		
		session.getTransaction().commit();
		session.close();
		return resultAsList.get(0);
	}
	
	public void saveGrades(User user, int grade)
	{
		
	}
}
