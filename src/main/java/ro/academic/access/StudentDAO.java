package ro.academic.access;

import java.util.List;

import org.springframework.stereotype.Repository;

import ro.academic.model.ContractCourse;
import ro.academic.model.Student;
import ro.academic.model.User;

/**
 * Student Data access
 * @author Alexandru
 *
 */
public interface StudentDAO {

	/**
	 * Gets all the students
	 * @return
	 */
	public List<Student> getStudents();
	
	/**
	 * Gets Student for a given user
	 * @return
	 */
	public Student getStudentByUser(User user);
	

}
