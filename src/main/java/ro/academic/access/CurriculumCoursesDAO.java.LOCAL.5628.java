package ro.academic.access;

import java.util.List;

import ro.academic.model.Course;
import ro.academic.model.CurriculumCourse;
import ro.academic.model.User;

public interface CurriculumCoursesDAO {
	public List<CurriculumCourse> getCurriculumCourses();
	public List<CurriculumCourse> getCurriculumCoursesByTeacher(User user);
	public List<CurriculumCourse> getStudentsByCurriculumCourses(String code);
	public void setCurriculumCourses(Course c);
}
