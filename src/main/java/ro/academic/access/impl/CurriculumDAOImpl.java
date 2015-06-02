package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.access.CurriculumDAO;
import ro.academic.model.Curriculum;
import ro.academic.model.CurriculumCourse;
import ro.academic.model.Group;
import ro.academic.model.Specialization;

/**
 * Curriculum DAO Impl
 * @author Alexandru
 *
 */
@Repository
public class CurriculumDAOImpl implements CurriculumDAO {

	
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
	
	public Curriculum getCurriculumForGroup(int group){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		final Criteria criteria = session.createCriteria(Group.class,"group");
		criteria.add(Restrictions.eq("group.name", group));
		criteria.setProjection(Projections.property("curriculum"));
		List<Curriculum> resultAsList = (List<Curriculum>) (criteria.list());
		return resultAsList.get(0);
		
	}
	
	public Curriculum getCurriculumForSemester(int semester){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		final Criteria criteria = session.createCriteria(Curriculum.class);
		criteria.add(Restrictions.eq("startSem", semester));
		criteria.setProjection(Projections.property("curriculum"));
		List<Curriculum> resultAsList = (List<Curriculum>) (criteria.list());
		return resultAsList.get(0);
	}
	
}
