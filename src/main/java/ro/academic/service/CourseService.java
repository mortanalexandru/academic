package ro.academic.service;

import java.util.List;

import ro.academic.dto.CurriculumCoursesDTO;

public interface CourseService {

	public List<CurriculumCoursesDTO> getUnaprovedCourses();
	
	
}
