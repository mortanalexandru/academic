package ro.academic.service;

import java.util.List;

import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.dto.StudentDTO;
import ro.academic.model.CurriculumCourse;
import ro.academic.model.User;

public interface CurriculumCoursesService {
	public List<CurriculumCoursesDTO> getCCByTeacher(User user);
	public List<StudentDTO> getStudentsByCC(String code);
	
}
