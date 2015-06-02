package ro.academic.access;

import java.util.List;

import ro.academic.model.Course;

public interface CourseDAO {

	public List<Course> getCourses();
	
	public Course getCourseByCode(String code);
	
	public void deleteCourse(Course course);
}
