package ro.academic.access.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.academic.model.Department;
import ro.academic.model.Faculty;

@Repository
public class DepartmentDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Department> getDepartments(){
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		final Criteria criteria = session.createCriteria(Department.class);

		List<Department> resultAsList = (List<Department>) (criteria.list());

		session.getTransaction().commit();
		session.close();
		return resultAsList;
	}
}
