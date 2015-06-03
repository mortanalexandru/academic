package ro.academic.access;

import java.util.List;

import ro.academic.model.Course;
import ro.academic.model.CurriculumCourse;
import ro.academic.model.User;

public interface CurriculumCoursesDAO {
	public List<CurriculumCourse> getCurriculumCourses();
	public List<CurriculumCourse> getCurriculumCoursesByTeacher(User user);
	public List<CurriculumCourse> getStudentsByCurriculumCourses(String code);
<<<<<<< HEAD
	public void setCurriculumCourses(Course c);
=======
	public void saveCurriculumCourse(List<CurriculumCourse> courses);
>>>>>>> 7062230ec94e09d1bebbcc91678f2a83f1ba294d
}
