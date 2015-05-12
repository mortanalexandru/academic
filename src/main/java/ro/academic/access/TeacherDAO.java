package ro.academic.access;

import java.util.List;

import ro.academic.model.Teacher;
import ro.academic.model.User;

public interface TeacherDAO {
	/**
	 * Gets all the Teachers
	 * @return
	 */
	public List<Teacher> getTeachers();
	
	/**
	 * Gets Teacher for a given user
	 * @return
	 */
	public Teacher getTeacherByUser(User username);
}
