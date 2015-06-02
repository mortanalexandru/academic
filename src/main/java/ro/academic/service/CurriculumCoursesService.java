package ro.academic.service;

import java.util.List;
import java.util.Map;

import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.dto.StudentDTO;
import ro.academic.model.CurriculumCourse;
import ro.academic.model.User;

public interface CurriculumCoursesService {
	public List<CurriculumCoursesDTO> getCCByTeacher(User user);
  public List<CurriculumCoursesDTO> getAllCC();
	public List<StudentDTO> getStudentsByCC(String code);
	public void approveCourses(Map<String, Boolean> courses);
	
}
